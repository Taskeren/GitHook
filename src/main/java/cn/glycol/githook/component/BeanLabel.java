package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanLabel {

	private String name;
	
	private String color;
	
	@SerializedName(value = "default")
	private boolean Default;
	
}
