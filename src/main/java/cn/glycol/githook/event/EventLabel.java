package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanLabel;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventLabel extends Event {

	private String action;
	
	private BeanLabel label;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
