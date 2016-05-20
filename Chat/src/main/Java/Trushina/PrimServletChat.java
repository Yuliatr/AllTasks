package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashSet;


public class PrimServletChat extends HttpServlet {
    private static BufferedReader br;
    private static Writer  webWriter;
    private static HashSet<String> history = new HashSet<String>();
   //private static HashSet<String> history =null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        webWriter = response.getWriter();
        readFileWriteInBrowser(webWriter ,"../HTML/ChatHTML1.html");
        for (String mes: history) {
            webWriter.write(mes + "</br>");
        }
        readFileWriteInBrowser(webWriter ,"../HTML/ChatHTML2.html");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request != null) {
            String message = request.getParameter("message");
            history.add(message);
        }
        doGet(request, response);
    }

    public void readFileWriteInBrowser(Writer writer, String pathToFile)throws IOException {
        String mess;
        br = new BufferedReader((new FileReader(pathToFile)));

        while ((mess=br.readLine())!= null){
            writer.write(mess, 0, mess.length());
        }
    }
}