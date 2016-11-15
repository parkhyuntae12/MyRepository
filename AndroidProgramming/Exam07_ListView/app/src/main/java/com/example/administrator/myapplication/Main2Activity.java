package com.example.administrator.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutinflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutinflater = getLayoutInflater();
        fillItems();
    }
    public void fillItems(){
        int[] arrImage = {
                R.drawable.light1,
                R.drawable.light2,
                R.drawable.light3,
                R.drawable.light4,
                R.drawable.light5
        };
        String [] arrName = {
                "Name",
                "Name",
                "Name",
                "Name",
                "Name"
        };
        String [] arrPrice = {
                "35,000 Won",
                "35,000 Won",
                "35,000 Won",
                "35,000 Won",
                "35,000 Won"
        };
        String [] arrContent = {
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."
        };
        for(int i=1; i<5; i++){
            //lnplation
            LinearLayout itemLayout = (LinearLayout) layoutinflater.inflate(R.layout.light_item, null);

            //Data setting
            ImageView lightImage = (ImageView) itemLayout.findViewById(R.id.lightImage);
            lightImage.setImageResource(arrImage[i]);
            TextView lightName = (TextView) itemLayout.findViewById(R.id.lightName);
            lightName.setText(arrName[i]);
            TextView lightPrice = (TextView) itemLayout.findViewById(R.id.lightPrice);
            lightPrice.setText(arrPrice[i]);
            TextView lightContent = (TextView) itemLayout.findViewById(R.id.lightContent);
            lightContent.setText(arrContent[i]);

            //itemContent의 내부객체 추가
            itemContainer.addView(itemLayout);
        }
    }
}
