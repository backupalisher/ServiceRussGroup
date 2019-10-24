package russ_group.ru.servicerussgroup.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import russ_group.ru.servicerussgroup.R;
import russ_group.ru.servicerussgroup.api.ServiceApi;
import russ_group.ru.servicerussgroup.data.Globals;
import russ_group.ru.servicerussgroup.models.signin.AuthData;
import russ_group.ru.servicerussgroup.models.signin.SigninData;

public class SignInActivity extends AppCompatActivity {
    SharedPreferences sPref;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        final EditText loginEdit = findViewById(R.id.loginEdit);
        final EditText passwordEdit = findViewById(R.id.passwordEdit);
        Button button = findViewById(R.id.signinButton);
        final CheckBox saveCheck = findViewById(R.id.saveCheck);

        sPref = getSharedPreferences("mSettings", MODE_PRIVATE);
        ((Globals) this.getApplication()).setToken(sPref.getString("token", ""));
        token = ((Globals) this.getApplication()).getToken();

        final ServiceApi serviceApi = ServiceApi.retrofit.create(ServiceApi.class);

        if (!token.trim().equals("")) {
//            String email = sPref.getString("login", "");
//            String password = sPref.getString("password", "");
//            loginEdit.setText(email);
//            passwordEdit.setText(password);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String login = String.valueOf(loginEdit.getText());
                final String password = String.valueOf(passwordEdit.getText());
//                try {
//                    token = Base64.encodeToString((login + ":" + password).getBytes("UTF-8"), Base64.NO_WRAP);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }

                AuthData authData = new AuthData();
                authData.setLogin(loginEdit.getText().toString());
                authData.setPassword(passwordEdit.getText().toString());

                final Call<SigninData> call = serviceApi.getTokenAccess(authData);
                call.enqueue(new Callback<SigninData>() {
                    @Override
                    public void onResponse(Call<SigninData> call, Response<SigninData> response) {
                        SigninData signinData = response.body();

                        ((Globals) getApplication()).setToken("Bearer " + signinData.getAuthToken());
                        token = ((Globals) getApplication()).getToken();
                        Log.d("mLog", token);

                        if (saveCheck.isChecked()) {
                            SharedPreferences.Editor ed = sPref.edit();

//                            ed.putString("login", String.valueOf(login));
//                            ed.putString("password", String.valueOf(password));
                            ed.putString("token", token);
//                            ed.putString("group", group);
//                            ed.putInt("user_id", user_id);

                            ed.commit();
                        }
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<SigninData> call, Throwable t) {
                        Log.e("mData", t.getMessage());
                    }
                });
            }
        });
    }
}
