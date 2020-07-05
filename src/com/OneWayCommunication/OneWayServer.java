package com.OneWayCommunication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class OneWayServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(5000);
        Socket socket=serverSocket.accept();
        DataInputStream input=new DataInputStream(socket.getInputStream());

        System.out.println("Response form client");

        String line = "";

        while (!line.equals("Over"))
        {
                line = input.readUTF();
                System.out.println(line);

        }
        socket.close();
        input.close();
    }
}
