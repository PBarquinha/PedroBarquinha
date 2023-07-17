package org.academiadecodigo.nanderthals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;



public class ServerWorker implements Runnable {
    private Socket clientSocket;
    private Server server;

    public ServerWorker(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();

            out.write("Enter your name: ".getBytes());
            out.flush();
            String clientName = in.readLine();
            server.addClient(clientName, clientSocket);
            server.sendClientList(clientSocket);

            String messageFromClient;
            while ((messageFromClient = in.readLine()) != null) {
                System.out.println("Message from client: " + messageFromClient);
                if (messageFromClient.startsWith("/whisper ")) {
                    server.handleWhisper(messageFromClient, clientName);
                } else {
                    server.broadcastMessage(clientName + ": " + messageFromClient);
                }
            }

            server.removeClient(clientName);
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
