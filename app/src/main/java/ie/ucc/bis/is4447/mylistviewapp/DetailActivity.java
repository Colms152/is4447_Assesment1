package ie.ucc.bis.is4447.mylistviewapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        //get the intent Extra
        Intent intent = getIntent();
        int index = intent.getIntExtra("Item_Index",-1);

        if (index > -1){
            int pic = getImage(index);

            ImageView ivItem = (ImageView) findViewById(R.id.ivItem);
            scaleImage(ivItem,pic);
        }
    }

    //set index to image required
    private int getImage(int index){
        switch (index){
            case 0: return  R.drawable.apple;
            case 1: return  R.drawable.banana;
            case 2: return  R.drawable.orange;
            default: return -1;
        }
    }

    private void scaleImage(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(),pic,options);

        int imgWidth = options.outWidth;

        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;

        if(imgWidth>screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImage);

    }


}


