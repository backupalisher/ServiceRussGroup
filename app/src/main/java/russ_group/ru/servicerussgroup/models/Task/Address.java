package russ_group.ru.servicerussgroup.models.Task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Address{

	@SerializedName("address")
	private String address;

	@SerializedName("geozone_id")
	private Object geozoneId;

	@SerializedName("address_ao")
	private Object addressAo;

	@SerializedName("contactPerson")
	private List<Object> contactPerson;

	@SerializedName("location_lon")
	private String locationLon;

	@SerializedName("id")
	private String id;

	@SerializedName("geozone")
	private Object geozone;

	@SerializedName("location_lat")
	private String locationLat;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setGeozoneId(Object geozoneId){
		this.geozoneId = geozoneId;
	}

	public Object getGeozoneId(){
		return geozoneId;
	}

	public void setAddressAo(Object addressAo){
		this.addressAo = addressAo;
	}

	public Object getAddressAo(){
		return addressAo;
	}

	public void setContactPerson(List<Object> contactPerson){
		this.contactPerson = contactPerson;
	}

	public List<Object> getContactPerson(){
		return contactPerson;
	}

	public void setLocationLon(String locationLon){
		this.locationLon = locationLon;
	}

	public String getLocationLon(){
		return locationLon;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setGeozone(Object geozone){
		this.geozone = geozone;
	}

	public Object getGeozone(){
		return geozone;
	}

	public void setLocationLat(String locationLat){
		this.locationLat = locationLat;
	}

	public String getLocationLat(){
		return locationLat;
	}
}