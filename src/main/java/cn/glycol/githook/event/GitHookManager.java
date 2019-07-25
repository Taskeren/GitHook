package cn.glycol.githook.event;

import java.util.ArrayList;
import java.util.List;

public class GitHookManager {

	protected final List<GitHookListener> listeners;
	
	public GitHookManager() {
		listeners = new ArrayList<GitHookListener>();
	}
	
	public GitHookManager add(GitHookListener listener) {
		listeners.add(listener);
		return this;
	}
	
	public GitHookManager call(Event event) {
		listeners.forEach(listener -> listener.onWebhook(event));
		return this;
	}
	
}
