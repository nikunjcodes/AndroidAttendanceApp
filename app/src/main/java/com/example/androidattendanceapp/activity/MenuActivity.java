package com.example.androidattendanceapp.activity;

import java.util.ArrayList;


import com.example.androidattendanceapp.R;
import com.example.androidattendanceapp.activity.AddAttandanceSessionActivity;
import com.example.androidattendanceapp.activity.AddStudentActivity;
import com.example.androidattendanceapp.activity.MainActivity;
import com.example.androidattendanceapp.bean.AttendanceBean;
import com.example.androidattendanceapp.bean.FacultyBean;
import com.example.androidattendanceapp.bean.AttendanceSessionBean;
import com.example.androidattendanceapp.bean.StudentBean;
import com.example.androidattendanceapp.context.ApplicationContext;
import com.example.androidattendanceapp.db.DBAdapter;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	Button addStudent;
	Button addFaculty;
	Button viewStudent;
	Button viewFaculty;
	Button logout;
	Button attendancePerStudent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		addStudent =(Button)findViewById(R.id.buttonaddstudent);
		addFaculty =(Button)findViewById(R.id.buttonaddfaculty);
		viewStudent =(Button)findViewById(R.id.buttonViewstudent);
		viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
		logout =(Button)findViewById(R.id.buttonlogout);
		
		addStudent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this, AddStudentActivity.class);
				startActivity(intent);
			}
		});
		
		addFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this, AddFacultyActivity.class);
				startActivity(intent);
			}
		});
		
		viewFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this, ViewFacultyActivity.class);
				startActivity(intent);
			}
		});



		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		attendancePerStudent=(Button)findViewById(R.id.attendancePerStudentButton);
		attendancePerStudent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBAdapter dbAdapter = new DBAdapter(MenuActivity.this);
				ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
				((ApplicationContext)MenuActivity.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);
				
				Intent intent = new Intent(MenuActivity.this,ViewAttendancePerStudentActivity.class);
				startActivity(intent);
				
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
