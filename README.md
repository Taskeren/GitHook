# GitHook：GitHub Webhook Handler

GitHook 用于处理来自 GitHub 的 Webhook 事件。

## 配置 GitHook

先准备一个 GitHook 实例，你可以选择使用默认的配置，或者自行修改配置，如下面的实例。

```java
GitHook githook = new GitHook(new GitHookConfiguration().setMessageFailure("Oooops."));
```

然后倒入 Webhook 监听器。

```java
GitHookListener listener = new GitHookListener() {

    @Override
    public void onWebhook(Event event){
        System.out.println(event);
    }

};

githook.getManager().add(listener);
```

## 启动 GitHook

GitHook 可以使用内置的 HttpServer 方法进行启动，也可以外挂到其他的 HttpServer 进行监听。

### 启动内置 HttpServer

```java
githook.start();
```

### 使用其他的 HttpServer

```java
HttpServer server = HttpServer.create(InetSocketAddress(8080)); // 这里模拟其他API提供了 HttpServer
server.createContext(githook.config.getPath(), new GitHookHttpHandler(githook)); // 向 HttpServer 注册监听器，也就是 GitHookHttpHandler 实例
server.start(); // 启动 HttpServer
```

## 处理事件

继续以 Listener 为例，这里展示如何处理一个 Star 事件。

```java
GitHookListener listener = new GitHookListener() {

    public void onWebhook(Event event) {
        if(event instanceof EventStar) {
            EventStar evt = (EventStar) event;
            String action = evt.getAction();
            if(action.contentEquals("created")) {
                System.out.println("我收到了一个新的Star");
            }
            if(action.contentEquals("deleted")) {
                System.out.println("我失去了一个已有Star");
            }
        } else {
            System.out.println("这不是一个Star事件");
        }
    }

}
```

### 支持事件列表

目前还没有实现全部的事件，仅提供下表，其余都作为默认的 `Event` 向外发布，`Event` 可以使用 `getContent()` 自行解析JSON数据进行操作。

| 支持的事件名称（GitHub） | 支持的事件名称（GitHook） |
| :-: | :-: |
| commit_comment | EventCommitComment |
| fork | EventFork |
| gollum | EventGollum |
| issues | EventIssue |
| issue_comment | EventIssueComment |
| label | EventLabel |
| member | EventMember |
| milestone | EventMilestone |
| page_build | EventPageBuild |
| push | EventPush |
| release | EventRelease |
| repository | EventRepository |
| star | EventStar |