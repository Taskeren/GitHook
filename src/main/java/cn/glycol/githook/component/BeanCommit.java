package cn.glycol.githook.component;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BeanCommit {

	private String sha;
	
	private String message;
	
	private BeanAuthor author;
	
	@Getter
	@ToString
	public static class BeanAuthor {
		
		private String name;
		
		private String email;
		
	}
	
}
