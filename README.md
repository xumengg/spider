# spider

源于一个无聊的晚上。。。

此项目是用java编写的一个轻量级爬虫框架，只需实现两个接口 ContentParse (内容解析器) 和  ResultProcessor (结果处理器) ，就可以实现自己爬虫实例。

支持自定义配置爬虫线程数量 ,  默认提供的是基于内存的 InMemoryUrlProvider , 也可以提供自己 UrlProvider 实现分布式部署。

原本的初衷的是自己想用来爬取武汉市楼盘信息用的。。。
