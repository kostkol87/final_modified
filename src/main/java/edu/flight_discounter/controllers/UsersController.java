package edu.flight_discounter.controllers;

import edu.flight_discounter.common.Methods;
import edu.flight_discounter.common.Paths;
import edu.flight_discounter.entities.UserEntity;
import edu.flight_discounter.responses.RegistrationResponse;
import edu.flight_discounter.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = Paths.USERS)
public class UsersController extends AbstractController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = Methods.GET_USER, method = RequestMethod.GET)
    public final Result<UserEntity> getUserById(@RequestParam(value = "id") final int id) {
        return run(() -> usersService.getUserById(id));
    }

    @RequestMapping(value = Methods.CREATE_USER, method = RequestMethod.POST)
    public final Result<RegistrationResponse> createUser(@RequestBody final UserEntity user, HttpServletResponse response) {
        Result<RegistrationResponse> result = run(() -> usersService.createUser(user));
        final Cookie cookie = (result.payload.isRegistered ? new Cookie("registration", "true") : new Cookie("registration", "false"));
        cookie.setPath("/");
        response.addCookie(cookie);
        return result;
    }

    @RequestMapping(value = Methods.GET_ALL_USER, method = RequestMethod.GET)
    public final Result<List<UserEntity>> getAllUsers() {
        return run(() -> usersService.getAllUsers());
    }
}
