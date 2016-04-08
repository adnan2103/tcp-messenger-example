package com.example.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Adnan_Khan
 *
 */
public class Client
{
   public static void main(String args[]) throws IOException
    {
        try{
            String ipAddress = args[0];
            String port = args[1];
            System.out.println("sending connection request to IP : " +ipAddress + " PORT : " +port);

            Socket client = new Socket(ipAddress,Integer.parseInt(port));
            System.out.println("successfully connected.");

            new IncomingMessageThread(client);
            new OutgoingMessageThread(client);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}