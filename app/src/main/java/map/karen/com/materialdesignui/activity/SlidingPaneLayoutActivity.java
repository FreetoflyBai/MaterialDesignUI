package map.karen.com.materialdesignui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import map.karen.com.materialdesignui.R;

public class SlidingPaneLayoutActivity extends BaseActivity {

    private SlidingPaneLayout mSlidingLayout;
    private ListView mList;
    private TextView mContent;

    private String[] mArrays;
    private Toolbar mToolbar;

    @Override
    int initLayout() {
        return R.layout.activity_sliding_pane_layout;
    }

    @Override
    void initView() {
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSlidingLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        mList = (ListView) findViewById(R.id.left_pane);
        mContent = (TextView) findViewById(R.id.content_text);
    }

    @Override
    void initClickListener() {

        mSlidingLayout.setPanelSlideListener(new SliderListener());
        mSlidingLayout.setSliderFadeColor(getResources().getColor(R.color.transparent));
//        mSlidingLayout.getViewTreeObserver().addOnGlobalLayoutListener(new FirstLayoutListener());
//        mSlidingLayout.openPane();

        mArrays = getResources().getStringArray(R.array.AZ_array);
        mList.setAdapter(new ArrayAdapter<String>(this, R.layout.adapter_list_item, R.id.item,
                mArrays));
        mList.setOnItemClickListener(new ListItemClickListener());


    }

    @Override
    void initLogic() {
    }

    /**
     * This list item click listener implements very simple view switching by changing
     * the primary content text. The slider is closed when a selection is made to fully
     * reveal the content.
     */
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mContent.setText(mArrays[position]);
            mSlidingLayout.smoothSlideClosed();
//            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.slidingpane_background);
//            Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
//                @Override
//                public void onGenerated(Palette palette) {
//                    mContent.setBackgroundColor(palette.getVibrantColor(getResources().getColor(R.color.main_blue_dark)));
//                }
//            });
        }
    }

    /**
     * This panel slide listener updates the action bar accordingly for each panel state.
     */
    private class SliderListener extends SlidingPaneLayout.SimplePanelSlideListener {
        @Override
        public void onPanelOpened(View panel) {
        }

        @Override
        public void onPanelClosed(View panel) {
        }

        @Override
        public void onPanelSlide(View panel, float slideOffset) {
            mList.setAlpha(slideOffset);//透明度
//            mList.setScaleY(slideOffset);//Y
//            mList.setScaleX(slideOffset);//X
//            mList.setPivotX(slideOffset-48);//基点X
//            mList.setPivotY(mSlidingLayout.getHeight() / 3 * 2);
            mContent.setScaleY(1 - slideOffset / 5);
            mContent.setScaleX(1 - slideOffset / 5);
        }
    }

    /**
     * This global layout listener is used to fire an event after first layout occurs
     * and then it is removed. This gives us a chance to configure parts of the UI
     * that adapt based on available space after they have had the opportunity to measure
     * and layout.
     */
    private class FirstLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override
        public void onGlobalLayout() {
            //TODO
            mSlidingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
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
