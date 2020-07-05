package com.TwoWayCommunication;
import java.net.*;
import java.io.*;
public class Client {
    public static void main(String args[])throws Exception{
        Socket socket=new Socket("localhost",3333);
        DataInputStream input=new DataInputStream(socket.getInputStream());
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Client is ready to server response");
        String str="",str2="";
        while(!str.equals("stop")){
            str=br.readLine();
            output.writeUTF(str);
            output.flush();
            str2=input.readUTF();
            System.out.println("Server says: "+str2);
        }

        output.close();
        socket.close();
    }
}
