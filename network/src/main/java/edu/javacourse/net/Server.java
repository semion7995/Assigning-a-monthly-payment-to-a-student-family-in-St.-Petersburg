package edu.javacourse.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket(25225, 2000);
        System.out.println("Server is started");
        while (true){
            Socket client = socket.accept();//повисаем и слушаем комман поток программы остановился и ждёт изменений
            new SimpleServer(client).start();// тут я создал для каждого запроса отдельный поток ;//дождавшись изменений серверный сокет создаёт обычный сокет и с этим уже как с обычным работаем
        }
    }


}
class SimpleServer extends Thread {
        private Socket client;

        public SimpleServer (Socket client){
            this.client = client;
        }

        public void run(){
            handleRequest();
        }
    private void handleRequest() {
            try {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String request = br.readLine();
        String[] lines = request.split("\\s+");
        String command = lines[0];
        String userName = lines[1];
        System.out.println("server got string 1:" + command);
        System.out.println("server got string 2:" + userName);

//        Thread.sleep(2000);

        String response = buildResponse(command, userName);
        bw.write(response.toString());
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        client.close();}
            catch (Exception ex){
            ex.printStackTrace(System.out);
            }
    }
    private String buildResponse (String command, String userName){
        switch (command){
            case "HELLO": return "Hello, " + userName;
            case "MORNING": return "Food Morning, " + userName;
            case "DAY": return "Good day, " + userName;
            case "EVENING": return "Good evening, " + userName;
            default: return "Hi, " + userName;
        }
    }
}


