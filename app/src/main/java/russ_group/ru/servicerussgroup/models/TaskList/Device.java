package russ_group.ru.servicerussgroup.models.TaskList;

import com.google.gson.annotations.SerializedName;

public class Device{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("stop_make")
	private String stopMake;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStopMake(String stopMake){
		this.stopMake = stopMake;
	}

	public String getStopMake(){
		return stopMake;
	}
}