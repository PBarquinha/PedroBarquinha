package org.academiadecodigo.nanderthals;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;



public class Server {
    private Map<String, Socket> clients;

    public Server() {
        clients = new HashMap<>();
    }

    public static void main(String[] args) {
        int portNumber = 8585;
        Server server = new Server();
        server.start(portNumber);
    }

    public void start(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                Thread clientThread = new Thread(new ServerWorker(clientSocket, this));
                clientThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void addClient(String clientName, Socket clientSocket) {
        clients.put(clientName, clientSocket);
    }

    public synchronized void removeClient(String clientName) {
        clients.remove(clientName);
    }

    public void sendClientList(Socket clientSocket) throws IOException {
        OutputStream out = clientSocket.getOutputStream();
        StringBuilder clientList = new StringBuilder("Connected clients:");
        for (String clientName : clients.keySet()) {
            clientList.append(" ").append(clientName);
        }
        out.write(clientList.toString().getBytes());
        out.write("\n".getBytes());
        out.flush();
    }

    public void handleWhisper(String message, String sender) {
        String[] parts = message.split(" ", 3);
        if (parts.length == 3) {
            String recipient = parts[1];
            String whisperMessage = parts[2];

            Socket recipientSocket = clients.get(recipient);
            if (recipientSocket != null) {
                try {
                    OutputStream out = recipientSocket.getOutputStream();
                    out.write(("Whisper from " + sender + ": " + whisperMessage).getBytes());
                    out.write("\n".getBytes());
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void broadcastMessage(String message) {
        synchronized (clients) {
            for (Socket clientSocket : clients.values()) {
                try {
                    OutputStream out = clientSocket.getOutputStream();
                    out.write(message.getBytes());
                    out.write("\n".getBytes());
                    out.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
