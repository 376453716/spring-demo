package com.xh.networkdemo.nio;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Xiong Hao
 */
public class SimpleSocketClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.1.94", 1024)) {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            pw.println("test");
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
