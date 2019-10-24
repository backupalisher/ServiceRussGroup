package russ_group.ru.servicerussgroup.models.Task;

import com.google.gson.annotations.SerializedName;

public class Client{

	@SerializedName("inban")
	private String inban;

	@SerializedName("user_id")
	private Object userId;

	@SerializedName("manager_id")
	private Object managerId;

	@SerializedName("name")
	private String name;

	@SerializedName("logo")
	private Object logo;

	@SerializedName("comment")
	private String comment;

	@SerializedName("id")
	private String id;

	public void setInban(String inban){
		this.inban = inban;
	}

	public String getInban(){
		return inban;
	}

	public void setUserId(Object userId){
		this.userId = userId;
	}

	public Object getUserId(){
		return userId;
	}

	public void setManagerId(Object managerId){
		this.managerId = managerId;
	}

	public Object getManagerId(){
		return managerId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLogo(Object logo){
		this.logo = logo;
	}

	public Object getLogo(){
		return logo;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}