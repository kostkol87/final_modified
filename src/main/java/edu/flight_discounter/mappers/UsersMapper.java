package edu.flight_discounter.mappers;

import edu.flight_discounter.entities.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper extends AbstractMapper{

    @Select("SELECT * FROM user WHERE id = #{id}")
    UserEntity getUserById(int id);

    @Select("SELECT * FROM user")
    List<UserEntity> getAllUser();

    @Insert("INSERT INTO user (`email`, `password`, `name`, `surname`) " +
            "VALUES (#{email}, #{password}, #{name}, #{surname})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void createUser(UserEntity user);
}
