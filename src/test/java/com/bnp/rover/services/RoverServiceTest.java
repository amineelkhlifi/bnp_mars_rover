package com.bnp.rover.services;

import com.bnp.rover.exceptions.PlateauOutOfBoundsException;
import com.bnp.rover.models.Plateau;
import com.bnp.rover.models.Rover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverServiceTest {

    private final RoverService roverService = new RoverService();
    private final Plateau plateau = new Plateau(5, 5);


    @Test
    public void testInitialPosition() {
        Rover rover = new Rover(0, 0, 'N');
        assertEquals("0 0 N", rover.getPosition());
    }

    @Test
    public void testSingleMovement() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, 'N');
        roverService.moveRover(rover, 'M', plateau);
        assertEquals("0 1 N", rover.getPosition());
    }

    @Test
    public void testTurningLeft() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, 'N');

        roverService.moveRover(rover, 'L', plateau);
        assertEquals("0 0 W", rover.getPosition());
    }

    @Test
    public void testTurningRight() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, 'N');

        roverService.moveRover(rover, 'R', plateau);
        assertEquals("0 0 E", rover.getPosition());
    }


    @Test
    public void testMultipleMovements() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(0, 0, 'N');

        roverService.moveRover(rover, 'M', plateau);

        roverService.moveRover(rover, 'R', plateau);

        roverService.moveRover(rover, 'M', plateau);

        assertEquals("1 1 E", rover.getPosition());
    }

    @Test
    public void testDifferentStartingPosition() throws PlateauOutOfBoundsException {
        Rover rover = new Rover(2, 2, 'S');

        roverService.moveRover(rover, 'L', plateau);

        assertEquals("2 2 E", rover.getPosition());

        roverService.moveRover(rover, 'R', plateau);
        assertEquals("2 2 S", rover.getPosition());

        roverService.moveRover(rover, 'M', plateau);
        roverService.moveRover(rover, 'M', plateau);
        roverService.moveRover(rover, 'R', plateau);
        roverService.moveRover(rover, 'M', plateau);
        assertEquals("1 0 W", rover.getPosition());
    }

    @Test
    public void testExceptionWhenOutOfPlateauBounds() throws PlateauOutOfBoundsException {
        Plateau plateau = new Plateau(2, 2);
        Rover rover = new Rover(1, 1, 'N');

        roverService.moveRover(rover, 'M', plateau);
        assertThatThrownBy(() -> roverService.moveRover(rover, 'M', plateau))
                .isInstanceOf(PlateauOutOfBoundsException.class);

    }
}
