package com.backend;

import java.net.*;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public void main(String[] args) throws Exception {
        String ip = "localhost";
        int port = 5000;
        Socket socket = new Socket(ip, port);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);
        String msg = "";
        while(!Objects.equals(msg, "stop")) {
            System.out.println("Enter message");
            msg=scanner.nextLine();
            out.println(msg);
            String response = input.readLine();
            System.out.println("Response from server is: " + response);
        }

        socket.close();
    }
}
