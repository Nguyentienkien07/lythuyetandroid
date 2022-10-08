package com.example.ntk_thtuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView txtDetail, txtmoTa;
    ImageView imgHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imgBack= (ImageView)
                findViewById(R.id.backdetail);
        imgBack.setOnClickListener(new
                                           View.OnClickListener() {
                                               public void onClick(View v) {
                                                   finish();
                                               }
                                           });


        txtDetail = (TextView) findViewById(R.id.textViewFriend);
        txtmoTa = (TextView) findViewById(R.id.textviewMoTa);
        imgHinh = (ImageView) findViewById(R.id.imageviewHinh);




        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");
        txtDetail.setText(ten);
        String mota = intent.getStringExtra("moTa");
        txtmoTa.setText(mota);
        int hinh = intent.getIntExtra("hinh", 1);
        imgHinh.setImageResource(hinh);


    }
}