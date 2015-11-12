package map.karen.com.materialdesignui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.preference.ListPreference;
import android.preference.Preference;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//import android.support.v4.widget.SwipeRefreshLayout;

import java.util.List;

import map.karen.com.materialdesignui.R;
import map.karen.com.materialdesignui.view.SwipeRefreshLayout;


/**
 * package: com.project.baikun.activity
 * user:    baikun
 * date:    2015/1/8
 * link:    904869397@qq.com
 */
public class SwipeRefreshActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout swipeRefresh;
    private ImageView image1,image2,image3;
    private TextView mTextView;
    private Toolbar mToolbar;



    @Override
    int initLayout() {
        return R.layout.activity_swiperefresh;
    }

    @Override
    void initView() {
        image1= (ImageView) findViewById(R.id.image1);
        image2= (ImageView) findViewById(R.id.image2);
        image3= (ImageView) findViewById(R.id.image3);
        mTextView = (TextView) findViewById(R.id.textView);

        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        swipeRefresh= (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light));


        //bottom
        swipeRefresh.setBottomColor(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefresh.setOnLoadListener(new SwipeRefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        swipeRefresh.setLoading(false);
                    }
                }, 1000);
            }
        });

    }

    @Override
    void initClickListener() {
        image1.setOnClickListener(imageClickListener1);
        image2.setOnClickListener(imageClickListener2);
        image3.setOnClickListener(imageClickListener3);

    }

    View.OnClickListener imageClickListener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.slidingpane_background);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    Palette.Swatch swatch = palette.getMutedSwatch();
                    if (swatch != null) {
                        mTextView.setBackgroundColor(swatch.getRgb());
                    }
                }
            });
        }
    };

    View.OnClickListener imageClickListener2=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.drawer_header);
            Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    mTextView.setBackgroundColor(palette.getVibrantColor(getResources().getColor(R.color.main_blue_dark)));
                }
            });
        }
    };


    View.OnClickListener imageClickListener3=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.drawer_background);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    List<Palette.Swatch> swatches = palette.getSwatches();
                    for (Palette.Swatch s:swatches){
                        if(s!=null){
                            mTextView.setBackgroundColor(s.getRgb());
                        }
                    }
                }
            });
        }
    };

    @Override
    void initLogic() {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                swipeRefresh.setRefreshing(false);
            }
        }, 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
