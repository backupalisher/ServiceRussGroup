package russ_group.ru.servicerussgroup.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import russ_group.ru.servicerussgroup.models.Task.TaskResponse;
import russ_group.ru.servicerussgroup.models.TaskList.TaskListResponse;
import russ_group.ru.servicerussgroup.models.signin.AuthData;
import russ_group.ru.servicerussgroup.models.signin.SigninData;

public interface ServiceApi {
    @POST("index/login")
    Call<SigninData> getTokenAccess(@Body AuthData authData);

    @GET("service-tasks/index")
    Call<TaskListResponse> getTaskList(@Header("Authorization") String token);

    @GET("service-tasks/item")
    Call<TaskResponse> getTask(@Query("task_id") String task_id, @Header("Authorization") String token);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.serviceforward.ru/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
