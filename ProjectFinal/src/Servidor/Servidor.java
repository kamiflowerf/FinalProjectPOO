package Servidor;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Iniciando conexión");
            serverSocket = new ServerSocket(7000);
            System.out.println("Aceptando conexiones en la IP: " + serverSocket.getInetAddress());
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada: " + ioe);
            System.exit(1);
        }

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexión aceptada de: " + clientSocket.getInetAddress());

               
                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                String fileName = dataInputStream.readUTF();

             
                FileOutputStream fileOutputStream = new FileOutputStream("servidor_" + fileName);
                byte[] buffer = new byte[4096];
                int bytesRead;

         
                while ((bytesRead = dataInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.close();
                dataInputStream.close();
                clientSocket.close();
                System.out.println("Archivo " + fileName + " recibido y guardado.");

            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }
}
