package hackers.com.project;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
=======
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
>>>>>>> 37780ba325984dc605f149edcd959856eea66de4
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
=======
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
>>>>>>> 37780ba325984dc605f149edcd959856eea66de4

import java.util.*;

/**
 * Created by user on 02-10-2017.
 */

<<<<<<< HEAD
public class Product_activity extends AppCompatActivity {
    Button button;
=======

public class Product_activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private RecyclerView mDrawerList;
    private android.support.v4.app.ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] mPlanetTitles;
    Button see;

>>>>>>> 37780ba325984dc605f149edcd959856eea66de4
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardan_product);
        mTitle = mDrawerTitle = getTitle();

        final Toolbar toolbar = findViewById(R.id.toolbar);
        see = findViewById(R.id.seeall_button);
        mPlanetTitles = getResources().getStringArray(R.array.items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setNavigationViewListner();
        actionBar.setHomeAsUpIndicator(R.drawable.action_bar_icon);
//        actionBar.setIcon(R.drawable.action_bar_icon);
        mDrawerToggle = new android.support.v4.app.ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.action_bar_icon,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final ArrayList<CategoryModel> categoryList = new ArrayList<>();
<<<<<<< HEAD
        final ArrayList<ProductModel> productList = new ArrayList<>();
        for (int i = 0 ; i < 50 ; i++){
=======
        for (int i = 0; i < 50; i++) {
            final ArrayList<ProductModel> productList = new ArrayList<>();

>>>>>>> 37780ba325984dc605f149edcd959856eea66de4

            for (int j = 0; j < 100; j++) {
                final ProductModel productModel = new ProductModel(j, "M1", "Product" + j);
                productList.add(productModel);
            }

            final CategoryModel categoryModel = new CategoryModel("Category" + i, productList);

            categoryList.add(categoryModel);

        }

        final CategoryAdapter categoryAdapter = new CategoryAdapter(this, categoryList);
        recyclerView.setAdapter(categoryAdapter);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home: {
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            }

        }

        return true;

    }


<<<<<<< HEAD
=======
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login: {
                Intent intent = new Intent(Product_activity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.plants: {
                Intent intent = new Intent(Product_activity.this, PCategoryActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.food: {
                Intent intent = new Intent(Product_activity.this, PCategoryActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.gardentools: {
                Intent intent = new Intent(Product_activity.this, PCategoryActivity.class);
                startActivity(intent);
                break;
            }
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
       return true;
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = findViewById(R.id.navigation_bar);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();
    }
>>>>>>> 37780ba325984dc605f149edcd959856eea66de4
}





