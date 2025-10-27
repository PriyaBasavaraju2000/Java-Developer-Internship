package ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        Socket clientSocket = null;
        PrintWriter output = null;
        BufferedReader userInput = null;

        try {
            clientSocket = new Socket("192.168.0.173", 5000);
            System.out.println("Connected to server: " + clientSocket);

            BufferedReader input = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));
            output = new PrintWriter(clientSocket.getOutputStream(), true);

            Thread readThread = new Thread(() -> {
                String message;
                try {
                    while ((message = input.readLine()) != null) {
                        System.out.println("CustomerCare: " + message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        input.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            readThread.start();

            userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = userInput.readLine()) != null) {
                output.println(message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.close();
            try {
                userInput.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
