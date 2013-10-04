package com.example.coursefr;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		StrictMode.setThreadPolicy(policy); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//On click event for rate this app button
    public void btnOnClick(View v) {
    	callURL();
	}
	
	public void callURL() {
		 String urlString = "FIXME";
		 InputStream in = null;
		    int response = -1;
		                
		    URL url;
			try {
				url = new URL(urlString);
			    URLConnection conn = url.openConnection();

			    HttpURLConnection httpConn = (HttpURLConnection) conn;
		        httpConn.setAllowUserInteraction(false);
		        httpConn.setInstanceFollowRedirects(true);
		        httpConn.setRequestMethod("GET");
		        httpConn.connect(); 
		 
		        response = httpConn.getResponseCode();                 
		        	if (response == HttpURLConnection.HTTP_OK) {
		        	in = httpConn.getInputStream();
		        	httpConn.disconnect();
		        	}                     
		    	
			    } catch (MalformedURLException e) {
				   // TODO Auto-generated catch block
			   	e.printStackTrace();
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		    return ;   
	}

}
