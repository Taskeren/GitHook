package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanRelease {

	@SerializedName(value = "html_url")
	private String url;
	
	@SerializedName(value = "tag_name")
	private String tabName;
	
	@SerializedName(value = "target_commitish")
	private String targetCommitish;
	
	private String name;
	
	private boolean draft;
	
	private BeanUser author;
	
	private boolean prerelease;
	
	@SerializedName(value = "created_at")
	private String createdAt;
	
	@SerializedName(value = "published_at")
	private String publishedAt;
	
}
