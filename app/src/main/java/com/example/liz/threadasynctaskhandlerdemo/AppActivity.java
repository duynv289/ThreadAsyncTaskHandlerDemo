package com.example.liz.threadasynctaskhandlerdemo;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AppActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Bitmap bitmap = null;
    private static final String LINK_IMAGE="http://taihinhanhdep.xyz/wp-content/uploads/2015/11/anh-dep-cho-dien-thoai-1.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        mImageView = findViewById(R.id.image_view);
        new DownLoadImageTask().execute(LINK_IMAGE);
    }
    @SuppressLint("StaticFieldLeak")
    private class DownLoadImageTask extends AsyncTask<String,Integer,Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
            super.onPostExecute(bitmap);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
}
