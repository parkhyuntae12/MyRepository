package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


import java.io.BufferedInputStream;
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
    private ListView lightList;
    private List<Light> list;
    private ImageView imageLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //R은 res 폴더를 의미 (Resource 참조)

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        lightList = (ListView) findViewById(R.id.lightList);
        lightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Light light = list.get(position);
                imageLarge.setImageResource(light.getImageLarge());
            }
        });
        fillItems();
        }

        //HTTP 통신 코드 (지속적 연결할 필요가 없고 요청해서 받아오는 수준이라면 비용이 더적게 드는 http통신 코드를 쓰는게 좋다)
    public void fillItems()
    {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.0.61:8080/myandroid/lightList");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){//HTTP_OK==200
                            InputStream is = conn.getInputStream();
                            Reader reader = new InputStreamReader(is);
                            BufferedReader br = new BufferedReader(reader);
                            String strJson = "";
                            while(true){
                                String data = br.readLine();//한줄전체를 읽는다
                                if(data == null) break;
                                strJson +=data;
                            }
                            br.close(); reader.close(); is.close();
                            Log.i("mylog", strJson);
                        }



                    conn.disconnect();

                } catch (Exception e) {
                    Log.i("mylog", e.getMessage());
                }
            }
        };
        thread.start();





        /*
        list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,R.drawable.light1_large,"인테리어 조명1","거실등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2,R.drawable.light2_large,"인테리어 조명2","욕실등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3,R.drawable.light3_large,"인테리어 조명3","자녀방등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4,R.drawable.light4_large,"인테리어 조명4","현관등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5,R.drawable.light5_large,"인테리어 조명5","안방등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,R.drawable.light1_large,"인테리어 조명6","거실등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light2,R.drawable.light2_large,"인테리어 조명7","욕실등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light3,R.drawable.light3_large,"인테리어 조명8","자녀방등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light4,R.drawable.light4_large,"인테리어 조명9","현관등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light5,R.drawable.light5_large,"인테리어 조명10","안방등으로 사용하면 좋습니다.검은색 테두리와 백열등의 조화가 이쁩니다."));


        LightAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
        */
    }

}
