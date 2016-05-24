package edu.flight_discounter.services;

import edu.flight_discounter.DAO.UsersDAO;
import edu.flight_discounter.entities.UserEntity;
import edu.flight_discounter.responses.RegistrationResponse;
import edu.flight_discounter.utils.HashUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersDAO usersDAO;

    public UserEntity getUserById(final int id){
        return usersDAO.getUserById(id);
    }

    public List<UserEntity> getAllUsers(){
        return usersDAO.getAllUsers();
    }

    public RegistrationResponse createUser(UserEntity newUser) {
        try {
            newUser.setPassword(HashUtility.SHA1(newUser.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return usersDAO.createUser(newUser);
    }

}
