package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanComment {

	@SerializedName(value = "html_url")
	private String url;
	
	private BeanUser user;
	
	@SerializedName(value = "author_association")
	private String authorAssociation;
	
	@SerializedName(value = "body")
	private String content;
	
	@SerializedName(value = "commit_id")
	private String commitId;
}
