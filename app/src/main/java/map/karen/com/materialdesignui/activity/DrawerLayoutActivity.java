package map.karen.com.materialdesignui.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import map.karen.com.materialdesignui.R;
import map.karen.com.materialdesignui.view.CircleImageView;

public class DrawerLayoutActivity extends BaseActivity{

    private DrawerLayout drawerLayout;
    private NavigationView mNavigationview;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar mToolbar;



    @Override
    int initLayout() {
        return R.layout.activity_drawerlayout;
    }

    @Override
    void initView() {
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer);
        mNavigationview= (NavigationView) findViewById(R.id.navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);

    }

    @Override
    void initClickListener() {
        CircleImageView circleImageView= (CircleImageView) mNavigationview.findViewById(R.id.profileImage);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar= Snackbar.make(v,
                        "THIS FEATURE IS NOT ADDED , " +
                         "IF NECESSARY, REFER TO CAMERAMANAGER IN GITHUB", Snackbar.LENGTH_LONG);
                View view=snackbar.getView();
                FrameLayout.LayoutParams params= (FrameLayout.LayoutParams) view.getLayoutParams();
                params.gravity=Gravity.RIGHT;
                view.setLayoutParams(params);
                snackbar.show();

            }
        });
        mNavigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                onNavigationItemClick(menuItem);
                return true;
            }
        });

    }

    @Override
    void initLogic() {

    }

    private void onNavigationItemClick(MenuItem menuItem) {
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(Gravity.LEFT);
        switch (menuItem.getItemId()){
            case R.id.action_recyclerview:
                startActivity(new Intent(DrawerLayoutActivity.this,RecyclerViewActivity.class));
                break;
            case R.id.action_floatingactionbutton:
                Intent intent = new Intent(DrawerLayoutActivity.this, FloatingActionButtonActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(DrawerLayoutActivity.this).toBundle());
                }else {
                    startActivity(intent);
                }
                break;
            case R.id.action_slidingpanelayout:
                startActivity(new Intent(DrawerLayoutActivity.this,SlidingPaneLayoutActivity.class));
                break;
            case R.id.action_swiperefresh:
                startActivity(new Intent(DrawerLayoutActivity.this,SwipeRefreshActivity.class));
                break;

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
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
