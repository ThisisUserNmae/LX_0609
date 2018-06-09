package com.bwei.lx_0609;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyFlowLayout extends ViewGroup{
    public MyFlowLayout(Context context) {
        super(context);
    }

    public MyFlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measureChildren(widthMeasureSpec,heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = 0;
        int height = 0;

        int lineHeight = 0;
        int lineWidth = 0;

        int childWidth = 0;

        int childHeight = 0;

        View childView;

        int totalHeight = 0;

        for (int i = 0; i < getChildCount(); i++) {

            childView = getChildAt(i);

             childWidth  = childView.getMeasuredWidth();
             childHeight  = childView.getMeasuredHeight();

             lineHeight =childHeight;

             totalHeight +=lineHeight;
             lineWidth = childWidth;
/*             if(i % 2 ==0){

                //累加高
                 totalHeight +=lineHeight;

                 lineHeight = childHeight;

                 lineWidth = childWidth;

             }else{

                 totalHeight+= lineHeight;

                 lineWidth+=childWidth;

                 lineHeight=childHeight;

             }

             if(i == getChildCount() -1){
                 totalHeight +=lineHeight;

                 height = totalHeight;

             }*/

             height = heightMode == MeasureSpec.EXACTLY ? heightSize :totalHeight;
             width = widthMode == MeasureSpec.EXACTLY ? widthSize :lineWidth;

             setMeasuredDimension(width,height);

        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int lineHeight = 0;
        int lineWidth = 0;

        int childWidth = 0;

        int childHeight = 0;

        View childView;

        int totalHeight = 0;

        for (int i = 0; i < getChildCount(); i++) {

            childView = getChildAt(i);

            childWidth  = childView.getMeasuredWidth();
            childHeight  = childView.getMeasuredHeight();

            if(i % 2 ==0){

                lineWidth = 0;
                //累加高
                totalHeight +=lineHeight;

                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);

                lineHeight = childHeight;

                lineWidth = childWidth;
            }else{
                totalHeight+= lineHeight;
                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);

            }

        }

    }

    public void childViewLayout(View child,int l,int t,int r,int b){

        child.layout(l,t,r,b);

    }
}
