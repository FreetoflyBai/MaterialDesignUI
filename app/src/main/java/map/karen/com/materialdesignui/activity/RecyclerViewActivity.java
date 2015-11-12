package map.karen.com.materialdesignui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import map.karen.com.materialdesignui.R;
import map.karen.com.materialdesignui.adapter.DrawerPagerAdapter;
import map.karen.com.materialdesignui.fragment.RecycleFragment;



/**
 * package: com.project.baikun.activity
 * user:    baikun
 * date:    2015/1/8
 * link:    904869397@qq.com
 */
public class RecyclerViewActivity extends BaseActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private DrawerPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private FloatingActionButton mFloatingActionButton;

    @Override
    int initLayout() {
        return R.layout.activity_recyclerview;
    }

    @Override
    void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);

    }

    @Override
    void initClickListener() {
        String[] mTitles = getResources().getStringArray(R.array.recycle_array);
        List<Fragment> mFragments=new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            Bundle mBundle = new Bundle();
            mBundle.putInt("flag", i);
            RecycleFragment mFragment = new RecycleFragment();
            mFragment.setArguments(mBundle);
            mFragments.add(i, mFragment);
        }
        mViewPagerAdapter = new DrawerPagerAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mViewPager.setAdapter(mViewPagerAdapter);
        mViewPager.setOffscreenPageLimit(5);


        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mViewPagerAdapter);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar= Snackbar.make(v, "This is Snackbar", Snackbar.LENGTH_LONG);
                snackbar.setAction("shutup", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();


            }
        });

    }

    @Override
    void initLogic() {
        initActionBar();
    }


    void initActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
//            actionBar.setTitle(R.string.app_name);
//            actionBar.setHomeAsUpIndicator(R.drawable.icon_menu);
//            actionBar.setDisplayShowCustomEnabled(true);
//            View actionbarLayout= LayoutInflater.from(this).inflate(R.layout.layout_actionbar,null);
//            actionbarLayout.findViewById(R.id.text_left);
//            ActionBar.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            actionBar.setCustomView(actionbarLayout, params);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return super.onCreateOptionsMenu(menu);
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
