package jp.techinstitute.oshimaryo.changecolor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private Bitmap mBitmap;
    private Button mCountButton;
    private Integer mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBitmap = BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mImageView.setImageBitmap(mBitmap);


        mCountButton = (Button)findViewById(R.id.countButton);
        mCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCount++;
                ((Button)view).setText(mCount.toString());
            }
        });


        Button execButton = (Button)findViewById(R.id.execButton);
        execButton.setOnClickListener(new View.OnClickListener() {
            monochro task =
                    new monochro(mImageView);
            @Override
            public void onClick(View view) {
// モノクロにする処理
                task.execute(mBitmap);
            }
        });
    }
}
