package com.yufeng.base;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author yufeng.yin
 * @date 2019/5/3
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        int port = 8000;
        final ServerSocket serverSocket = new ServerSocket(port);

        //接受连接新线程
        new Thread(()->{
            while (true){
                try {
                    //堵塞方式获得新连接
                    Socket socket = serverSocket.accept();
                    //每一个新连接都创建一个新线程，负责读取数据
                    new Thread(()->{
                        while (true){
                            try {
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                while (true){
                                    int len;
                                    while ((len = inputStream.read(data)) !=-1){
                                        System.out.println(new String(data,0,len));
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }


                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
