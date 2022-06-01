package next.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Controller logoutController = new LogoutController();

    private LogoutController(){}

    public static Controller getInstance() {
        return logoutController;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);

        return "redirect:/";
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
//        resp.sendRedirect("/");
//    }
}
