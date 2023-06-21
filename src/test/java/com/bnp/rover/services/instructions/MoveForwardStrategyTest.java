package com.bnp.rover.services.instructions;

import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.impl.MoveForwardStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MoveForwardStrategyTest {
    private MoveForwardStrategy moveForwardStrategy;
    private Rover rover;

    @BeforeEach
    public void setUp() {
        moveForwardStrategy = new MoveForwardStrategy();
        rover = mock(Rover.class);
    }

    @Test
    public void testExecute_WithNorthDirection_MoveOperationCalled() {
        when(rover.getDirection()).thenReturn('N');
        moveForwardStrategy.execute(rover);
        verify(rover).incrementY();
    }

    @Test
    public void testExecute_WithEastDirection_MoveOperationCalled() {
        when(rover.getDirection()).thenReturn('E');
        moveForwardStrategy.execute(rover);
        verify(rover).incrementX();
    }

    @Test
    public void testExecute_WithSouthDirection_MoveOperationCalled() {
        when(rover.getDirection()).thenReturn('S');
        moveForwardStrategy.execute(rover);
        verify(rover).decrementY();
    }

    @Test
    public void testExecute_WithWestDirection_MoveOperationCalled() {
        when(rover.getDirection()).thenReturn('W');
        moveForwardStrategy.execute(rover);
        verify(rover).decrementX();
    }

    @Test
    public void testExecute_WithInvalidDirection_NoMoveOperationCalled() {
        when(rover.getDirection()).thenReturn('Z');
        moveForwardStrategy.execute(rover);
        verify(rover, never()).incrementY();
        verify(rover, never()).incrementX();
        verify(rover, never()).decrementY();
        verify(rover, never()).decrementX();
    }


}
