package cn.glycol.githook;

import org.junit.Test;

public class TestGitHook {
	
	@Test
	public void test() throws Exception {
		GitHook gh = new GitHook();
		gh.getManager().add(new Listener());
		gh.start();
		while(true) {}
	}
}
