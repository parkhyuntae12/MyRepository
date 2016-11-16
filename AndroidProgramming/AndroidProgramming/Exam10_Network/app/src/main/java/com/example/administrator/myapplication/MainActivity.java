package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageLarge;
    private ListView lightList;
    private LightAdapter lightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final Light light = (Light) lightAdapter.getItem(position);

            AsyncTask<Void, Void,Bitmap> asyncTask = new AsyncTask<Void, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(Void... params) {
                    return getBitmap(light.getImageLargeFileName());
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    imageLarge.setImageBitmap(bitmap);
                }
            };
               asyncTask.execute();
            }
        });
        testAsyncTask();
        fillItems();
    }

    public void testAsyncTask() {
        Log.i("mylog", "1:" + Thread.currentThread().getName());
        AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {// AsyncTask<Void, Void, Void>  의 3번째 타입이 doinbackground의 타입이 뭔지 결정해주는것 1번째타입은 execute의 타입과 같아야 한다
                //2번째 타입은 작업이 진행되고 있을때 publishProgress메소드의 실행 매개값 타입을 결정
                Log.i("mylog", "2:" + Thread.currentThread().getName());//현재 사용하고 있는 스레드 이름
                Log.i("mylog", params[0]);
                Log.i("mylog", params[1]);
                Log.i("mylog", params[2]);
                for (int i = 1; i <=100; i++) {
                    if (i == 1) {
                        publishProgress(1);
                    } else if (i == 50) {
                        publishProgress(50);
                    } else if (i == 100) {
                        publishProgress(100);
                    }
                }
                return "작업스레드 결과"; // void이기때문에 null을 리턴  이 리턴값이 onPostExecute(String aVoid) () 안으로 들어감
            }

            @Override
            protected void onProgressUpdate(Integer... values) { //혼자 실행안됨 doitbackground가 실행되야 함
                Log.i("mylog", "3:" + Thread.currentThread().getName());
                Log.i("mylog", "작업진행정도:" + values[0]);
            }

            @Override
            protected void onPostExecute(String aVoid) {//AsyncTask<Void, Void, Void>  의 3번째 타입이 onPostExecute의 매개타입
                Log.i("mylog", "4:" + Thread.currentThread().getName());
                Log.i("mylog", aVoid);
            }
        };
        asyncTask.execute("실행매개값", "실행매개값2", "실행 매개값3"); // execute 값은 doInBackground(String... params) 안으로 들어간다
    }
     public void fillItems() {
         AsyncTask<Void,Void,List<Light>> asyncTask = new AsyncTask<Void, Void, List<Light>>() { //3번째 타입을 가장 먼저 정해줘야 한다
             @Override
             protected List<Light> doInBackground(Void... params) {
                 List<Light> list = null;
                 try {
                     URL url = new URL("http://192.168.0.13:8080/myandroid/lightList");
                     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                     conn.connect();

                     if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                         InputStream is = conn.getInputStream();
                         Reader reader = new InputStreamReader(is);
                         BufferedReader br = new BufferedReader(reader);
                         String strJson = "";
                         while (true) {
                             String data = br.readLine();
                             if (data == null) break;
                             strJson += data;
                         }
                         br.close();
                         reader.close();
                         is.close();
                         list = parseJson(strJson);
                     }
                     conn.disconnect();
                 } catch (Exception e) {
                     Log.i("mylog", e.getMessage());
                 }
                 return list;
             }
             @Override
             protected void onPostExecute(List<Light> lights) {
                 lightAdapter = new LightAdapter(MainActivity.this);
                 lightAdapter.setList(lights);
                 lightList.setAdapter(lightAdapter);
                 imageLarge.setImageBitmap(lights.get(0).getImageLarge());
             }
         };
         asyncTask.execute();
    }

    public List<Light> parseJson(String strJson) {
        List<Light> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Light light = new Light();
                light.setImage(getBitmap(jsonObject.getString("image")));
                if(i==0) {
                    light.setImageLarge(getBitmap(jsonObject.getString("imageLarge")));
                }
                light.setImageFileName(jsonObject.getString("image"));
                light.setImageLargeFileName(jsonObject.getString("imageLarge"));
                light.setTitle(jsonObject.getString("title"));
                light.setContent(jsonObject.getString("content"));
                list.add(light);
            }
        } catch (JSONException e) {
            Log.i("mylog", e.getMessage());
        }
        return list;
    }

    public Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        try {
            URL url = new URL("http://192.168.0.13:8080/myandroid/getImage?fileName=" + fileName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
            }

            conn.disconnect();
        } catch (Exception e) {
            Log.i("mylog", e.getMessage());
        }
        return bitmap;
    }
}
