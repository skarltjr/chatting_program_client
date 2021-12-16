package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
    Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // sender는 나의 입력을 읽고
        // receiver는 클라이언트로부터 온 메세지를 읽고
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String message = reader.readLine();
                if (message == null) {
                    break;
                }
                System.out.println("상대방 : " + message);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
