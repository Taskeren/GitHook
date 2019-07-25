package cn.glycol.githook.event;

import java.util.List;

import cn.glycol.githook.component.BeanPage;
import cn.glycol.githook.component.BeanRepository;
import cn.glycol.githook.component.BeanUser;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EventGollum extends Event {
	
	private List<BeanPage> pages;
	
	private BeanRepository repository;
	
	private BeanUser sender;
	
}
