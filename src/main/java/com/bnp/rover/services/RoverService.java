package com.bnp.rover.services;

import com.bnp.rover.exceptions.PlateauOutOfBoundsException;
import com.bnp.rover.models.Plateau;
import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.InstructionStrategy;
import com.bnp.rover.services.instructions.InstructionsFactory;

public class RoverService {

    private final PlateauService plateauService = new PlateauService();


    public void moveRover(Rover rover, char instruction, Plateau plateau) throws PlateauOutOfBoundsException {
        InstructionStrategy strategy = InstructionsFactory.getMovementStrategy(instruction);
        if (strategy != null) {
            strategy.execute(rover);
        }
        if(plateauService.isRoverOutPlateauBounds(plateau, rover)){
            throw new PlateauOutOfBoundsException("Rover out of bounds");
        }
    }

}
