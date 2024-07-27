package Servidor;

import java.io.*;
import java.net.*;

public class Servidor extends Thread {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Iniciando conexión");
            serverSocket = new ServerSocket(7000);
            System.out.println("Aceptando conexiones en la IP: " + serverSocket.getInetAddress());

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {
                     
                    System.out.println("Conexión aceptada de: " + clientSocket.getInetAddress());

                    String fileName = dataInputStream.readUTF();

                    try (FileOutputStream fileOutputStream = new FileOutputStream("servidor_" + fileName)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;

                        while ((bytesRead = dataInputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }

                        System.out.println("Archivo " + fileName + " recibido y guardado.");
                    }

                } catch (IOException ioe) {
                    System.out.println("Error: " + ioe);
                }
            }
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada: " + ioe);
            System.exit(1);
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el serverSocket: " + e);
                }
            }
        }
    }
}