package next.controller;

import core.db.DataBase;
import core.web.constants.HttpMethod;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateUserController implements Controller {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);
    private static final Controller createUserController = new CreateUserController();

    private CreateUserController(){}

    public static Controller getInstance() {
        return createUserController;
    }


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/user/form.jsp");
//        rd.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
//                req.getParameter("email"));
//        log.debug("User : {}", user);
//
//        DataBase.addUser(user);
//
//        resp.sendRedirect("/");
//    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(HttpMethod.isGet(req.getMethod())) {
            return "/user/form.jsp";
        }

        if(HttpMethod.isPost(req.getMethod())) {
            User user = new User(req.getParameter("userId"),
                    req.getParameter("password"),
                    req.getParameter("name"),
                    req.getParameter("email"));

            log.debug("User : {}", user);

            DataBase.addUser(user);

            return "redirect:/";
        }

        return "";
    }
}
