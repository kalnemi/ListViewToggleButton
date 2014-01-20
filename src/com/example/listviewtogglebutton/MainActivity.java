package com.example.listviewtogglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity 
{
	private TestAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		adapter = new TestAdapter(this);
		ListView listView = (ListView) findViewById( R.id.listView );
		listView.setAdapter(adapter);
		listView.setOnItemClickListener ( new OnItemClickListener()
		{
			@Override
			public void onItemClick ( AdapterView<?> lv, View item,int position, long id )
			{
				adapter.setSelectedIndex(position);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}