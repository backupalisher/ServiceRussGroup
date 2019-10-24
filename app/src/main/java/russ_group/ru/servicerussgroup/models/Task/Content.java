package russ_group.ru.servicerussgroup.models.Task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content{

	@SerializedName("master_id")
	private String masterId;

	@SerializedName("workStatus")
	private WorkStatus workStatus;

	@SerializedName("device_id")
	private String deviceId;

	@SerializedName("execution_date")
	private String executionDate;

	@SerializedName("jobHasHistories")
	private List<Object> jobHasHistories;

	@SerializedName("client_address_id")
	private String clientAddressId;

	@SerializedName("work_status_id")
	private String workStatusId;

	@SerializedName("clientAddress")
	private ClientAddress clientAddress;

	@SerializedName("master")
	private Master master;

	@SerializedName("task")
	private String task;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("id")
	private String id;

	@SerializedName("create_date")
	private String createDate;

	@SerializedName("order_id")
	private Object orderId;

	@SerializedName("device")
	private Device device;

	@SerializedName("user")
	private User user;

	@SerializedName("order")
	private Object order;

	public void setMasterId(String masterId){
		this.masterId = masterId;
	}

	public String getMasterId(){
		return masterId;
	}

	public void setWorkStatus(WorkStatus workStatus){
		this.workStatus = workStatus;
	}

	public WorkStatus getWorkStatus(){
		return workStatus;
	}

	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setExecutionDate(String executionDate){
		this.executionDate = executionDate;
	}

	public String getExecutionDate(){
		return executionDate;
	}

	public void setJobHasHistories(List<Object> jobHasHistories){
		this.jobHasHistories = jobHasHistories;
	}

	public List<Object> getJobHasHistories(){
		return jobHasHistories;
	}

	public void setClientAddressId(String clientAddressId){
		this.clientAddressId = clientAddressId;
	}

	public String getClientAddressId(){
		return clientAddressId;
	}

	public void setWorkStatusId(String workStatusId){
		this.workStatusId = workStatusId;
	}

	public String getWorkStatusId(){
		return workStatusId;
	}

	public void setClientAddress(ClientAddress clientAddress){
		this.clientAddress = clientAddress;
	}

	public ClientAddress getClientAddress(){
		return clientAddress;
	}

	public void setMaster(Master master){
		this.master = master;
	}

	public Master getMaster(){
		return master;
	}

	public void setTask(String task){
		this.task = task;
	}

	public String getTask(){
		return task;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCreateDate(String createDate){
		this.createDate = createDate;
	}

	public String getCreateDate(){
		return createDate;
	}

	public void setOrderId(Object orderId){
		this.orderId = orderId;
	}

	public Object getOrderId(){
		return orderId;
	}

	public void setDevice(Device device){
		this.device = device;
	}

	public Device getDevice(){
		return device;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setOrder(Object order){
		this.order = order;
	}

	public Object getOrder(){
		return order;
	}
}