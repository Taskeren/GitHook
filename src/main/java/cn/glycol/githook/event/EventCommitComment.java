package cn.glycol.githook.event;

import cn.glycol.githook.component.BeanComment;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventCommitComment extends Event {

	private String action;
	
	private BeanComment comment;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
