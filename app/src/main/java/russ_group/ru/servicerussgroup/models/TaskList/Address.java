package russ_group.ru.servicerussgroup.models.TaskList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Address{

	@SerializedName("address")
	private String address;

	@SerializedName("geozone_id")
	private String geozoneId;

	@SerializedName("contactPerson")
	private List<ContactPersonItem> contactPerson;

	@SerializedName("location_lon")
	private String locationLon;

	@SerializedName("id")
	private String id;

	@SerializedName("geozone")
	private Geozone geozone;

	@SerializedName("location_lat")
	private String locationLat;

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setGeozoneId(String geozoneId){
		this.geozoneId = geozoneId;
	}

	public String getGeozoneId(){
		return geozoneId;
	}

	public void setContactPerson(List<ContactPersonItem> contactPerson){
		this.contactPerson = contactPerson;
	}

	public List<ContactPersonItem> getContactPerson(){
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

	public void setGeozone(Geozone geozone){
		this.geozone = geozone;
	}

	public Geozone getGeozone(){
		return geozone;
	}

	public void setLocationLat(String locationLat){
		this.locationLat = locationLat;
	}

	public String getLocationLat(){
		return locationLat;
	}
}