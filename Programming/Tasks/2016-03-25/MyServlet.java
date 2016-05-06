import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {

    private int initCount = 0;

    @Override
    public void doGet(HttpServletRequest reques, HttpServletResponse response) {
        try {
            response.getWriter().write("Hello, World!"  + initCount );
        } catch (IOException e) {
            e.printStackTrace();
        }
        initCount++;
    }
}


//Задачка:
