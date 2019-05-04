package com.yufeng.base;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author yufeng.yin
 * @date 2019/5/3
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",8000);
                while (true){
                    socket.getOutputStream().write((new Date()+":hello world").getBytes());
                    socket.getOutputStream().flush();
                    Thread.sleep(2000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
