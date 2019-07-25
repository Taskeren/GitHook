package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanRelease;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventRelease extends Event {

	private String action;
	
	private BeanRelease release;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
