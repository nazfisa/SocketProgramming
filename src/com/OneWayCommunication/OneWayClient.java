package com.OneWayCommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class OneWayClient {
    public static void main(String[] args) throws Exception {
        Socket socket=new Socket("localhost",5000);
        DataInputStream input=new DataInputStream(System.in);
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
        String line = "";
        while (!line.equals("Over"))
        {
                line = input.readLine();
                output.writeUTF(line);

        }

        input.close();
        output.close();
        socket.close();
    }
}
