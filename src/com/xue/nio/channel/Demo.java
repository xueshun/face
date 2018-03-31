package com.xue.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel读取数据到Buffer
 *   注意： buf.flip()的调用，首先读取数据到Buffer，然后翻转到Buffer，接着再从Buffer中读取数据。
 * @Author xueshun
 * @Create 2018-03-30 17:45
 */
public class Demo {

    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile("G://nums.txt","rw");
            FileChannel inChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf);
            while(bytesRead != -1){
                System.out.println("Read" + bytesRead);
                buf.flip();

                while (buf.hasRemaining()){
                    System.out.println(buf.get());
                }
                buf.clear();
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

