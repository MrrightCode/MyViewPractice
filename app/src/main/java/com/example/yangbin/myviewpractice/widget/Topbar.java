package com.example.yangbin.myviewpractice.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yangbin.myviewpractice.R;

/**
 * Created by yangbin on 2018/9/12.
 */
public class Topbar extends ConstraintLayout {
    private Button mButton;
    private TextView mTextView;
    private float mSize;
    private int mColor;
    private OnCick mOnCick;

    public Topbar(Context context) {
        this(context,null);
    }

    public Topbar(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public Topbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context,R.layout.topbar,this);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
        initView();
        initAttrs(array);
        mTextView.setTextSize(mSize);
        mTextView.setTextColor(Color.BLACK);
        mTextView.setText("asdasdasdad");
        mTextView.setTextColor(mColor);
        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCick.backClickListener();
            }
        });
    }

    private void initAttrs(TypedArray array) {
        mSize = array.getDimension(R.styleable.Topbar_titleSize,15);
        mColor = array.getColor(R.styleable.Topbar_titleColor,Color.BLACK);
    }

    private void initView() {
        mButton = findViewById(R.id.button);
        mTextView = findViewById(R.id.textView);
    }

    public  void setOnClick(OnCick onCick){
        mOnCick = onCick;
    }
    public interface OnCick{
        void backClickListener();
    }
}
