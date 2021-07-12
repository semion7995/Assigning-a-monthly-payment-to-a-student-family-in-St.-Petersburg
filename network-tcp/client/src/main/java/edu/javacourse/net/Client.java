package edu.javacourse.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
        for (int i = 0; i < 8; i++) {
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }

}

class SimpleClient extends Thread{
        private final static String [] COMMAND = {
                "HELLO", "MORNING", "DAY", "EVENING"
        };
        private int cmdNumber;
        public SimpleClient (int cmdNumber){
            this.cmdNumber = cmdNumber;
        }

    @Override
    public void run() {
        try {

//            System.out.println("Started:" + LocalDateTime.now());
            Socket socket = new Socket("127.0.0.1", 25225);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String command = COMMAND[cmdNumber % COMMAND.length];

            String sb = command + " " + "Semen";

            bw.write(sb);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("Client got string:" + answer);

            br.close();
            bw.close();
//            System.out.println("Finished:" + LocalDateTime.now());
        } catch (Exception ex){
            ex.printStackTrace(System.out);
        }
    }
}
