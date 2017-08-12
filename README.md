# rest-auth
用于内部系统之间接口调用身份验证。使用动态口令的方式，两个系统之间约定好规则，客户端系统请求服务端接口时调用SecretKeyClient.get()方法生成一个MD5密钥，服务端接收到请求后调用SecretKeyServer.auth()验证传来的密钥，如果返回true则验证成功，允许访问服务，否则拦截。密钥的生成是依照时间规则，每分钟会更换一次密钥。由于系统之间存在时间误差以及网络传输耗费的时间，服务端验证密钥时允许误差，源码设定的为2分钟，用户可以根据需要自行修改。