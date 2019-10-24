package russ_group.ru.servicerussgroup.data;

import android.app.Application;

public class Globals extends Application {
    private String token;
    private String taskID;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
