package next.controller;

import core.db.DataBase;
import next.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/users/profile")
public class ProfileController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Controller profileController = new ProfileController();

    private ProfileController(){}

    public static Controller getInstance() {
        return profileController;
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        User user = DataBase.findUserById(userId);
//        if (user == null) {
//            throw new NullPointerException("사용자를 찾을 수 없습니다.");
//        }
//        req.setAttribute("user", user);
//        RequestDispatcher rd = req.getRequestDispatcher("/user/profile.jsp");
//        rd.forward(req, resp);
//    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User user = DataBase.findUserById(userId);

        if (user == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }
        req.setAttribute("user", user);

        return "/user/profile.jsp";
    }
}
