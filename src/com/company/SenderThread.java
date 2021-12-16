package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread{
    Socket socket;

    public SenderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            while (true) {
                System.out.println("메세지를 입력해주세요. 종료를 원하시면 quit을 입력해주세요.");
                String message = reader.readLine();
                if (message.equals("quit")) {
                    break;
                }
                // client에게 전달
                printWriter.println(message);
                printWriter.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
