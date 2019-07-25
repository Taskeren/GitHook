package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanMilestone;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventMilestone extends Event {

	private String action;
	
	private BeanMilestone milestone;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
