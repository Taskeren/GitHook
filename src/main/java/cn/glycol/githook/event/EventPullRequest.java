package cn.glycol.githook.event;

import com.google.gson.annotations.SerializedName;

import cn.glycol.githook.component.BeanPullRequest;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventPullRequest extends Event {

	private String action;
	
	private int number;
	
	@SerializedName(value = "pull_request")
	private BeanPullRequest pullRequest;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
