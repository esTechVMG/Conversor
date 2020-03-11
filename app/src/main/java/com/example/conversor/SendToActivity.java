package com.example.conversor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.datatype.Duration;

public class SendToActivity extends AppCompatActivity {
    public DatePicker date;
    public TimePicker time;
    public Button sendEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        final Bundle b=getIntent().getExtras();
        time=findViewById(R.id.timePicker);
        date=findViewById(R.id.datePicker);
        sendEmail=findViewById(R.id.sendEmail);
        final String[] emailsList=new String[]{"example@example.com"};
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,emailsList);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Conversion");
                String outTime;
                if(android.os.Build.VERSION.SDK_INT>=23){
                    outTime=time.getHour() + ":" + time.getMinute();
                }else{
                    outTime=time.getCurrentHour() + ":" + time.getCurrentMinute();
                }
                intent.putExtra(Intent.EXTRA_TEXT,date.getDayOfMonth() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + outTime + System.lineSeparator()
                        + b.getDouble("OldValue") + b.getString("OldType") + "=" + b.getDouble("NewValue") + b.getString("NewType"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else{
                    Toast.makeText(SendToActivity.this, "No App found to send email",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
