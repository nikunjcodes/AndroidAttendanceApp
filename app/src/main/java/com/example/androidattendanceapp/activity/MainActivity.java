package com.example.androidattendanceapp.activity;


import com.example.androidattendanceapp.R;
import com.example.androidattendanceapp.activity.AddAttandanceSessionActivity;
import com.example.androidattendanceapp.bean.AttendanceBean;
import com.example.androidattendanceapp.bean.FacultyBean;
import com.example.androidattendanceapp.bean.AttendanceSessionBean;
import com.example.androidattendanceapp.bean.StudentBean;
import com.example.androidattendanceapp.context.ApplicationContext;
import com.example.androidattendanceapp.db.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		start =(Button)findViewById(R.id.buttonstart);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MainActivity.this,LoginActivity.class);
				startActivity(intent);
			}
		});



	}



}
