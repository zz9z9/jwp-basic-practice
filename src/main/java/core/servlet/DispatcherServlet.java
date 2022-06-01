package core.servlet;

import core.request.RequestMapping;
import next.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private final static RequestMapping rm = new RequestMapping();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        Controller controller = rm.getControllerByUrl(url);
        String result = controller.execute(req, resp);

        if(result.contains("redirect:")) {
            String redirectPage = result.substring(result.indexOf(":"));
            resp.sendRedirect(redirectPage);
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher(result);
        rd.forward(req, resp);
    }
}
