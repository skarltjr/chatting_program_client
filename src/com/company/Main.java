package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
    private static final int PORT = 8080;
    public static void main(String[] args) {
	    //client socket
        Socket socket = null;
        try {
            //connect
            socket = new Socket();
            socket.connect(new InetSocketAddress("localhost",PORT));

            SenderThread senderThread = new SenderThread(socket);
            ReceiveThread receiveThread = new ReceiveThread(socket);
            senderThread.start();
            receiveThread.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
