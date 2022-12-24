package my.pack;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class EnterAcount extends HttpServlet {
    List<Acount> list = new ArrayList<>(List.of(
            new Acount("111" , "111", "Alexandro"),
            new Acount("222", "222", "Petro"),
            new Acount("333" , "333", "Makaroni")));

    @Override
    protected void doGet(HttpServletRequest req,
                          HttpServletResponse resp) throws IOException{
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<link rel=\"stylesheet\" href=\"style.css\">");
        out.println("<body>");
        out.println("<table borfer=\"1\">");
        out.println("<tr><th>Login</th><th>Name</th></tr>");
        for (Acount element : list) {
                out.print("<tr> <td>" + element.getLogin() + "</td><td>" + element.getName() + "</td></tr>");
        }
        out.println("<input type=\"hidden\" value=\"${goodLog == true?false:true}\" name=\"action\">");
        out.println("</table>");
        out.println("<input type=\"submit\" class=\"button\" value=\"Logout\" name=\"enter1\" onclick=\"location.href='http://localhost:8086/JavaTask4_war_exploded/'\"/>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp) throws IOException, ServletException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean trueInfo = false;

        for(Acount element : list) {
            if(login.equals(element.getLogin()) && password.equals(element.getPassword())){
                trueInfo = true;
            }
        }

        if(trueInfo){
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }else{
            req.setAttribute("execut", "Bad login or password");

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

}

