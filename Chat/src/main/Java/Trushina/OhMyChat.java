package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class OhMyChat extends HttpServlet {
    private int initCount = 0;



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String hi = "Hello, World! " + initCount;
            System.out.println(hi);
            String s;

            String filePath = getServletContext().getRealPath("resources/ChatHTML");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "utf-8"));

//          BufferedReader br = new BufferedReader((new FileReader("G:/Chat/src/main/resources/ChatHTML.html")));
            while((s = br.readLine())!=null){
                response.getWriter().write(s, 0, s.length() );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        initCount++;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {// принимает от пользователя новую строку, добавляет в кооллекциюю, возвращает новую коллекцию
    }
}