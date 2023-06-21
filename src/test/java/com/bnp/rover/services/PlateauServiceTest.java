package com.bnp.rover.services;

import com.bnp.rover.models.Plateau;
import com.bnp.rover.models.Rover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlateauServiceTest {


    private PlateauService plateauService = new PlateauService();
    @Test
    public void testWithinBounds() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(0,0,'N');
        Rover rover2 = new Rover(2,3,'N');
        Rover rover3 = new Rover(5,5,'N');

        assertTrue(plateauService.isRoverWithinPlateauBounds(plateau, rover1));
        assertTrue(plateauService.isRoverWithinPlateauBounds(plateau, rover2));
        assertTrue(plateauService.isRoverWithinPlateauBounds(plateau, rover3));
    }

    @Test
    public void testOnBoundaries() {

        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(0,5,'N');
        Rover rover2 = new Rover(5,0,'N');

        assertTrue(plateauService.isRoverWithinPlateauBounds(plateau, rover1));
        assertTrue(plateauService.isRoverWithinPlateauBounds(plateau, rover2));
    }

    @Test
    public void testOutsideBounds() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(-1,3,'N');
        Rover rover2 = new Rover(2, -1,'N');
        Rover rover3 = new Rover(6, 3,'N');
        Rover rover4 = new Rover(2, 6,'N');

        assertFalse(plateauService.isRoverWithinPlateauBounds(plateau, rover1));
        assertFalse(plateauService.isRoverWithinPlateauBounds(plateau, rover2));
        assertFalse(plateauService.isRoverWithinPlateauBounds(plateau, rover3));
        assertFalse(plateauService.isRoverWithinPlateauBounds(plateau, rover4));
    }
}
