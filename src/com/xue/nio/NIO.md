## Java NIO
* Channels and Buffers(通道和缓冲区)
标准的IO基于字节流和字符流操作的，而NIO是基于通道(Channel)和缓冲区(Buffer)进行操作的，数据总是从通道读取到缓冲区中。或则从缓冲区写入到通道中。
* Non-blocking IO （非阻塞IO）
Java NIO可以非阻塞的使用IO,例如：当线程从通道读取数据到缓冲区时，线程还是可以进行其他事情。
当数据被写入到缓冲区时，线程可以继续处理它。从缓冲区写入通道也是类似。
* Selector（选择器）
Java NIO 引入了选择器的概念，选择器用于监听多个通道的事件（比如：连接打开，数据到达）。
因此单个的线程可以监听多个数据通道。