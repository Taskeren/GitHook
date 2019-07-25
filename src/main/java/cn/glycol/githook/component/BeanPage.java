package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanPage {

	@SerializedName(value = "page_name")
	private String name;
	
	private String title;
	
	private String summary;
	
	private String action;
	
	private String sha;
	
	@SerializedName(value = "html_url")
	private String url;
	
}
