package com.example.listviewtogglebutton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TestAdapter extends BaseAdapter
{
	String[] countries = new String[] {
			"India",
			"Pakistan",
			"Sri Lanka",
			"China",
			"Bangladesh",
			"Nepal",
			"Afghanistan",
			"North Korea",
			"South Korea",
			"India",
			"Pakistan",
			"Sri Lanka",
			"China",
			"Bangladesh",
			"Nepal",
			"Afghanistan",
			"North Korea",
			"South Korea",
			"India",
			"Pakistan",
			"Sri Lanka",
			"China",
			"Bangladesh",
			"Nepal",
			"Afghanistan",
			"North Korea",
			"South Korea",
			"India",
			"Pakistan",
			"Sri Lanka",
			"China",
			"Bangladesh",
			"Nepal",
			"Afghanistan",
			"North Korea",
			"South Korea",
			"Japan"
	};

	// Array of booleans to store toggle button status
	public boolean[] status = {
			true,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false
	};

	private Context context;
	private List<HashMap<String,Object>> aList;
	
	public TestAdapter ( Context context )
	{
		this.context = context;
		
		aList = new ArrayList<HashMap<String,Object>>();
		
		for ( int i = 0 ; i < status.length ; i++ )
		{
			HashMap<String,Object> hm1 = new HashMap<String,Object>();
			hm1.put( "txt", countries[i] );
			hm1.put( "stat", status[i] );
			aList.add(hm1);
		}
	}
	
	public TestAdapter ( Context context, List<HashMap<String,Object>> aList )
	{
		this.context = context; 
		this.aList = aList; 
	}

	public void setSelectedIndex ( int index )
	{
		if ( status[index] == true )
		{
			status[index] = false;
		}
		else
		{
			status[index] = true;
		}
		
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() 
	{
		return aList.size();
	}

	@Override
	public Object getItem(int position) 
	{
		return aList.get(position);	
	}

	@Override
	public long getItemId(int position) 
	{
		return position;
	}

	private class ViewHolder
	{
		TextView tv; 
		ToggleButton tb;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) 
	{
		View vi = convertView; 
		final ViewHolder holder; 
		
		if ( convertView == null )
		{
			vi = LayoutInflater.from(context).inflate( R.layout.lv_layout,parent,false );
			holder = new ViewHolder();
			holder.tv = (TextView) vi.findViewById( R.id.tv_item );
			holder.tb = (ToggleButton) vi.findViewById( R.id.tgl_status );
			vi.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) vi.getTag();
		}

		holder.tv.setText(countries[position]);
		holder.tb.setChecked(status[position]);
		
		return vi;
	}
}