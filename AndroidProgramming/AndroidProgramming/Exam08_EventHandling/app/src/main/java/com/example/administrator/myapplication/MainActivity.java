package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;
    private Button button2;
    private List<Light> list;
    private ImageView imageLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //R은 res 폴더를 의미 (Resource 참조)

        imageLarge = (ImageView) findViewById(R.id.imageLarge);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class); // 중첩객체에서 그냥 this 만 뜨면 setOnclick리스너를 의미.
                startActivity(intent);
            }
        });
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

    public void fillItems()
    {
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
    }

    public void onClickButton1(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class); // 현재 화면을 SecondActivity클래스로 만든 화면으로 바꾸고 싶다. 라는 의미다.
        startActivity(intent);

    }
}
