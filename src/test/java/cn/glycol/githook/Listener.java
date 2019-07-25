package cn.glycol.githook;

import cn.glycol.githook.event.Event;
import cn.glycol.githook.event.GitHookListener;

public class Listener extends GitHookListener {

	@Override
	public void onWebhook(Event event) {
		System.out.println("成功接收Webhook！");
		System.out.println(event);
		System.out.println(event.getClass());
	}
	
}
