package com.dd.numberpick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Np extends View {

    private static final int MAX_NUMBER = 100;

    private static final int MIN_NUMBER = 0;

    private static final int DEFAULT_NUMBER = 0;

    private static final int DEFAULT_COLOR = R.color.colorAccent;

    private static final int NUMBER_COLOR = R.color.colorText;

    private static final int CORNER = 5;

    private static final int WIDTH = 32;

    private Context mContext;

    //画线的笔
    private Paint mLinePaint;

    private Paint mPaint;


    private int mMaxNumber = MAX_NUMBER;

    private int mMinNumber = MIN_NUMBER;

    private int mDefaultNumber = DEFAULT_NUMBER;

    private int mColor = DEFAULT_COLOR;

    private int mNumberColor = NUMBER_COLOR;

    private int mCorner = CORNER;

    private int mWidth = WIDTH;

    private RectF mRectF;

    private Bitmap mAddBmp;

    private Bitmap mSubBmp;

    private int mTextSize = 18;

    private int mLineWidth = 2;

    public Np(Context context) {
        this(context, null);
    }

    public Np(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Np);
        mMaxNumber = a.getInt(R.styleable.Np_max, mMaxNumber);
        mMinNumber = a.getInt(R.styleable.Np_min, mMinNumber);
        mDefaultNumber = a.getInt(R.styleable.Np_number, mDefaultNumber);
        mColor = a.getColor(R.styleable.Np_lineColor, getResources().getColor(mColor));
        mNumberColor = a.getColor(R.styleable.Np_numberColor, getResources().getColor(mNumberColor));
        mCorner = a.getDimensionPixelOffset(R.styleable.Np_corner, mCorner);
        mWidth = a.getDimensionPixelOffset(R.styleable.Np_width, mWidth);
        a.recycle();

        init();

    }

    private void init() {
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(mColor);
        mLinePaint.setStrokeWidth(2);
        mLinePaint.setStyle(Paint.Style.STROKE);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mNumberColor);

        mAddBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_add);
        mSubBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_sub);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 3 * mWidth + 2 * mLineWidth;
        int height = mWidth;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectF = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(mRectF, mCorner + 2, mCorner + 2, mLinePaint);
        canvas.drawLine(mWidth, mWidth, mWidth, 0, mLinePaint);
        canvas.drawLine(2 * mWidth + mLineWidth, mWidth, 2 * mWidth + mLineWidth, 0, mLinePaint);

        canvas.drawBitmap(mSubBmp, (mWidth - mSubBmp.getWidth()) / 2, (mWidth - mSubBmp.getWidth()) / 2, mPaint);
        canvas.drawBitmap(mAddBmp, 2 * (mWidth + mLineWidth) +
                (mWidth - mAddBmp.getWidth()) / 2, (mWidth - mAddBmp.getWidth()) / 2, mPaint);

        mPaint.setTextSize(mTextSize);
        String number = String.valueOf(mDefaultNumber);
        canvas.drawText(number, 0, number.length(), mWidth + mLineWidth + (mWidth - mPaint.measureText(number)) / 2,
                mWidth / 2 + getFontHeight(mPaint) / 2 - mLineWidth, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setWidth(int width) {
        mWidth = width;
        invalidate();
    }

    public void setNumber(int number) {
        mDefaultNumber = number;
        invalidate();
    }

    public void setMax(int max) {
        mMaxNumber = max;
        invalidate();
    }

    public void setMin(int min) {
        mMinNumber = min;
        invalidate();
    }

    public void setLineColor(int color) {
        mColor = color;
        invalidate();
    }

    public void setNumberColor(int color) {
        mNumberColor = color;
        invalidate();
    }

    public void setCorner(int corner) {
        mCorner = corner;
        invalidate();
    }


    /**
     * 获取字体高度
     *
     * @param paint
     * @return
     */
    private int getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (int) Math.ceil(fm.descent - fm.ascent);
    }

}