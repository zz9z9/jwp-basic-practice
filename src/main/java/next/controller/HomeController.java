package next.controller;

import core.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("")
public class HomeController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Controller homeController = new HomeController();

    private HomeController(){}

    public static Controller getInstance() {
        return homeController;
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("users", DataBase.findAll());
//        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)  {
        req.setAttribute("users", DataBase.findAll());
        return "index.jsp";
    }
}
