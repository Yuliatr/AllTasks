package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by st032619 on 08.04.2016.
 */
public class MyFirstServletDemo extends HttpServlet {

    private int initCount = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String s = "Hello, World! " + initCount;
            response.getWriter().write(s, 0, s.length() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        initCount++;
    }
}
