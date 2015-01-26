package com.example.photoproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

public class DrawActivity extends Activity {
	
	public static final String key = "DrawActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draw);
		DrawingView view = (DrawingView)findViewById(R.id.view1);
		Bundle bundle = getIntent().getExtras().getBundle(key);
		Bitmap image = (Bitmap) bundle.get("data");
		view.setImage(image);
		
	}
}
