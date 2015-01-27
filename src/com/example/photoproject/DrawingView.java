package com.example.photoproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class DrawingView extends ImageView {

	private Paint paint = new Paint();
	private Path path = new Path();
	private Bitmap image;
	private Bitmap lineBitmap;

	public DrawingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint.setAntiAlias(true);
		paint.setStrokeWidth(5f);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
		setDrawingCacheEnabled(true);
		buildDrawingCache();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// canvas.setBitmap(image);
		this.setImageBitmap(image);
//		canvas.drawBitmap(image, 0, 0, paint);
		canvas.drawPath(path, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// Get the coordinates of the touch event.
		float eventX = event.getX();
		float eventY = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// Set a new starting point
			path.moveTo(eventX, eventY);
			return true;
		case MotionEvent.ACTION_MOVE:
			// Connect the points
			path.lineTo(eventX, eventY);
			break;
		default:
			return false;
		}

		// Makes our view repaint and call onDraw
		invalidate();

		return super.onTouchEvent(event);
	}

	public void setImage(Bitmap image2) {
		// TODO Auto-generated method stub
		image = image2;	

	}

	public Bitmap getModifiedImage() {
		lineBitmap = Bitmap.createBitmap(getDrawingCache());
		return lineBitmap;
		// return image;
	}

}
