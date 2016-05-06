package SocketTasks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Writing {

    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost",15151);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("Hello world!", 0, 12);
            bw.newLine();
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
