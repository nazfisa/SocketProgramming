package com.TwoWayCommunication;
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[])throws Exception{
        ServerSocket serverSocket=new ServerSocket(3333);
        Socket socket=serverSocket.accept();
        DataInputStream input=new DataInputStream(socket.getInputStream());
        DataOutputStream output=new DataOutputStream(socket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Server is ready to client response");
        String str="",str2="";
        while(!str.equals("stop")){
            str=input.readUTF();
            System.out.println("client says: "+str);
            str2=br.readLine();
            output.writeUTF(str2);
            output.flush();
        }
        input.close();
        socket.close();
        serverSocket.close();
    }
}
