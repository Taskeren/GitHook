package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventMember extends Event {

	private String action;
	
	private BeanUser member;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
