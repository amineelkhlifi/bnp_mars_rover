package com.bnp.rover.services;

import com.bnp.rover.models.Plateau;
import com.bnp.rover.models.Rover;

public class PlateauService {

    public boolean isRoverWithinPlateauBounds(Plateau plateau, Rover rover) {
        return rover.getX() >= 0 &&
                rover.getX() <= plateau.getX()
                && rover.getY() >= 0 && rover.getY() <= plateau.getY();
    }

    public boolean isRoverOutPlateauBounds(Plateau plateau, Rover rover){
        return !isRoverWithinPlateauBounds(plateau, rover);
    }
}
