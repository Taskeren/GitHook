package cn.glycol.githook.component;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanBuild {

	private String status;
	
	private BeanError error;
	
	private BeanUser pusher;
	
	private String commit;
	
	private int duration;
	
	@SerializedName(value = "created_at")
	private String createdAt;
	
	@SerializedName(value = "updated_at")
	private String updatedAt;
	
	@Getter
	@ToString
	public static class BeanError {
		
		private String message;
		
	}
}
