package cn.glycol.githook.component;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanIssue {

	@SerializedName(value = "html_url")
	private String url;
	
	private String title;
	
	private BeanUser user;
	
	private List<BeanLabel> labels;
	
	private String state;
	
	private boolean locked;
	
	private BeanUser assignee;
	
	private List<BeanUser> assignees;
	
	private BeanMilestone milestone;
	
	private int comments;
	
	@SerializedName(value = "created_at")
	private String createdAt;
	
	@SerializedName(value = "updated_at")
	private String updatedAt;
	
	@SerializedName(value = "closed_at")
	private String closedAt;
	
	@SerializedName(value = "author_association")
	private String authorAssociation;
	
	@SerializedName(value = "body")
	private String content;
}
