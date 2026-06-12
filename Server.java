package com.backend;
import java.net.*;
import java.io.*;
import java.net.ServerSocket;


public class Server {
    public void main(String[] args) throws IOException {
        int port = 5000;

        java.net.ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("server started...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected...");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = input.readLine();

        System.out.println("Server says message from client is: " + message);

        out.println("Hello" + message);

        socket.close();
        serverSocket.close();
    }
}
