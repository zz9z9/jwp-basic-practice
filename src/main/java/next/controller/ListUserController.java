package next.controller;

import core.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Controller listUserController = new ListUserController();

    private ListUserController(){}

    public static Controller getInstance() {
        return listUserController;
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (!UserSessionUtils.isLogined(req.getSession())) {
//            resp.sendRedirect("/users/loginForm");
//            return;
//        }
//
//        req.setAttribute("users", DataBase.findAll());
//
//        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        if(!UserSessionUtils.isLogined(req.getSession())) {
            return "redirect:/users/loginForm";
        }

        req.setAttribute("users", DataBase.findAll());
        return "/user/list.jsp";
    }
}
