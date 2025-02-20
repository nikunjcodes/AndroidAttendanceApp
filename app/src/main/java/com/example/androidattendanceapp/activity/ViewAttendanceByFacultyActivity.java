package com.example.androidattendanceapp.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.androidattendanceapp.R;
import com.example.androidattendanceapp.activity.AddAttandanceSessionActivity;
import com.example.androidattendanceapp.bean.AttendanceBean;
import com.example.androidattendanceapp.bean.FacultyBean;
import com.example.androidattendanceapp.bean.AttendanceSessionBean;
import com.example.androidattendanceapp.bean.StudentBean;
import com.example.androidattendanceapp.context.ApplicationContext;
import com.example.androidattendanceapp.db.DBAdapter;


public class ViewAttendanceByFacultyActivity extends Activity {

	ArrayList<AttendanceBean> attendanceBeanList;
	private ListView listView;
	private ArrayAdapter<String> listAdapter;

	DBAdapter dbAdapter = new DBAdapter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.__listview_main);

		listView = (ListView) findViewById(R.id.listview);
		final ArrayList<String> attendanceList = new ArrayList<String>();
		attendanceList.add("Id | StudentName |  Status");

		attendanceBeanList = ((ApplicationContext) ViewAttendanceByFacultyActivity.this.getApplicationContext()).getAttendanceBeanList();

		for (AttendanceBean attendanceBean : attendanceBeanList) {
			String users = "";
			if (attendanceBean.getAttendance_session_id() != 0) {
				DBAdapter dbAdapter = new DBAdapter(ViewAttendanceByFacultyActivity.this);
				StudentBean studentBean = dbAdapter.getStudentById(attendanceBean.getAttendance_student_id());
				users = attendanceBean.getAttendance_student_id() + ".     " + studentBean.getStudent_firstname() + "," + studentBean.getStudent_lastname() + "                  " + attendanceBean.getAttendance_status();
			} else {
				users = attendanceBean.getAttendance_status();
			}

			attendanceList.add(users);
			Log.d("users: ", users);

		}


	}
}



