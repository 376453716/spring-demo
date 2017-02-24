package com.xh.networkdemo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author Xiong Hao
 */
public class SimpleServer {

    public static void main(String[] args) {
        ServerSocketChannel ssc = null;
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress("localhost", 1024));
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            SocketChannel socketChannel = ssc.accept();
            while (true) {
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    if (key.isValid()) {
                        if (key.isAcceptable()) {
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
