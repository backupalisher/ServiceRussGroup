package russ_group.ru.servicerussgroup.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import russ_group.ru.servicerussgroup.R;
import russ_group.ru.servicerussgroup.api.ServiceApi;
import russ_group.ru.servicerussgroup.data.Globals;
import russ_group.ru.servicerussgroup.models.Task.TaskResponse;

public class TaskActivity extends AppCompatActivity {

    SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    Date oldDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        final TextView taskIDTextView = findViewById(R.id.taskIDTextView);
        final TextView companyName = findViewById(R.id.companyName);
        final TextView dateDeliveryText = findViewById(R.id.dateDeliveryText);
        final TextView timeDeliveryText = findViewById(R.id.timeDeliveryText);
        final TextView timeToCallText = findViewById(R.id.timeToCallText);
        final TextView addressText = findViewById(R.id.addressText);
        final TextView faceNameText = findViewById(R.id.faceNameText);
        final TextView phoneJobText = findViewById(R.id.phoneJobText);
        final TextView mobileText = findViewById(R.id.mobileText);
        final TextView additionalText = findViewById(R.id.additionalText);
        final TextView deviceName = findViewById(R.id.deviceName);
        final TextView managerName = findViewById(R.id.managerName);
        final EditText taskEditText = findViewById(R.id.taskEditText);
        final EditText descroptionEditText = findViewById(R.id.descroptionEditText);
        final Button okButton = findViewById(R.id.okButton);
        final Button cancelButton = findViewById(R.id.cancelButton);

        final ServiceApi serviceApi = ServiceApi.retrofit.create(ServiceApi.class);

        final Intent intent = getIntent();
        final String taskID = intent.getStringExtra("taskID");
        String token = ((Globals) this.getApplication()).getToken();

        final Call<TaskResponse> call = serviceApi.getTask(taskID, token);
        call.enqueue(new Callback<TaskResponse>() {

            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                TaskResponse taskResponse = response.body();

                try {
                    oldDate = oldDateFormat.parse(taskResponse.getContent().getExecutionDate().trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String dateTime = newDateFormat.format(oldDate);

                taskEditText.setText(taskResponse.getContent().getTask());

                taskIDTextView.setText(taskResponse.getContent().getId());
                companyName.setText(taskResponse.getContent().getClientAddress().getClient().getName());
                dateDeliveryText.setText(dateTime);
                addressText.setText(taskResponse.getContent().getClientAddress().getAddress().getAddress());
                managerName.setText(taskResponse.getContent().getUser().getFio());
                deviceName.setText(taskResponse.getContent().getDevice().getName());

            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });

        addressText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        + addressText.getText().toString()));
                startActivity(geoIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
