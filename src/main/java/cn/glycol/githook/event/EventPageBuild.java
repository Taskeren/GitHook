package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanBuild;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventPageBuild extends Event {

	private BeanBuild build;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
