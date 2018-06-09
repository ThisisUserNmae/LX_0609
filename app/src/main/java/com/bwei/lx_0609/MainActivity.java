package com.bwei.lx_0609;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intDatas();

    }

    private void intDatas() {

        MyTitle myTitle = new MyTitle(MainActivity.this);

        myTitle.setBtnClick(new MyTitle.BtnChlick() {
            @Override
            public void leftBtnClick() {



            }

            @Override
            public void rightBtnClick() {

            }
        });

    }
}
