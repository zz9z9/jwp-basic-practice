package core.request;

import next.controller.Controller;
import next.controller.CreateUserController;
import next.controller.HomeController;
import next.controller.ListUserController;
import next.controller.LoginController;
import next.controller.LogoutController;
import next.controller.ProfileController;
import next.controller.UpdateUserController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RequestMapping {
    private static Map<String, Controller> requestMapper = new HashMap<>();

    public RequestMapping() {
        requestMapper.put("/users/create", CreateUserController.getInstance());
        requestMapper.put("/users/form", CreateUserController.getInstance());
        requestMapper.put("", HomeController.getInstance());
        requestMapper.put("/users", ListUserController.getInstance());
        requestMapper.put("/users/login", LoginController.getInstance());
        requestMapper.put("/users/loginForm", LoginController.getInstance());
        requestMapper.put("/users/logout", LogoutController.getInstance());
        requestMapper.put("/users/profile", ProfileController.getInstance());
        requestMapper.put("/users/update", UpdateUserController.getInstance());
        requestMapper.put("/users/updateForm", UpdateUserController.getInstance());
    }

    public Controller getControllerByUrl(String url) {
        // TODO : 없는 경우 처리를 어떻게 해야할까 ?? (일단은 HomeController로함)
        return Optional.ofNullable(requestMapper.get(url)).orElseGet(() -> HomeController.getInstance());
    }
}
