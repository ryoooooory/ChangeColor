package jp.techinstitute.oshimaryo.changecolor;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by oshimaryo on 2018/08/15.
 */

public class monochro extends AsyncTask<Bitmap, Integer, Bitmap> {
    private ImageView mImageView;
    public monochro(ImageView imageView) {
        super();
        mImageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(Bitmap... bitmap) {
// 非同期で処理する
        Bitmap out = bitmap[0].copy(Bitmap.Config.ARGB_8888, true);
        int width = out.getWidth();
        int height = out.getHeight();
        int totalPixcel = width * height;
        int i, j;
        for (j = 0; j < height; j++) {
            for (i = 0; i < width; i++) {
                int pixelColor = out.getPixel(i, j);
// モノクロ化
                int y = (int) (0.299 * Color.red(pixelColor) +
                        0.587 * Color.green(pixelColor) +
                        0.114 * Color.blue(pixelColor));
                out.setPixel(i, j, Color.rgb(y, y, y));
            }
        }
        return out;
    }
    @Override
    protected void onPostExecute(Bitmap result) {
// 実行後にImageViewへ反映
        mImageView.setImageBitmap(result);
    }
}