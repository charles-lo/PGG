package com.charleslab.pgg;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class LoginFacebookActivity extends Activity {
	static private String TAG = LoginFacebookActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_facebook);
		// make actionbar empty
	    ActionBar actionBar = getActionBar(); 
	    actionBar.setDisplayShowTitleEnabled(false); 
	    actionBar.setDisplayShowHomeEnabled(false);
	    //
		Session.openActiveSession(this, true, new Session.StatusCallback() {
			@Override
			public void call(Session session, SessionState state,
					Exception exception) {
				if (session.isOpened()) {
					 // make request to the /me API
			          Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

						@Override
						public void onCompleted(GraphUser user,
								Response response) {
							if (user != null) {
				                TextView welcome = (TextView) findViewById(R.id.welcome);
				                welcome.setText("Hello " + user.getName() + "~~!");
				              }
							
						}
			          });
				}				
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		boolean result = Session.getActiveSession().onActivityResult(this, requestCode,resultCode, data);
		
		if (resultCode == RESULT_OK){
			Log.d(TAG, "RESULT_OK: " + result);
		}else if (resultCode == RESULT_CANCELED){
			Log.d(TAG, "RESULT_CANCELED: " + result);
		}else{
			Log.d(TAG, "RESULT: " + resultCode);
		}
	}


}
