package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanIssue;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventIssue extends Event {

	private String action;
	
	private BeanIssue issue;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
