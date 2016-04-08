package com.example.tcp;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Adnan_Khan
 *
 */
public class OutgoingMessageThread implements Runnable {
    Thread t;
    Socket client;

    OutgoingMessageThread(Socket client) {
        this.client = client;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            PrintStream ps2 = new PrintStream(client.getOutputStream());
            while (true) {
                String st = scanner.nextLine();
                    ps2.println(st);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}