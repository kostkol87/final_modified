package edu.flight_discounter.DAO;

import edu.flight_discounter.entities.UserEntity;
import edu.flight_discounter.mappers.UsersMapper;
import edu.flight_discounter.responses.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDAO {

    @Autowired
    private UsersMapper mapper;

    public UserEntity getUserById(int id) {
        return mapper.getUserById(id);
    }

    public List<UserEntity> getAllUsers() {
        return mapper.getAllUser();
    }

    public RegistrationResponse createUser(UserEntity newUser) {
        new RegistrationResponse();
        try {
            mapper.createUser(newUser);
            return new RegistrationResponse();
        } catch (final DuplicateKeyException e) {
            return new RegistrationResponse(newUser.getEmail());
        }
    }
}
