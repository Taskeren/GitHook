package cn.glycol.githook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import cn.glycol.githook.GitHook.GitHookConfiguration;
import cn.glycol.githook.event.Event;
import cn.glycol.githook.event.EventCommitComment;
import cn.glycol.githook.event.EventFork;
import cn.glycol.githook.event.EventGollum;
import cn.glycol.githook.event.EventIssue;
import cn.glycol.githook.event.EventIssueComment;
import cn.glycol.githook.event.EventLabel;
import cn.glycol.githook.event.EventMember;
import cn.glycol.githook.event.EventMilestone;
import cn.glycol.githook.event.EventPageBuild;
import cn.glycol.githook.event.EventPullRequest;
import cn.glycol.githook.event.EventPush;
import cn.glycol.githook.event.EventRelease;
import cn.glycol.githook.event.EventRepository;
import cn.glycol.githook.event.EventStar;
import cn.hutool.log.GlobalLogFactory;
import cn.hutool.log.Log;

public class GitHookHttpHandler implements HttpHandler {

	private static final Log LOGGER = GlobalLogFactory.get().createLog("GitHookHttpHandler");
	private static final Gson G = new Gson();
	
	protected final GitHook githook;
	protected final GitHookConfiguration config;
	
	public GitHookHttpHandler(GitHook githook) {
		this.githook = githook;
		this.config = githook.config;
	}
	
	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
		try {
			if("POST".contentEquals(exchange.getRequestMethod().toUpperCase())) {
				if(!exchange.getRequestHeaders().containsKey("X-github-event")) {
					response(exchange, config.getMessageNotEvent(), config.getRespCodeNotEvent());
					return;
				}
				
				// 获取 Webhook 类型
				String type = exchange.getRequestHeaders().get("X-github-event").get(0);
				// 获取 Webhook 内容
				String ctx = read(exchange.getRequestBody());
				// 解析 Webhook 到系统事件
				Event event = getEvent(type, ctx);
				// 发布事件
				githook.getManager().call(event);
				// 返回
				response(exchange, config.getMessageSucceed(), config.getRespCodeSucceed());
			} else {
				response(exchange, config.getMessageFailure(), config.getRespCodeFailure());
			}
		} catch(Exception ex) {
			LOGGER.error(ex);
			response(exchange, config.getMessageFailure(), config.getRespCodeFailure());
		}
	}
	
	public static Event getEvent(String type, String ctx) {
		
		switch(type) {
		
		case "commit_comment":
			return G.fromJson(ctx, EventCommitComment.class).setContent(ctx);
			
		case "fork":
			return G.fromJson(ctx, EventFork.class).setContent(ctx);
			
		case "gollum":
			return G.fromJson(ctx, EventGollum.class).setContent(ctx);
		
		case "issues":
			return G.fromJson(ctx, EventIssue.class).setContent(ctx);
			
		case "issue_comment":
			return G.fromJson(ctx, EventIssueComment.class).setContent(ctx);
			
		case "label":
			return G.fromJson(ctx, EventLabel.class).setContent(ctx);
			
		case "member":
			return G.fromJson(ctx, EventMember.class).setContent(ctx);
			
		case "milestone":
			return G.fromJson(ctx, EventMilestone.class).setContent(ctx);
			
		case "page_build":
			return G.fromJson(ctx, EventPageBuild.class).setContent(ctx);
			
		case "pull_request":
			return G.fromJson(ctx, EventPullRequest.class).setContent(ctx);
			
		case "push":
			return G.fromJson(ctx, EventPush.class).setContent(ctx);
			
		case "release":
			return G.fromJson(ctx, EventRelease.class).setContent(ctx);
			
		case "repository":
			return G.fromJson(ctx, EventRepository.class).setContent(ctx);
			
		case "star":
			return G.fromJson(ctx, EventStar.class).setContent(ctx);
			
		default:
			return new Event().setContent(ctx);
		}
		
	}
	
	private static void response(HttpExchange exchange, String message, int code) throws IOException {
		exchange.sendResponseHeaders(233, 0);
		OutputStream os = exchange.getResponseBody();
		os.write(message.getBytes());
		os.close();
	}
	
	private static String read(InputStream is) {
		Scanner scanner = new Scanner(is, "UTF-8");
		scanner.useDelimiter("\\A");
		String ctx = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		return ctx;
	}
	
}
