* 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
* 通道可以异步地读写。
* 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入
> FileChannel       从文件中读取数据
DatagramChannel     能通过UDP读写数据
SocketChannel       能通过TCP读写网络中的数据
ServerSocketChannel 可以监听新进来的TCP连接，想Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel.