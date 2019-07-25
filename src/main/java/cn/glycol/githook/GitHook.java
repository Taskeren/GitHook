package cn.glycol.githook;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import cn.glycol.githook.event.GitHookManager;
import cn.hutool.log.GlobalLogFactory;
import cn.hutool.log.Log;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

public class GitHook {
	
	private static final Log LOGGER = GlobalLogFactory.get().createLog("GitHook");
	
	protected final GitHookConfiguration config;
	protected final GitHookManager manager;
	
	protected HttpServer server;
	
	public GitHook() {
		this(new GitHookConfiguration());
	}
	
	public GitHook(GitHookConfiguration config) {
		this.config = config;
		this.manager = new GitHookManager();
	}
	
	/**
	 * 启动HTTP监听器
	 * @throws IOException
	 */
	public void start() throws IOException {
		LOGGER.info("Starting GitHook Server");
		server = HttpServer.create(new InetSocketAddress(config.getPort()), 0);
		server.createContext(config.getPath(), new GitHookHttpHandler(this));
		server.start();
	}
	
	/**
	 * @return 返回管理器
	 */
	public GitHookManager getManager() {
		return manager;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class GitHookConfiguration {
		
		/** 监听端口 */
		private int port = 8080;
		
		/** 监听路径 */
		private String path = "/";
		
		/** 解析到POST并成功时返回的状态码 */
		private int respCodeSucceed = 233;
		
		/** 解析到GET或出错时返回的状态码 */
		private int respCodeFailure = 503;
		
		/** 请求不是 Webhook 时返回的状态码 */
		private int respCodeNotEvent = 200;
		
		/** 解析成功时返回的内容 */
		private String messageSucceed = "Handled";
		
		/** 解析失败时返回的内容 */
		private String messageFailure = "Unhandled";
		
		/** 请求不是 Webhook 时返回的内容 */
		private String messageNotEvent = "Hello, GitHook!";
	}
	
}
