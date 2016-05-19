package edu.flight_discounter.services;

import edu.flight_discounter.DAO.DirectionsDAO;
import edu.flight_discounter.entities.DirectionEntity;

public class Test {

    public static void main(String[] args)  {
        DirectionsDAO ds = new DirectionsDAO();
        System.out.println(ds.getDirectionById(2));

        for (DirectionEntity e :
                ds.getAllDirections()) {
            System.out.println(e);
        }
    }
}
