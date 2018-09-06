package edu.eci.pdsw;

import edu.eci.pdsw.models.Todo;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        urlPatterns = "/WelcomeServlet"
    )

public class servlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        Writer responseWriter = resp.getWriter();
       
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            if (id <= 0 || id >=200) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                responseWriter.write("No encontrado");
            } else{
                Todo todo = Service.getTodo(id);
                List<Todo> list = new ArrayList<Todo>(); 
                list.add(todo);
                resp.setStatus(HttpServletResponse.SC_OK);
                responseWriter.write("Este es el ID: " + id + "!");
            }
        } catch (MalformedURLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException | NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        responseWriter.flush();
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        Writer responseWriter = resp.getWriter();
        responseWriter.flush();
    }
}
