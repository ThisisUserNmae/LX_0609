package com.bwei.lx_0609;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity implements MyTitle.BtnChlick {

    private MyFlowLayout main_flow;
    private MyTitle myTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {

        MyTitle main_title = findViewById(R.id.main_title);

        main_title.setBtnClick(this);


        main_flow = findViewById(R.id.main_flow);

    }

    private void intDatas() {

/*        myTitle = new MyTitle(MainActivity.this);

        myTitle.setBtnClick(new MyTitle.BtnChlick() {
            @Override
            public void leftBtnClick() {

            }

            @Override
            public void rightBtnClick() {

            }
        });


        myTitle.setBtnClick(new MyTitle.BtnChlick() {
            @Override
            public void leftBtnClick() {

                main_flow.removeViewAt(0);

            }

            @Override
            public void rightBtnClick() {

                TextView tv = new TextView(MainActivity.this);

                tv.setText("你们真好");

                main_flow.addView(tv);

            }
        });*/

    }

    @Override
    public void leftBtnClick() {

        main_flow.removeViewAt(0);

    }

    @Override
    public void rightBtnClick() {

        TextView tv = new TextView(MainActivity.this);

        tv.setText("你们真好");

        main_flow.addView(tv);

    }
}
