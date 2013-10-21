package com.charleslab.pgg;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class PGGLoginActivity extends Activity {
	/** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.login);
	      ActionBar actionBar = getActionBar(); 
	      actionBar.setDisplayShowTitleEnabled(false); 
	      actionBar.setDisplayShowHomeEnabled(false);
	      //
	      DisplayMetrics metrics = new DisplayMetrics();  
	      final WindowManager w = (WindowManager) getSystemService(WINDOW_SERVICE);
	      final Display d = w.getDefaultDisplay();
	      d.getMetrics(metrics);
	      int size = metrics.widthPixels * 4 / 10;
	      //
	      ImageButton btnFacebook = ((ImageButton)findViewById(R.id.btn_facebook));
	      ImageButton btnPGG = ((ImageButton)findViewById(R.id.btn_pgg));
	      RelativeLayout.LayoutParams params = (LayoutParams) btnFacebook.getLayoutParams();
	      params.width = params.height = size;
	      btnFacebook.setLayoutParams(params);
	      params = (LayoutParams) btnPGG.getLayoutParams();
	      params.width = params.height = size;
	      btnPGG.setLayoutParams(params);
	   }
}
