package cn.glycol.githook.event;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import cn.glycol.githook.component.BeanCommit;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventPush extends Event {

	private String ref;
	
	private String before;
	
	private String after;
	
	private boolean created;
	
	private boolean deleted;
	
	private boolean forced;
	
	@SerializedName(value = "base_ref")
	private String baseRef;
	
	private String compare;
	
	private List<BeanCommit> commits;
	
	private BeanRepository repository;
	
	private BeanUser pusher;
	
	private BeanUser sender;
	
}
