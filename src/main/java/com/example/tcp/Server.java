package com.example.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Adnan_Khan
 *
 */
public class Server {

    private static final Integer PORT = 1300;

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("waiting for request .....");
        while(true) {
            Socket client = server.accept();
            new IncomingMessageThread(client);
            System.out.println("request accepted");

            new OutgoingMessageThread(client);
        }
    }
}