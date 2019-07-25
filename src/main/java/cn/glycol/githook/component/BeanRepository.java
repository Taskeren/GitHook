package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanRepository {

	private String name;
	
	@SerializedName(value = "full_name")
	private String fullName;
	
	@SerializedName(value = "private")
	private boolean Private;
	
	private BeanUser owner;
	
	@SerializedName(value = "html_url")
	private String url;
	
	@SerializedName(value = "homepage")
	private String homepage;
	
	@SerializedName(value = "stargazers_count")
	private int stargazers;
	
	@SerializedName(value = "watchers_count")
	private int watchers;
	
	@SerializedName(value = "forks_count")
	private int forks;
	
	private String language;
}
