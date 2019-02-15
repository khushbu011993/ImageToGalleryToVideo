package com.example.think.myapplication11;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {
   ImageView imageView;
    Button button;
    private static final int PICK_IMAGE=100;
    Uri image_uri;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageview);
        button=(Button)findViewById(R.id.btn);
        mediaController=new MediaController(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openGallery();
            }
        });
    }


     /* use gallery to video
     * layout video view and this*/

     /* private void openGallery()
      {
          Intent gallery=new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
          startActivityForResult(gallery,PICK_VIDEO);
      }*/

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK  && requestCode==PICK_IMAGE)
        {
        image_uri=data.getData();
         imageView.setImageURI(image_uri);
          mediaController.setAnchorView(imageView);
         // imaView.setImageURI(mediaController);
          //imageView.setImageBitmap(image_uri);

        }
    }
}