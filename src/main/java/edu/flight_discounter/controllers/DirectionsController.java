package edu.flight_discounter.controllers;

import edu.flight_discounter.common.Methods;
import edu.flight_discounter.common.Paths;
import edu.flight_discounter.entities.DirectionEntity;
import edu.flight_discounter.DAO.DirectionsDAO;
import edu.flight_discounter.services.DirectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = Paths.DIRECTIONS)
public class DirectionsController extends AbstractController{
    @Autowired
    DirectionsService directionsService;

    @RequestMapping(value = Methods.GET_DIRECTIONS, method = RequestMethod.GET)
    public final Result<List<DirectionEntity>> getDirections() {
        return run(() -> directionsService.getAllDirections());
    }

    @RequestMapping(value = Methods.GET_DIRECTION, method = RequestMethod.GET)
    public final Result<DirectionEntity> getDirection(@RequestParam(value = "id") final int id) {
        return run(() -> directionsService.getDirectionById(id));
    }
}
