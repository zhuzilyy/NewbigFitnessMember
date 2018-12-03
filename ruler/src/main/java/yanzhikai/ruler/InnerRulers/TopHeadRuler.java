package yanzhikai.ruler.InnerRulers;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import yanzhikai.ruler.BooheeRuler;
import yanzhikai.ruler.Utils.RulerStringUtil;

/**
 * 头向上的尺子
 */

public class TopHeadRuler extends HorizontalRuler {

    public TopHeadRuler(Context context, BooheeRuler booheeRuler) {
        super(context, booheeRuler);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScale(canvas);
        drawEdgeEffect(canvas);
    }

    //画刻度和字
    private void drawScale(Canvas canvas) {
        //计算开始和结束刻画时候的刻度
        float start = (getScrollX() - mDrawOffset) / mParent.getInterval() + mParent.getMinScale();
        float end = (getScrollX() + canvas.getWidth() + mDrawOffset) / mParent.getInterval() + mParent.getMinScale();
        for (float i = start; i <= end; i++) {
            //将要刻画的刻度转化为位置信息
            float locationX = (i - mParent.getMinScale()) * mParent.getInterval();

            if (i >= mParent.getMinScale() && i <= mParent.getMaxScale()) {
                if (i % mCount == 0) {
                    canvas.drawLine(locationX, 0, locationX, mParent.getBigScaleLength(), mBigScalePaint);

                    double d=Double.valueOf(RulerStringUtil.resultValueOf(i,mParent.getFactor()));
                    canvas.drawText( String.format("%.0f", d), locationX, mParent.getTextMarginHead(), mTextPaint);
                } else {
                    canvas.drawLine(locationX, 0, locationX, mParent.getSmallScaleLength(), mSmallScalePaint);
                }
            }
        }
        //画轮廓线
        canvas.drawLine(getScrollX(), 0, getScrollX() + canvas.getWidth(), 0, mOutLinePaint);

    }



    //画边缘效果
    private void drawEdgeEffect(Canvas canvas) {
        if (mParent.canEdgeEffect()) {
            if (!mStartEdgeEffect.isFinished()) {
                int count = canvas.save();
                //旋转位移Canvas来使EdgeEffect绘画在正确的地方
                canvas.rotate(270);
                canvas.translate(-mParent.getCursorHeight(), 0);
                if (mStartEdgeEffect.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(count);
            } else {
                mStartEdgeEffect.finish();
            }
            if (!mEndEdgeEffect.isFinished()) {
                int count = canvas.save();
                canvas.rotate(90);
                canvas.translate(0, -mLength);
                if (mEndEdgeEffect.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(count);
            } else {
                mEndEdgeEffect.finish();
            }
        }
    }
}
