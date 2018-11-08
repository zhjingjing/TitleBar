package com.zj.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Method;

/**
 * create by zj on 2018/11/8
 */
public class TitleBar extends LinearLayout {

    private TextView tvTtile;
    private TextView tvLeft1;
    private TextView tvLeft2;
    private TextView tvRight1;
    private TextView tvRight2;


    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_titlebar,this,true);
        tvTtile=findViewById(R.id.tv_title);
        tvLeft1=findViewById(R.id.tv_left1_btn);
        tvLeft2=findViewById(R.id.tv_left2_btn);
        tvRight1=findViewById(R.id.tv_right1_btn);
        tvRight2=findViewById(R.id.tv_right2_btn);

        initViewAttr(context,attrs,defStyleAttr);
        setPresenter(context);
    }


    public void initViewAttr(Context context, AttributeSet attrs, int defStyleAttr){
        int defaultColor = 0xff24256e;
        int sp16 = dp2px(context, 16);
        int sp14 = dp2px(context, 14);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar, defStyleAttr, 0);

        //标题
        String titleText=a.getString(R.styleable.TitleBar_titleText);
        if (!TextUtils.isEmpty(titleText)){
            setTitleText(titleText);
        }
        int titleColor=a.getColor(R.styleable.TitleBar_titleColor,defaultColor);
        tvTtile.setTextColor(titleColor);
        tvTtile.setGravity(Gravity.CENTER);
        int titleSize=  a.getDimensionPixelSize(R.styleable.TitleBar_titleSize,sp16);
        tvTtile.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize);

        //左一
        String leftText1=a.getString(R.styleable.TitleBar_leftBtnText);
        if (!TextUtils.isEmpty(leftText1)){
            setLeftBtn1Text(leftText1);
        }
        int leftColor1=a.getColor(R.styleable.TitleBar_leftBtnTextColor,defaultColor);
        tvLeft1.setTextColor(leftColor1);
        int leftSize1=  a.getDimensionPixelSize(R.styleable.TitleBar_leftBtnTextSize,sp14);
        tvLeft1.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftSize1);
        Drawable leftIcon1 = a.getDrawable(R.styleable.TitleBar_leftBtnIcon);
        if (leftIcon1 != null) {
            tvLeft1.setCompoundDrawablesWithIntrinsicBounds(leftIcon1, null, null, null);
        }
        String leftClick1 = a.getString(R.styleable.TitleBar_leftBtnClick);
        if (!TextUtils.isEmpty(leftClick1)) {
            tvLeft1.setOnClickListener(new DeclaredOnClickListener(leftClick1));
        }
        if (TextUtils.isEmpty(leftText1)&&leftIcon1==null){
            tvLeft1.setVisibility(INVISIBLE);
        }else{
            tvLeft1.setVisibility(VISIBLE);
        }

        //左er
        String leftText2=a.getString(R.styleable.TitleBar_leftBtn2Text);
        if (!TextUtils.isEmpty(leftText2)){
            setLeftBtn2Text(leftText2);
        }
        int leftColor2=a.getColor(R.styleable.TitleBar_leftBtn2TextColor,defaultColor);
        tvLeft2.setTextColor(leftColor2);
        int leftSize2=  a.getDimensionPixelSize(R.styleable.TitleBar_leftBtn2TextSize,sp14);
        tvLeft2.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftSize2);
        Drawable leftIcon2 = a.getDrawable(R.styleable.TitleBar_leftBtn2Icon);
        if (leftIcon2 != null) {
            tvLeft2.setCompoundDrawablesWithIntrinsicBounds(leftIcon2, null, null, null);
        }
        String leftClick2 = a.getString(R.styleable.TitleBar_leftBtn2Click);
        if (!TextUtils.isEmpty(leftClick2)) {
            tvLeft2.setOnClickListener(new DeclaredOnClickListener(leftClick2));
        }
        if (TextUtils.isEmpty(leftText2)&&leftIcon2==null){
            tvLeft2.setVisibility(INVISIBLE);
        }else{
            tvLeft2.setVisibility(VISIBLE);
        }



        //右一
        String rightText1=a.getString(R.styleable.TitleBar_rightBtnText);
        if (!TextUtils.isEmpty(rightText1)){
            setRightBtn1Text(rightText1);
        }
        int rightColor1=a.getColor(R.styleable.TitleBar_rightBtnTextColor,defaultColor);
        tvRight1.setTextColor(rightColor1);
        int rightSize1=  a.getDimensionPixelSize(R.styleable.TitleBar_rightBtnTextSize,sp14);
        tvRight1.setTextSize(TypedValue.COMPLEX_UNIT_PX,rightSize1);
        Drawable rightIcon1 = a.getDrawable(R.styleable.TitleBar_rightBtnIcon);
        if (rightIcon1 != null) {
            tvRight1.setCompoundDrawablesWithIntrinsicBounds(rightIcon1, null, null, null);
        }
        String rightClick1 = a.getString(R.styleable.TitleBar_rightBtnClick);
        if (!TextUtils.isEmpty(rightClick1)) {
            tvRight1.setOnClickListener(new DeclaredOnClickListener(rightClick1));
        }
        if (TextUtils.isEmpty(rightText1)&&rightIcon1==null){
            tvRight1.setVisibility(INVISIBLE);
        }else{
            tvRight1.setVisibility(VISIBLE);
        }



        //右er
        String rightText2=a.getString(R.styleable.TitleBar_rightBtn2Text);
        if (!TextUtils.isEmpty(rightText2)){
            setRightBtn2Text(rightText2);
        }
        int rightColor2=a.getColor(R.styleable.TitleBar_rightBtn2TextColor,defaultColor);
        tvRight2.setTextColor(rightColor2);
        int rightSize2=  a.getDimensionPixelSize(R.styleable.TitleBar_rightBtn2TextSize,sp14);
        tvRight2.setTextSize(TypedValue.COMPLEX_UNIT_PX,rightSize2);
        Drawable rightIcon2 = a.getDrawable(R.styleable.TitleBar_rightBtn2Icon);
        if (rightIcon2 != null) {
            tvRight2.setCompoundDrawablesWithIntrinsicBounds(rightIcon2, null, null, null);
        }
        String rightClick2 = a.getString(R.styleable.TitleBar_rightBtn2Click);
        if (!TextUtils.isEmpty(rightClick2)) {
            tvRight2.setOnClickListener(new DeclaredOnClickListener(rightClick2));
        }
        if (TextUtils.isEmpty(rightText2)&&rightIcon2==null){
            tvRight2.setVisibility(INVISIBLE);
        }else{
            tvRight2.setVisibility(VISIBLE);
        }

        a.recycle();

    }


    public void setTitleText(String text){
        tvTtile.setText(text);
    }




    public void setLeftBtn1Text(String text){
        tvLeft1.setText(text);

    }
    public void setLeftBtn2Text(String text){
        tvLeft2.setText(text);


    }
    public void setRightBtn1Text(String text){
        tvRight1.setText(text);


    }
    public void setRightBtn2Text(String text){
        tvRight2.setText(text);


    }

    /**
     * 反射获取执行方法
     */
    private Object mPresenter;

    public void setPresenter(Object mPresenter) {
        this.mPresenter = mPresenter;
    }

    public static int dp2px(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }


    private class DeclaredOnClickListener implements OnClickListener {
        private final String mMethodName;
        private Method mResolvedMethod;

        private DeclaredOnClickListener(String methodName) {
            mMethodName = methodName;
        }

        @Override
        public void onClick(View v) {
            if (mResolvedMethod == null) {
                try {
                    mResolvedMethod = mPresenter.getClass().getMethod(mMethodName, View.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new RuntimeException("查找点击事件方法失败: " + mMethodName);
                }
            }

            try {
                mResolvedMethod.invoke(mPresenter, v);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("执行点击事件方法失败: " + mMethodName);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode != MeasureSpec.EXACTLY) {
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode != MeasureSpec.EXACTLY) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
