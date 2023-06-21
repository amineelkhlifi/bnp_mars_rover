package com.bnp.rover.services.instructions;

import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.impl.TurnRightStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class TurnRightStrategyTest {

    private TurnRightStrategy turnRightStrategy;
    private Rover rover;

    @BeforeEach
    public void setUp() {
        turnRightStrategy = new TurnRightStrategy();
        rover = mock(Rover.class);
    }

    @Test
    public void testExecute_WithNorthDirection_TurnLeftOperationCalled() {
        when(rover.getDirection()).thenReturn('N');
        turnRightStrategy.execute(rover);
        verify(rover).setDirection('E');
    }

    @Test
    public void testExecute_WithWestDirection_TurnLeftOperationCalled() {
        when(rover.getDirection()).thenReturn('W');
        turnRightStrategy.execute(rover);
        verify(rover).setDirection('N');
    }

    @Test
    public void testExecute_WithSouthDirection_TurnLeftOperationCalled() {
        when(rover.getDirection()).thenReturn('S');
        turnRightStrategy.execute(rover);
        verify(rover).setDirection('W');
    }

    @Test
    public void testExecute_WithEastDirection_TurnLeftOperationCalled() {
        when(rover.getDirection()).thenReturn('E');
        turnRightStrategy.execute(rover);
        verify(rover).setDirection('S');
    }

    @Test
    public void testExecute_WithInvalidDirection_NoTurnLeftOperationCalled() {
        when(rover.getDirection()).thenReturn('Z');
        turnRightStrategy.execute(rover);
        verify(rover, never()).setDirection(anyChar());
    }

}
