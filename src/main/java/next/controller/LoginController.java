package next.controller;

import core.db.DataBase;
import core.web.constants.HttpMethod;
import next.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Controller loginController = new LoginController();

    private LoginController(){}

    public static Controller getInstance() {
        return loginController;
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        forward("/user/login.jsp", req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        String password = req.getParameter("password");
//        User user = DataBase.findUserById(userId);
//        if (user == null) {
//            req.setAttribute("loginFailed", true);
//            forward("/user/login.jsp", req, resp);
//            return;
//        }
//
//        if (user.matchPassword(password)) {
//            HttpSession session = req.getSession();
//            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
//            resp.sendRedirect("/");
//        } else {
//            req.setAttribute("loginFailed", true);
//            forward("/user/login.jsp", req, resp);
//        }
//    }

//    private void forward(String forwardUrl, HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher(forwardUrl);
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(HttpMethod.isGet(req.getMethod())) {
            return "/user/login.jsp";
        }

        if(HttpMethod.isPost(req.getMethod())) {
            String userId = req.getParameter("userId");
            String password = req.getParameter("password");
            User user = DataBase.findUserById(userId);

            if (user == null) {
                req.setAttribute("loginFailed", true);
                return "/user/login.jsp";
            }

            if (user.matchPassword(password)) {
                HttpSession session = req.getSession();
                session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
                return "redirect:/";
            }

            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }

        return "";
    }
}
