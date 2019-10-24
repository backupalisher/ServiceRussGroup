package russ_group.ru.servicerussgroup.models.TaskList;

import com.google.gson.annotations.SerializedName;

public class Geozone{

	@SerializedName("name_ao")
	private String nameAo;

	@SerializedName("id")
	private String id;

	public void setNameAo(String nameAo){
		this.nameAo = nameAo;
	}

	public String getNameAo(){
		return nameAo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}