package de.play.pocket.games;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;
import com.parse.*;


public class login extends Activity {

	EditText etusername;
	EditText etpasswort;
	String username;
	String passwort;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Window win = getWindow(); 
		win.requestFeature(Window.FEATURE_NO_TITLE); 
		win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Parse.initialize(this, "ZE5MPKgxmmYxUJgnCBgkEZnJBb3Gjj5IGclfvixO", "REUaPty5KcHKFhYFQGgr2gVxVadRBX9xamGsCJBZ");
		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
			userbereichopen();
		}else {
		    setContentView(R.layout.login);
			etusername = (EditText)findViewById(R.id.etusername);
			etpasswort = (EditText)findViewById(R.id.etpasswort);		}	


	}

	public void login (View view) {
		InputMethodManager inputManager = (InputMethodManager)
			getSystemService(Context.INPUT_METHOD_SERVICE); 

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
											 InputMethodManager.HIDE_NOT_ALWAYS);


		username = etusername.getText().toString();
		passwort = etpasswort.getText().toString();

		ParseUser.logInInBackground(username, passwort, new LogInCallback() {
				public void done(ParseUser user, ParseException e) {
					if (user != null) {
						userbereichopen();

					} else {
						//System.out.println("Login fehlgeschlagen");
						Context context = getApplicationContext();
						CharSequence text = "Login fehlgeschlagen";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				}
			});
	}
	public void registrieren (View view) {
		username = etusername.getText().toString();
		passwort = etpasswort.getText().toString();





		ParseUser user = new ParseUser();
		user.setUsername(username);
		user.setPassword(passwort);




		user.signUpInBackground(new SignUpCallback() {
				public void done(ParseException e) {
					if (e == null) {
						userbereichopen();

					} else {
						Context context = getApplicationContext();
						CharSequence text = "Registrierung fehlgeschlagen.";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				}
			});



	}

	public void back (View view) {
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	    overridePendingTransition(0,0);
	}
	public void userbereichopen () {
		Context context = getApplicationContext();
	    CharSequence text = "Hallo "+ username + "!";
	    int duration = Toast.LENGTH_SHORT;

	    Toast toast = Toast.makeText(context, text, duration);
	    toast.show();

	    Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	    overridePendingTransition(0,0);
	}
}
