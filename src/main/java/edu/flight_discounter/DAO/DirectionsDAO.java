package edu.flight_discounter.DAO;

import edu.flight_discounter.entities.DirectionEntity;
import edu.flight_discounter.mappers.DirectionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DirectionsDAO {

    @Autowired
    private DirectionsMapper mapper;

    public DirectionEntity getDirectionById(int id){
        return mapper.getDirection(id);
    }

    public ArrayList<DirectionEntity> getAllDirections(){
        return mapper.getAllDirections();
    }
}
