package russ_group.ru.servicerussgroup.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import russ_group.ru.servicerussgroup.R;

public class TaskDescriptionActivity extends AppCompatActivity {

    SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    Date oldDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_description);
    }
}
