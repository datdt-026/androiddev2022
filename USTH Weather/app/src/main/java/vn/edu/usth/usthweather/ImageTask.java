package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import android.os.Bundle;

import java.io.InputStream;

public class ImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView2;

    public ImageTask(ImageView imageView) {
        this.imageView2 = imageView;
    }

    protected Bitmap doInBackground(String... urls){
        String urldisplay = urls[0];
        Bitmap mIcon1 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon1 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon1;
    }

    protected void onPostExecute(Bitmap result) {
        imageView2.setImageBitmap(result);
    }

}