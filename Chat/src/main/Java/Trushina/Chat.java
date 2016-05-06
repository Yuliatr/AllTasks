package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Chat extends HttpServlet {
    private int initCount = 0;
    private BufferedReader br;
    private BufferedWriter bw;
//add commit
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            String s1 = "Hello, World! " + initCount;
            writeLine(response, s1);

            writeLine(response, "HISTORY OF MESSAGES");
            readFileWriteInBrowser(response,"E:/Chat/src/main/resources/history.txt");
            readFileWriteInBrowser(response,"E:/Chat/src/main/resources/ChatHTML.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        initCount++;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {// принимает от пользователя новую строку, добавляет в кооллекциюю, возвращает новую коллекцию
        if (request != null) {
            String message = request.getParameter("message");
            addHistory(message,"E:/Chat/src/main/resources/history.txt" );
        }
        doGet(request, response);
    }

    public void writeLine(HttpServletResponse response, String message) throws IOException {
        message += "<br>";
        response.getWriter().write(message, 0, message.length());
    }

    public void readFileWriteInBrowser(HttpServletResponse response, String pathToFile)throws IOException {
        String mess;
        br = new BufferedReader((new FileReader(pathToFile)));
        //определение типа оправляемых данных
        response.setContentType("text/html;charset=UTF-8");
        if (pathToFile.endsWith(".txt")) {
            while ((mess = br.readLine()) != null) {
                response.getWriter().write(mess + "</br>");
            }
        } else {
            while ((mess=br.readLine())!= null){
                response.getWriter().write(mess, 0, mess.length());
            }
        }
    }

    public void addHistory(String message, String pathToHistory) throws IOException {
        if (message != null) {
            // true -> данные записываются в конец файла (вместо перезапии всего файла)
            FileWriter fl = new FileWriter(pathToHistory, true);
            bw = new BufferedWriter(fl);
            bw.newLine();
            bw.write(message);
            bw.flush();
            //fl.flush(); // destination все время один и тот же
            fl.close();
            bw.close();
        }
    }
}
// метод get получает, post - добавляет
