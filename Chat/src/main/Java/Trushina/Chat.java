package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Chat extends HttpServlet {
    private BufferedReader br;
    private BufferedWriter bw;
    Writer webWriter;
    String pathToHistory = "../../../../../../../resources/history.txt";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            webWriter = response.getWriter();

            readFileWriteInBrowser(webWriter,"../../../../../../../IdeaWorkspace/Chat/src/main/webapp/HTML/ChatHTML1.html");
            readFileWriteInBrowser(webWriter,pathToHistory);
            readFileWriteInBrowser(webWriter,"../../../../../../../IdeaWorkspace/Chat/src/main/webapp/HTML/ChatHTML2.html");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {// принимает от пользователя новую строку, добавляет в кооллекциюю, возвращает новую коллекцию
        if (request != null) {
            String message = request.getParameter("message");
                addHistory(message, pathToHistory);
        }
        doGet(request, response);
    }

    private void writeLine(HttpServletResponse response, String message) throws IOException {
        message += "<br>";
        response.getWriter().write(message, 0, message.length());
    }

    private void readFileWriteInBrowser(Writer writer, String pathToFile)throws IOException {
        String mess;
        br = new BufferedReader((new FileReader(pathToFile)));
        if (pathToFile.endsWith(".txt")) {
            while ((mess = br.readLine()) != null) {
                webWriter.write(mess + "</br>");
            }
        } else {
            while ((mess=br.readLine())!= null){
                webWriter.write(mess, 0, mess.length());
            }
        }
    }

    private void addHistory(String message, String pathToHistory) throws IOException {
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
