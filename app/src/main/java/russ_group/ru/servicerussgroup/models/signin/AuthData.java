package russ_group.ru.servicerussgroup.models.signin;

import com.google.gson.annotations.SerializedName;

public class AuthData {
    @SerializedName("login")
    public String login;

    @SerializedName("password")
    public String password;

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
