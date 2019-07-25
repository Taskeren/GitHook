package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventFork extends Event {

	private BeanRepository forkee;
	
	private BeanRepository repository;
	
	private BeanUser sender;
}
