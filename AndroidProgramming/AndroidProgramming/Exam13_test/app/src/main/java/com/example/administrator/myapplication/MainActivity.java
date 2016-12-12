package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.administrator.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //부모가 가지고 있는 메소드내용도 필요하고 더 추가해서 사용하고 싶을때 지금과 같은 형태가 나온다.
        setContentView(R.layout.activity_main); //내용상의 뷰 내용을 보여준다.(시각화)
        Log.i("mylog","onCreate()");
    }


    @Override
    protected void onStart() { //서비스를 시작할 코드를 여기다 많이들 사용
        super.onStart();
        Log.i("mylog","onStart()");
    }

    @Override
    protected void onResume() { //사용자가 어떤 화면을 사용할때 ,음악을 일시정지했다가 다시 시작할 경우
        super.onResume();
        Log.i("mylog","onResume()");
    }

    //화면이 없어지면 아래 순서대로 메소드가 실행된다. 여기가 기점이다.

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mylog","onPause()");
    }//사용자가 당장 화면을 당장사용할수 없는 상태가 되면 이 메소드가 실행.

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mylog","onStop()");
    } //서비스 중지


    @Override
    protected void onDestroy() { //화면 삭제(파괴)
        super.onDestroy();
        Log.i("mylog","onDestroy()");
    }


}