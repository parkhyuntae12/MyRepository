package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LightAdapter extends BaseAdapter{ //추상메소드가 있는 추상클래스
    private List<Light> list;

    public void setList(List<Light> list) {
        this.list = list;
    }
    private Context context;
    private LayoutInflater layoutInflater;

    public LightAdapter(Context context){ //범용적(다른 액티비티에도 적용가능), 모든 액티비티는 context정보를 갖고잇어야한다, 매개변수에 context가 있을경우 어떠한 값도 받을 수 있다 inplate를 받기위한 목적
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { //아이템이 없는 아이디도 올수 있다 아이디는 식별값 아이디와 포지션은 다르다 :: 인덱스가 식별번호가 된다
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ViewGroup = listView, position = 데이터순번, convertView = (null아니면 재사용 null이면 xml의 내용을 inplation해야함) 재사용되는 데이터(스크롤된 데이터)가 들어온다
        if(convertView == null){
            //inplation
            convertView = layoutInflater.inflate(R.layout.light_item, null); //inplation
        }
        //data setting
        Light light = list.get(position);

        ImageView lightImage = (ImageView) convertView.findViewById(R.id.lightImage);
        lightImage.setImageResource(light.getImage());

        TextView lightTitle = (TextView) convertView.findViewById(R.id.lighttitle);
        lightTitle.setText(light.getTitle());

        TextView lightContent = (TextView) convertView.findViewById(R.id.lightcontent);
        lightContent.setText(light.getContent());

        return convertView;
    }
}
