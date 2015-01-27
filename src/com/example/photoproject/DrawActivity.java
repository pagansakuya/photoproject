package com.example.photoproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

public class DrawActivity extends Activity {
	
	public static final String key = "DrawActivity";
	DrawingView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draw);
		view = (DrawingView)findViewById(R.id.view1);
		Bundle bundle = getIntent().getExtras().getBundle(key);
		Bitmap image = (Bitmap) bundle.get("data");
		view.setImage(image);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra(DrawActivity.key, view.getModifiedImage());
		startActivity(intent);
	}
}
