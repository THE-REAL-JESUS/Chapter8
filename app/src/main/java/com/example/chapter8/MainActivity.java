package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Animals= {R.drawable.cat4,R.drawable.cub2,R.drawable.cute6,R.drawable.jir1,R.drawable.deer8,R.drawable.lioness5,R.drawable.lynx7,R.drawable.monkey10,R.drawable.wolf3,R.drawable.wolf9};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid =(GridView) findViewById(R.id.gridView);

        pic = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Selected Species:"+(i+1), Toast.LENGTH_SHORT).show();
                pic.setImageResource(Animals[i]);


            }
        });

    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;


        public ImageAdapter(Context context) {
            this.context=context;
        }

        @Override
        public int getCount() {
            return Animals.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(Animals[i]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }
}