package russ_group.ru.servicerussgroup.models.TaskList;

import com.google.gson.annotations.SerializedName;

public class ContactPersonItem{

	@SerializedName("mobile_phone")
	private String mobilePhone;

	@SerializedName("additional_phone")
	private String additionalPhone;

	@SerializedName("client_address_id")
	private String clientAddressId;

	@SerializedName("name")
	private String name;

	@SerializedName("work_phone")
	private String workPhone;

	@SerializedName("id")
	private String id;

	@SerializedName("position")
	private String position;

	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone(){
		return mobilePhone;
	}

	public void setAdditionalPhone(String additionalPhone){
		this.additionalPhone = additionalPhone;
	}

	public String getAdditionalPhone(){
		return additionalPhone;
	}

	public void setClientAddressId(String clientAddressId){
		this.clientAddressId = clientAddressId;
	}

	public String getClientAddressId(){
		return clientAddressId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setWorkPhone(String workPhone){
		this.workPhone = workPhone;
	}

	public String getWorkPhone(){
		return workPhone;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}
}