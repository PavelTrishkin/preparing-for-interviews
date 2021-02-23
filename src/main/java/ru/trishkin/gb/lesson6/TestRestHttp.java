package ru.trishkin.gb.lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TestRestHttp {
    public static class Response{
        private String httpVersion;
        private String body;
        private int statusCode;
        private int contentLength;

        public Response (InputStream inputStream, boolean debug) throws IOException {
            String line = null;

            StringBuilder sb = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                line = reader.readLine();

                if (debug){
                    System.out.println(line);
                }

                parseStatusLine(line);

                do {
                    line = reader.readLine();
                    parseHeader(line);
                    if (debug){
                        System.out.println(line);
                    }
                    if (line.isEmpty()) {
                        break;
                    }
                }while (line != null);

                do {
                    line = reader.readLine();

                    if (debug){
                        System.out.println(line);
                    }
                }while (line != null);
            }
        }

        private void parseHeader(String line) {
            if (line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split("\\s+")[1]);
            }
        }

        private void parseStatusLine(String line) {
            String [] token = line.split("\\s+");
            httpVersion = token[0];
            statusCode = Integer.parseInt(token[1]);
        }

        private static void sendRequest(String host, int port, String method) throws IOException {
            try (Socket socket = new Socket(host, port)) {
                StringBuilder request = new StringBuilder();
                request.append(method + " /hello HTTP/1.1").append("\r\n");
                request.append("Host: ").append(host + ":" + port).append("\r\n");
                request.append("Accept: ").append("text/html;charset=UTF-8").append("\r\n");
                request.append("Connection: ").append("close").append("\r\n");
                request.append("Content-Type: ").append("text/html;charset=UTF-8").append("\r\n");
                request.append("\r\n");

                System.out.println(request.toString());
                socket.getOutputStream().write(request.toString().getBytes(StandardCharsets.UTF_8));
                socket.getOutputStream().flush();

                Response response = new Response(socket.getInputStream(), true);
            }
        }

        public static void main(String[] args) throws IOException {
            sendRequest("localhost", 8080, "GET");
        }
    }
}
