package cn.glycol.githook.event;

public abstract class GitHookListener {

	/**
	 * 当接收到 Webhook 时调用
	 * @param event Webhook
	 */
	public abstract void onWebhook(Event event);
	
}
