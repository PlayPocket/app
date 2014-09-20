package de.play.pocket.games;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import com.mycompany.myapp.*;
import com.parse.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		
		Window win = getWindow(); 
		win.requestFeature(Window.FEATURE_NO_TITLE); 
		win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	
	public void apps(View view) {

		setContentView(R.layout.apps);}

	public void charts(View view) {

		setContentView(R.layout.charts);}
	
	public void news(View view) {

		setContentView(R.layout.news);}
	
		
	public void ppweb(View view) {

		setContentView(R.layout.ppweb);}
	
		
	public void games(View view) {

		setContentView(R.layout.games);}
	
	public void home(View view) {

		setContentView(R.layout.main);}
		
		
	
	public void loginopen (View view) {
		Intent intent = new Intent(this, login.class);
	    startActivity(intent);
	    overridePendingTransition(0,0);
	}
	public void logout (View view) {
		ParseUser.logOut();
		ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
		Intent intent = new Intent(this, login.class);
	    startActivity(intent);
	    overridePendingTransition(0,0);
	}

	 	@Override

	public boolean
	onKeyDown(int keyCode, KeyEvent event) {

		// return to the App's Home Activity

		if ((keyCode == KeyEvent.KEYCODE_BACK)) {

			Intent intent = new Intent(this, MainActivity.class);

			this.startActivity(intent);

		}

		return super.onKeyDown(keyCode, event);
}
	
}
