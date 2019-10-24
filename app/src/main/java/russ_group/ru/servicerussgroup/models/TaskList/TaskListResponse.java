package russ_group.ru.servicerussgroup.models.TaskList;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskListResponse{

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("error")
	private String error;

	@SerializedName("count_pages")
	private int countPages;

	@SerializedName("content")
	private List<ContentItem> content;

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setCountPages(int countPages){
		this.countPages = countPages;
	}

	public int getCountPages(){
		return countPages;
	}

	public void setContent(List<ContentItem> content){
		this.content = content;
	}

	public List<ContentItem> getContent(){
		return content;
	}
}