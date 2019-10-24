package russ_group.ru.servicerussgroup.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import russ_group.ru.servicerussgroup.R;
import russ_group.ru.servicerussgroup.adapters.TaskList.TaskListAdapter;
import russ_group.ru.servicerussgroup.api.ServiceApi;
import russ_group.ru.servicerussgroup.data.Globals;
import russ_group.ru.servicerussgroup.models.TaskList.ContentItem;
import russ_group.ru.servicerussgroup.models.TaskList.TaskListResponse;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private List<ContentItem> taskList;

    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        loadDate("");
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        finish();
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

    private void loadDate(String status) {
        taskList = new ArrayList<>();

        mRecyclerView = findViewById(R.id.TaskRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        TaskListAdapter dataAdapter = new TaskListAdapter(taskList);
        mRecyclerView.setAdapter(dataAdapter);
        final ServiceApi serviceApi = ServiceApi.retrofit.create(ServiceApi.class);

        String token = ((Globals) this.getApplication()).getToken();

        final Call<TaskListResponse> call = serviceApi.getTaskList(token);
        call.enqueue(new Callback<TaskListResponse>() {
            @Override
            public void onResponse(Call<TaskListResponse> call, Response<TaskListResponse> response) {
                if (response.isSuccessful()) {
                    TaskListResponse taskListResponse = response.body();

                    List<ContentItem> contentItems = taskListResponse.getContent();
                    taskList.addAll(contentItems);
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                } else {
                    ResponseBody errorBody = response.errorBody();
                    try {
                        Log.e("mData", errorBody.string());
                        Toast.makeText(getApplicationContext(), errorBody.string(),
                                Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<TaskListResponse> call, Throwable t) {
                Log.e("mData", t.getMessage());
                Toast.makeText(getApplicationContext(), "Что-то пошло не так",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_signout) {
            sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
            SharedPreferences.Editor ed = sPref.edit();
            ed.remove("token");
//            ed.remove("login");
//            ed.remove("password");
//            ed.remove("group");
//            ed.remove("user_id");
            ed.commit();
            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
