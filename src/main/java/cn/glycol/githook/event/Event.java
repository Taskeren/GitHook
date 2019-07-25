package cn.glycol.githook.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Accessors(chain = true)
public class Event {

	@Setter
	@Getter
	private String content;
	
}
