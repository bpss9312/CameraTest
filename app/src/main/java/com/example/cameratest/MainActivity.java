package com.example.cameratest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public ImageView iv;
    public Button bt;

    public File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iv);
        bt = (Button) findViewById(R.id.bt);
    }

    public void click(View v) {
        //Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
        capture();
    }

    public void capture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==0 && resultCode==RESULT_OK){

            Bundle e = data.getExtras();
            Bitmap bit = (Bitmap) e.get("data");
            iv.setImageBitmap(bit);

        }

    }

}