package edu.javacourse.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {



    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket socket = new ServerSocket(25225, 2000);

        Map<String, Greetable> handlers = loadHandlers();

        System.out.println("Server is started");
        while (true){
            Socket client = socket.accept();//повисаем и слушаем комман поток программы остановился и ждёт изменений
            new SimpleServer(client, handlers).start();// тут я создал для каждого запроса отдельный поток ;//дождавшись изменений серверный сокет создаёт обычный сокет и с этим уже как с обычным работаем
        }
    }

    private static Map<String, Greetable> loadHandlers() {
        Map<String, Greetable> result = new HashMap<>();
        try (InputStream is = Server.class.getClassLoader().getResourceAsStream("server.properties")){
            Properties properties = new Properties(); //загружаем properties
            properties.load(is);

            for (Object command : properties.keySet()){
                String className = properties.getProperty(command.toString());
                Class<Greetable> cl =(Class<Greetable>) Class.forName(className);//создаём объект по ключу server.properties

                Greetable handler = cl.getConstructor().newInstance();//создали объект
                result.put(command.toString(), handler);//кладём объект в наше хранилище
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);//при ошибке всё упадёт сразу

        }
        return result;
    }


}

class SimpleServer extends Thread {
        private Socket client;
        private Map<String, Greetable> handlers;

        public SimpleServer(Socket client, Map<String, Greetable> handlers){
            this.client = client;
            this.handlers = handlers;
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
        Greetable handler = handlers.get(command);
        if (handler!=null){
            return handler.buildResponse(userName);
        }
        return "Hello, " + userName;
    }
}


