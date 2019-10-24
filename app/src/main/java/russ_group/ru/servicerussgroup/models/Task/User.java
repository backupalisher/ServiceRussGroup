package russ_group.ru.servicerussgroup.models.Task;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("id")
	private String id;

	@SerializedName("fio")
	private String fio;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFio(String fio){
		this.fio = fio;
	}

	public String getFio(){
		return fio;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}