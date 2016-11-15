package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private LinearLayout itemContainer;
    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
        layoutInflater = getLayoutInflater();

        fillItems();
    }

    public void fillItems() {
        int arrImage[] = {
                R.drawable.food01,
                R.drawable.food02,
                R.drawable.food03,
                R.drawable.food04,
                R.drawable.food05
        };

        String arrTitle[] = {
                "name1",
                "name2",
                "name3",
                "name4",
                "name5"

        };

        String arrPrice[]={
                "35000won",
                "30000won",
                "32000won",
                "20000won",
                "25000won"
        };

        String arrContent[] ={
            "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area.",
                "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."
        };

        for (int i = 0; i < 5; i++) {
            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.food_item, null);

            ImageView foodimage = (ImageView) itemLayout.findViewById(R.id.foodimage);
            foodimage.setImageResource(arrImage[i]);

            TextView foodtitle = (TextView) itemLayout.findViewById(R.id.foodtitle);
            foodtitle.setText(arrTitle[i]);

            TextView foodprice = (TextView) itemLayout.findViewById(R.id.foodprice);
            foodprice.setText(arrPrice[i]);

            TextView foodcontent = (TextView) itemLayout.findViewById(R.id.foodcontent);
            foodcontent.setText(arrContent[i]);

            itemContainer.addView(itemLayout);
        }
    }
}
