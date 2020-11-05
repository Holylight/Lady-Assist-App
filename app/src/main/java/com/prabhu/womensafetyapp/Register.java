package com.prabhu.womensafetyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends Activity {
	FirebaseDatabase mfirebaseDatabase;
	DatabaseReference mreference;
	Button save,btnLocation;
	EditText name,number,harassment,location;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name = findViewById(R.id.editText1);
		number = findViewById(R.id.editText2);
		harassment = findViewById(R.id.editTextharass);
		save = findViewById(R.id.btn_register);
		btnLocation = findViewById(R.id.btn_location);
		location = findViewById(R.id.editTextlocation);

		String personalName = name.getText().toString().trim();
		String mobileNumber = number.getText().toString().trim();
		String reportharass = harassment.getText().toString().trim();

		btnLocation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Register.this,MapActivity.class);
				startActivity(intent);
			}
		});

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String personalName = name.getText().toString().trim();
				String mobileNumber = number.getText().toString().trim();
				String reportharass = harassment.getText().toString().trim();
				String caselocation = location.getText().toString().trim();

				if (personalName.isEmpty()){
					name.setError("Please enter name");
				}else if (mobileNumber.isEmpty()){
					number.setError("Please enter mobile number");
				}else if (reportharass.isEmpty()) {
					harassment.setError("Please enter the harassment");
				}else if (caselocation.isEmpty()) {
					location.setError("Please enter Location");
				}else{
					saveData();
				}

				}
		});

	}
	
	
	
	public void display(View v) {
		Intent i_view=new Intent(Register.this,Display.class);
		startActivity(i_view);
			
		}
	
	public void instructions(View v) {
		Intent i_help=new Intent(Register.this,Instructions.class);
		startActivity(i_help);
		
		}
	
	private void saveData(){
		String personalName = name.getText().toString().trim();
		String mobileNumber = number.getText().toString().trim();
		String reportharass = harassment.getText().toString().trim();
		String caselocation = location.getText().toString().trim();

		mfirebaseDatabase = FirebaseDatabase.getInstance();
		mreference = mfirebaseDatabase.getReference("Harass Report");

		Report_Data  report_data = new Report_Data(personalName,mobileNumber,reportharass,caselocation,String.valueOf(System.currentTimeMillis()));
		mreference.child(System.currentTimeMillis()+"").setValue(report_data);

		message("Successfuly ","Well received");
		clear();

	}
public void message(String tittle,String message){
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder.setTitle(tittle);
	builder.setMessage(message);
	builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			Intent i_help=new Intent(Register.this,MainActivity.class);
			startActivity(i_help);
		}
	});
	builder.create().show();
}
public void clear(){
	name.setText("");
	number.setText("");
	harassment.setText("");
}

}
