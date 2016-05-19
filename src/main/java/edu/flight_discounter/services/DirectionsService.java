package edu.flight_discounter.services;

import edu.flight_discounter.DAO.DirectionsDAO;
import edu.flight_discounter.entities.DirectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionsService {
    @Autowired
    DirectionsDAO directionsDAO;

    public final List<DirectionEntity> getAllDirections(){
        return directionsDAO.getAllDirections();
    }

    public final DirectionEntity getDirectionById(final int id){
        return directionsDAO.getDirectionById(id);
    }
}
