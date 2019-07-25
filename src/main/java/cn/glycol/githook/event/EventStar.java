package cn.glycol.githook.event;

import com.google.gson.annotations.SerializedName;

import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

/**
 * Star事件
 * @author Taskeren
 * @url https://developer.github.com/v3/activity/events/types/#starevent
 */
@Getter
@ToString
public class EventStar extends Event {
	
	/** created（创建star），deleted（取消star） */
	private String action;
	
	@SerializedName(value = "starred_at")
	private String starTime;
	
	private BeanRepository repository;
	
	private BeanUser sender;
}
