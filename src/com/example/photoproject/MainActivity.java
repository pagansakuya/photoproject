package com.example.photoproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	static final int REQUEST_IMAGE_CAPTURE = 1;
	private Bundle extras;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void submitShoot(View v) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
	    }
	}
	
	public void submitDraw(View v){
		Intent intent = new Intent(this, DrawActivity.class);
		intent.putExtra(DrawActivity.key, extras);
    	startActivity(intent);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
	        extras = data.getExtras();
	        Bitmap imageBitmap = (Bitmap) extras.get("data");
	        ImageView imageView = (ImageView) findViewById(R.id.iviewPhoto);
	        imageView.setImageBitmap(imageBitmap);
	    }
	}
}
