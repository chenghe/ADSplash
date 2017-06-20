package com.example.hechengbin.adapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private CountDownView countDownView;
    private String cachePicturePath;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //根目录下创建文件夹下载
        cachePicturePath = Environment.getExternalStorageDirectory() + "/MXClient/Picture/";
        FileUtils.makeRootDirectory(cachePicturePath);

        //判断是否下载成功新的图片
        iv = (ImageView) findViewById(R.id.iv);
        Bitmap ivSrc = BitmapFactory.decodeFile(cachePicturePath + "tfayad.jpg");
        if (ivSrc == null){
//            ivSrc = BitmapFactory.decodeFile(cachePicturePath + "test1.jpg");
            iv.setImageResource(R.drawable.ad_default);
        }else {
            iv.setImageBitmap(ivSrc);
        }

        countDownView = (CountDownView) findViewById(R.id.countdownview);
        Intent serviceIntent = new Intent(this, Adservice.class);
        startService(serviceIntent);

        countDownView.start();
        countDownView.setCountDownTimerListener(new CountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {
//                Toast.makeText(getApplicationContext(), "开始计时", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinishCount() {
//                Toast.makeText(getApplicationContext(), "结束计时", Toast.LENGTH_SHORT).show();
                launchApp();
            }
        });

        countDownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchApp();
            }
        });
    }

    private void launchApp() {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
