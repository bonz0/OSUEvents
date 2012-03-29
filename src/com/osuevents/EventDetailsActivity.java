/**
 * 
 */
package com.osuevents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author farhang
 *
 */
public class EventDetailsActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    TextView tv = new TextView(this);
	    tv.setText("New Screen farhang");
	    setContentView(tv);
	
	    // TODO Auto-generated method stub
	}

}
