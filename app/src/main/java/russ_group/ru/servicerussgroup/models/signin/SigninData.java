package russ_group.ru.servicerussgroup.models.signin;

import com.google.gson.annotations.SerializedName;

public class SigninData {

	@SerializedName("user_id")
	private int userId;

	@SerializedName("error")
	private String error;

	@SerializedName("auth_token")
	private String authToken;

	@SerializedName("group")
	private String group;

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setAuthToken(String authToken){
		this.authToken = authToken;
	}

	public String getAuthToken(){
		return authToken;
	}

	public void setGroup(String group){
		this.group = group;
	}

	public String getGroup(){
		return group;
	}

}