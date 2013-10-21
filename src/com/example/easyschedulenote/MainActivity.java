package com.example.easyschedulenote;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static Context appContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		appContext=getApplicationContext();
		
		ActionBar actionBar=getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		ActionBar.Tab CalendarTab=actionBar.newTab().setText("calender");
		ActionBar.Tab DayTab=actionBar.newTab().setText("day");
		
		Fragment calenderFragment=new CalendarFragment();
		Fragment dayFragment=new DayFragment();
		
		CalendarTab.setTabListener(new MyTabListener(calenderFragment));
		DayTab.setTabListener(new MyTabListener(dayFragment));
		
		actionBar.addTab(CalendarTab);
		actionBar.addTab(DayTab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
class MyTabListener implements ActionBar.TabListener{
	public Fragment fragment;
	public MyTabListener(Fragment fragment)
	{
		this.fragment=fragment;
	}
	@Override
	public void onTabReselected(Tab tab,FragmentTransaction ft)
	{
		Toast.makeText(MainActivity.appContext, "Reselected!!!!"	, Toast.LENGTH_LONG	).show();
	}
	@Override
	public void onTabSelected(Tab tab,FragmentTransaction ft)
	{
		ft.replace(R.id.fragment_container,fragment);
	}
	@Override
	public void onTabUnselected(Tab tab,FragmentTransaction ft)
	{
		ft.remove(fragment);
	}
}
