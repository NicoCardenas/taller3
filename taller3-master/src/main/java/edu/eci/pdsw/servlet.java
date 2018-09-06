package edu.eci.pdsw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.pdsw.models.Todo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
    urlPatterns = "/WelcomeServlet"
)

public class servlet extends HttpServlet{
    private static final long serialVersionUID = 36L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
        String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
        
        List<Todo> todos = Service.getTodos();
        
        resp.setStatus(HttpServletResponse.SC_OK);
        // responseWriter.write(todo.toString());
        responseWriter.write(todos);
        responseWriter.flush();
                        
        service.getTodos();
        resp.setStatus(HttpServletResponse.SC_OK);
        responseWriter.write("Hello" + id + "!");
        responseWriter.flush();
    }     
}
