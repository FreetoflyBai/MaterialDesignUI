package map.karen.com.materialdesignui.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import map.karen.com.materialdesignui.R;

/**
 * package : map.karen.com.materialdesignui.activity
 * describe: ${CLASS_NAME}
 * author  : Karen
 * date    : 2015/10/20
 * link    : 904869397@qq.com
 */
public class FloatingActionButtonActivity extends BaseActivity {
    @Override
    int initLayout() {
        return R.layout.activity_floatingactionbutton;
    }

    @Override
    void initView() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getString(R.string.title_activity_floating_action_button));

    }

    @Override
    void initClickListener() {

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
