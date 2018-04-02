package com.xue.nio.selector;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author xueshun
 * @Create 2018-04-02 15:31
 */
public class NIOClient {

    // 通道管理器
    private Selector selector;

    /**
     * 获得一个Socket通道，并对该通道做一些初始化的工作
     *
     * @param ip   连接的服务器IP
     * @param port 连接服务器地址
     * @throws Exception
     */
    public void initClient(String ip, int port) throws Exception {
        //[1] 获得一个Socket通道
        SocketChannel channel = SocketChannel.open();

        //[2] 设置通道为非阻塞
        channel.configureBlocking(false);

        //[3] 获得一个通道管理器
        this.selector = Selector.open();

        //[4] 客户端连接服务器，其实方法执行并没有实现连接，需要在listen()方法中调用
        // 用channel.finishConnect(),才能连接
        channel.connect(new InetSocketAddress(ip, port));

        //[5] 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的时间，如果有，则处理
     *
     * @throws Exception
     */
    public void listen() throws Exception {
        while (true) {
            //选择一组可以警醒I/O操作的事件，放在selector中，客户端的该方法不会阻塞
            // 这里和服务端的方法不一样，当至少一个通道被选中时，selector的wakeup()方法被调用
            // 方法返回，而对于客户端来说，通道一直是被选中的
            selector.select();
            Iterator<SelectionKey> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();
                //删除已选的key，以防重入处理
                ite.remove();
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();

                    //如果正在连接，则完成连接
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }

                    //设置成非阻塞
                    channel.configureBlocking(false);

                    //这里可以给服务端发送信息
                    channel.write(ByteBuffer.wrap(new String("hello Service!").getBytes()));

                    // 在和服务端连接成功之后，为了可以接受服务端的信息，需要给通道设置读的权限
                    channel.register(this.selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    read(key);
                }
            }

        }
    }

    private void read(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();

        //创建读取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(40);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("client receive msg from server:" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    public static void main(String[] args) throws Exception {
        NIOClient client = new NIOClient();
        client.initClient("localhost",8989);
        client.listen();
    }
}
