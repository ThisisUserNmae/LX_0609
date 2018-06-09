package com.bwei.lx_0609;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyTitle extends LinearLayout implements View.OnClickListener{

    private TypedArray typedArray;
    private Button left_btn;
    private Button right_btn;
    private TextView title;
    private BtnChlick btnChlick;

    public MyTitle(Context context) {
        super(context);
    }

    public MyTitle(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

        typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyFlowLayout,0,0);

        String left_text = typedArray.getString(R.styleable.MyFlowLayout_left_text);
        String right_text = typedArray.getString(R.styleable.MyFlowLayout_right_text);
        String title_text = typedArray.getString(R.styleable.MyFlowLayout_title_text);


        View view = inflate(context, R.layout.title_item_layout, this);

        left_btn = view.findViewById(R.id.left_btn);
        right_btn = view.findViewById(R.id.right_btn);
        title = view.findViewById(R.id.title);

        left_btn.setText(left_text);
        right_btn.setText(right_text);
        title.setText(title_text);





    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.left_btn:

                if(btnChlick !=null){

                    btnChlick.leftBtnClick();

                }

                break;

                case R.id.right_btn:

                    if(btnChlick !=null){

                        btnChlick.rightBtnClick();

                    }

            break;

        }
    }

    public interface BtnChlick{

        void leftBtnClick();
        void rightBtnClick();

    }

    public void setBtnClick(BtnChlick btnChlick){

        this.btnChlick = btnChlick;

    }

}
