package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lightList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightList =  (ListView) findViewById(R.id.lightList);
        fillItems();
    }

    public void fillItems(){
        List<Light> list = new ArrayList<>();
        list.add(new Light(R.drawable.light1,"인테리어 조명1", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명3", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명7", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명9", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명10", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명1", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명2", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명3", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명4", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명5", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명6", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명7", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명8", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명9", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light(R.drawable.light1,"인테리어 조명10", "거실등으로 사용하면 좋습니다 검은색 테두리와 백열등의 조화가 이쁩니다."));

        ListAdapter lightAdapter = new LightAdapter(this);
        lightAdapter.setList(list);

        lightList.setAdapter(lightAdapter);
    }
}
