package russ_group.ru.servicerussgroup.models.Task;

import com.google.gson.annotations.SerializedName;

public class TaskResponse{

	@SerializedName("error")
	private String error;

	@SerializedName("content")
	private Content content;

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setContent(Content content){
		this.content = content;
	}

	public Content getContent(){
		return content;
	}
}