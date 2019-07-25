package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanUser {

	@SerializedName(value = "login")
	private String name;
	
	@SerializedName(value = "avatar_url")
	private String avatar;
	
	@SerializedName(value = "html_url")
	private String homeUrl;
	
}
