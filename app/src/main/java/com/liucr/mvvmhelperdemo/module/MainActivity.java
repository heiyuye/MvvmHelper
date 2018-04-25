package com.liucr.mvvmhelperdemo.module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liucr.mvvmhelperdemo.R;
import com.liucr.mvvmhelperdemo.module.search.view.SearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClickSearch(View view) {
        startActivity(new Intent(this, SearchActivity.class));
    }
}
