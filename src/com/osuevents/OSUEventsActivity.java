package com.osuevents;

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class OSUEventsActivity extends ListActivity {
	private Runnable loadHttp;
	public String resUI;
	public String getHttpResult(String url) {
	HttpClient httpClient = new DefaultHttpClient();
  	HttpContext localContext = new BasicHttpContext();
  	HttpGet httpGet = new HttpGet(url);
  	HttpResponse response1 = null;
		try {
			response1 = httpClient.execute(httpGet, localContext);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res = HttpHelper.request(response1);
		
		return res;
				
	} 

	/** Called when the activity is first created. */	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		refreshList();
	}
	private void function_in_ui(String res) {
		JsonObject jObject = new JsonObject(res);
		try {
			Event[] eventsArray = jObject.parseEvents();
			EventsList adapter = new EventsList(this, R.layout.list_item, eventsArray);
			setListAdapter(adapter);
			
			ListView lv = getListView();
			lv.setTextFilterEnabled(true);
			
			lv.setOnItemClickListener(new OnItemClickListener() {
			    public void onItemClick(AdapterView<?> parent, View view,
			        int position, long id) {
			    		Intent goToEventDetails = new Intent(OSUEventsActivity.this, EventDetailsActivity.class);
			    		startActivity(goToEventDetails);
			    	}
			});			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Runnable responseReceived = new Runnable() {
		public void run() {
			function_in_ui(resUI);
		};
	};
	private void refreshList() {
		loadHttp = new Runnable() {
			public void run() {
				resUI =  getHttpResult("http://192.168.1.105:3000/get_events");
		        runOnUiThread(responseReceived);
		    };
		};
		Thread thread =  new Thread(null, loadHttp, "ListingRetrieveBackground");
		thread.start();
	}
}