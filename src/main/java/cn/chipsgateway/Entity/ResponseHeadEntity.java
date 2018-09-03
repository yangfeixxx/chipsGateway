package cn.chipsgateway.Entity;

public class ResponseHeadEntity {
    private String AcceptRanges;
    private String age;	//从原始服务器到代理缓存形成的估算时间（以秒计，非负）	Age: 12
    private String allow;	//对某网络资源的有效的请求行为，不允许则返回405	Allow: GET, HEAD
    private String cacheControl;//	告诉所有的缓存机制是否可以缓存及哪种类型	Cache-Control: no-cache
    private String contentEncoding;	//web服务器支持的返回内容压缩编码类型。	Content-Encoding: gzip
    private String contentLanguage;	//响应体的语言	Content-Language: en,zh
    private String contentLength;	//响应体的长度	Content-Length: 348
    private String contentLocation;	//请求资源可替代的备用的另一地址	Content-Location: /index.htm
    private String contentMD5;//	返回资源的MD5校验值	Content-MD5: Q2hlY2sgSW50ZWdyaXR5IQ==
    private String contentRange;	//在整个返回体中本部分的字节位置	Content-Range: bytes 21010-47021/47022
    private String contentType;//	返回内容的MIME类型	Content-Type: text/html; charset=utf-8
    private String date;	//原始服务器消息发出的时间	Date: Tue, 15 Nov 2010 08:12:31 GMT
    private String eTag;//	请求变量的实体标签的当前值	ETag: “737060cd8c284d8af7ad3082f209582d”
    private String expires;	//响应过期的日期和时间	Expires: Thu, 01 Dec 2010 16:00:00 GMT
    private String lastModified;//	请求资源的最后修改时间	Last-Modified: Tue, 15 Nov 2010 12:45:26 GMT
    private String  location;//	用来重定向接收方到非请求URL的位置来完成请求或标识新的资源	Location: http://baidu.com
    private String pragma;	//包括实现特定的指令，它可应用到响应链上的任何接收方	Pragma: no-cache Proxy-Authenticate 它指出认证方案和可应用到代理的该URL上的参数 Proxy-Authenticate: Basic
    private String refresh;	//应用于重定向或一个新的资源被创造，在5秒之后重定向（由网景提出，被大部分浏览器支持）	Refresh: 5;url=http://1213.com
    private String retryAfter;//	如果实体暂时不可取，通知客户端在指定时间之后再次尝试	Retry-After: 120
    private String  server;	//web服务器软件名称	Server: Apache/1.3.27 (Unix) (Red-Hat/Linux)
    private String setCookie;	//设置Http Cookie	Set-Cookie: UserID=JohnDoe; Max-Age=3600; Version=1
    private String trailer;//	指出头域在分块传输编码的尾部存在	Trailer: Max-Forwards
    private String transferEncoding;//	文件传输编码	Transfer-Encoding:chunked
    private String vary;	//告诉下游代理是使用缓存响应还是从原始服务器请求	Vary: *
    private String  via;	//告知代理客户端响应是通过哪里发送的	Via: 1.0 fred, 1.1 nowhere.com (Apache/1.1)
}
