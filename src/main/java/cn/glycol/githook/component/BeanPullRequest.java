package cn.glycol.githook.component;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanPullRequest {

	@SerializedName(value = "html_url")
	private String url;
	
	@SerializedName(value = "diff_url")
	private String diffUrl;
	
	@SerializedName(value = "patch_url")
	private String patchUrl;
	
	private int number;
	
	private String state;
	
	private boolean locked;
	
	private String title;
	
	private BeanUser user;
	
	@SerializedName(value = "body")
	private String content;
	
	@SerializedName(value = "created_at")
	private String createdAt;
	
	@SerializedName(value = "updated_at")
	private String updatedAt;
	
	@SerializedName(value = "merged_at")
	private String mergedAt;
	
	@SerializedName(value = "closed_at")
	private String closedAt;
	
	private BeanUser assignee;
	
	private List<BeanUser> assignees;
	
	@SerializedName(value = "requested_reviewers")
	private List<BeanUser> requestedReviewers;
	
	@SerializedName(value = "requested_teams")
	private List<BeanTeam> requestedTeams;
	
	private HeadAndBase head;
	
	private HeadAndBase base;
	
	@SerializedName(value = "_links")
	private Links links;
	
	@SerializedName(value = "author_association")
	private String authorAssociation;
	
	private boolean draft;
	
	private boolean merged;
	
	private String mergeable;
	
	private String rebaseable;
	
	@SerializedName(value = "mergeable_state")
	private String mergeableState;
	
	@SerializedName(value = "merged_by")
	private String mergedBy;
	
	private int comments;
	
	@SerializedName(value = "review_comments")
	private int reviewComments;
	
	@SerializedName(value = "maintianer_can_modify")
	private boolean maintainerCanModify;
	
	private int commits;
	
	private int additions;
	
	private int deletions;
	
	@SerializedName(value = "changed_files")
	private int changedFiles;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
	@Getter
	@ToString
	public static class HeadAndBase {
		
		private String label;
		
		private String ref;
		
		private String sha;
		
		private BeanUser user;
		
		private BeanRepository repo;
		
	}
	
	@Getter
	@ToString
	public static class Links {
		
		private Link html;
		
	}
	
	@Getter
	@ToString
	private static class Link {
		private String href;
	}
	
}
