package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowToast(View view){
        Toast.makeText(this, "토스트 먹고싶다 에그토스트로다가", Toast.LENGTH_SHORT) //makeText메소드는 toast객체를 리턴
        .show(); //그 리턴값을 show해준다

       /* Toast toast = Toast.makeText(this, "토스트 먹고싶다 에그토스트로다가", Toast.LENGTH_SHORT);
        toast.show();*/
    }

    public  void onClickShowMessageDialog(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("에그토스트사주세요")
                .setPositiveButton("확인",null)
                .show();
    }

    public  void onClickShowYesNoDialog(View view){
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setMessage("에그토스트사줄꺼야?")
                .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "아니오를 선택", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "예를 선택", Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .show();
    }

    public void onClickShowCustomDialog(View view){
        View content = getLayoutInflater().inflate(R.layout.light_dialog, null);
        Button btnOk = (Button) content.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"확인을 선택", Toast.LENGTH_SHORT).show();
            }
        });
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("알림")
                .setView(content)
                .show();
    }
}
