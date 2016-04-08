package com.example.tcp;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Adnan_Khan
 *
 */
public class IncomingMessageThread implements Runnable {
    Thread t;
    Socket client;

    IncomingMessageThread(Socket client) {
        this.client = client;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(client.getInputStream());
            while (true) {
                System.out.println("MESSAGE : " + scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e);

        }
    }
}