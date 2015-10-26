package com.dd.numberpick;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NumberPick extends LinearLayout {

    private Context mContext;

    private static final int MAX_NUMBER = 10;

    private static final int MIN_NUMBER = 0;

    private static final int DEFAULT_NUMBER = 0;

    private ImageButton mSubIBtn;

    private ImageButton mAddIBtn;

    private TextView mNumberTv;

    private int mMaxNumber = MAX_NUMBER;

    private int mMinNumber = MIN_NUMBER;

    private int mDefaultNumber = DEFAULT_NUMBER;

    private OnNumberPickListener mOnNumberPickListener;

    public void setOnNumberPickListener(OnNumberPickListener listener) {
        this.mOnNumberPickListener = listener;
    }

    public NumberPick(Context context) {
        this(context, null);
    }

    public NumberPick(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NumberPick);
        mMaxNumber = a.getInt(R.styleable.NumberPick_max, MAX_NUMBER);
        mMinNumber = a.getInt(R.styleable.NumberPick_min, MIN_NUMBER);
        mDefaultNumber = a.getInt(R.styleable.NumberPick_number, DEFAULT_NUMBER);
        a.recycle();
        init();
        initEvent();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.number_pick, this);
        mSubIBtn = (ImageButton) findViewById(R.id.sub_ibtn);
        mAddIBtn = (ImageButton) findViewById(R.id.add_ibtn);
        mNumberTv = (TextView) findViewById(R.id.number_tv);
        mNumberTv.setText(String.valueOf(mDefaultNumber));
    }

    private void initEvent() {
        mSubIBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = getNumber() - 1;
                if (number >= mMinNumber) {
                    setNumber(number);
                    mOnNumberPickListener.onSub(number);
                }
            }
        });

        mAddIBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = getNumber() + 1;
                if (number <= mMaxNumber) {
                    setNumber(number);
                    mOnNumberPickListener.onAdd(number);
                }
            }
        });
    }

    public void setNumber(int number) {
        mNumberTv.setText(String.valueOf(number));
    }

    public int getNumber() {
        return Integer.parseInt(mNumberTv.getText().toString());
    }

    public interface OnNumberPickListener {

        void onSub(int number);

        void onAdd(int number);
    }
}