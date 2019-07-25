package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanMilestone {

	@SerializedName(value = "html_ur")
	private String url;
	
	private int number;
	
	private String title;
	
	private String description;
	
	private BeanUser creator;
	
	@SerializedName(value = "open_issues")
	private int openIssues;
	
	@SerializedName(value = "closed_issues")
	private int closedIssues;
	
	private String state;
	
	@SerializedName(value = "created_at")
	private String createdAt;
	
	@SerializedName(value = "updated_at")
	private String updatedAt;
	
	@SerializedName(value = "due_on")
	private String dueOn;
	
	@SerializedName(value = "closed_at")
	private String closedAt;
}
