package edu.flight_discounter.mappers;

import edu.flight_discounter.entities.DirectionEntity;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface DirectionsMapper extends AbstractMapper{

    @Select("SELECT * FROM directions WHERE id = #{id}")
    DirectionEntity getDirection(int id);

    @Select(("SELECT * FROM directions"))
    ArrayList<DirectionEntity> getAllDirections();
}
