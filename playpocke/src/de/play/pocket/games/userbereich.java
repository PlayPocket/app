package de.play.pocket.games;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import com.parse.*;


public class userbereich extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userbereich);
		
		
		Window win = getWindow(); 
		win.requestFeature(Window.FEATURE_NO_TITLE); 
		win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Parse.initialize(this, "ZE5MPKgxmmYxUJgnCBgkEZnJBb3Gjj5lGclfvixO", "REUaPty5KcHKFhYFQGgr2gVxVadRBG9xamGsCJBZ");

	}
	public void logout (View view) {
		ParseUser.logOut();
		ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	    overridePendingTransition(0,0);
	}
}
