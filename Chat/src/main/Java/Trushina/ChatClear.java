package Trushina;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatClear extends HttpServlet{
    private int initCount = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().write("HELlllOOOOOOOOOOOOOO");
            String s = "Hello, World! " + initCount;
            response.getWriter().write(s, 0, s.length() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        initCount++;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {// принимает от пользователя новую строку, добавляет в кооллекциюю, возвращает новую коллекцию
    }
}
//напсиать чат, но просто пишем класс, который позволит при обращении к нему выводит все сообщения, которые о  этого были ему отправлены
//
// каким образом сообщзения отправляеются
//про маппинг: онуказывается относительно директории проекта
//принимаем от пользователей строки и выводим о, что было ужевыведено до этого
// с помощью

//всеп пользователь будет подключиться к пом браузеру, подключать сервлет


//когда пользователь получит, на страничке надо сделать

//пишем форму, у нее будет обработчик - сервлет, пишем его адрес


/*
ШАБЛОНИЩЕ
public class Chat extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) { //возвращает список всего,что надо


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {// принимает от пользователя новую строку, добавляет в кооллекциюю, возвращает новую коллекцию


    }
}
 */



/*response.getWriter().write( И ПИШЕМ ТУТ ТО, ЧТО ЧИТАЕТ БРАУЗЕР: СТРОКУ ИЛИ HTML)
можно в каталоге resources создать файлик html, там все будет подсвечиваться, потом
c помощью BufferedReader прочитать его , то есть поставить в скобках в каестве параметар
*/



//ЗАПУСКАТЬ В БРАУЗЕРЕ: http://localhost:8080/Chat/
//пусть к jdk в классе: C:\Program Files\Java\jdk1.8.0_74
//пусть дома: C:\Program Files (x86)\Java\jdk1.8.0_73