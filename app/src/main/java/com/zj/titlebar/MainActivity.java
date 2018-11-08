package com.zj.titlebar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zj.titlebar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main);
        binding.setPresenter(this);
    }


    public void onLeft1Clicked(View view){
        Toast.makeText(this,"左1",Toast.LENGTH_LONG).show();
    }

    public void onLeft2Clicked(View view){
        Toast.makeText(this,"左2",Toast.LENGTH_LONG).show();
    }

    public void onRight1Clicked(View view){
        Toast.makeText(this,"右1",Toast.LENGTH_LONG).show();
    }

    public void onRight2Clicked(View view){
        Toast.makeText(this,"右2",Toast.LENGTH_LONG).show();
    }
}
