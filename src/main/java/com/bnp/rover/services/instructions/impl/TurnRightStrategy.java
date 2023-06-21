package com.bnp.rover.services.instructions.impl;

import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.InstructionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnRightStrategy implements InstructionStrategy {
    private static final Map<Character, Consumer<Rover>> TURNING_RIGHT_OPERATIONS
            = new HashMap<>();

    static {
        TURNING_RIGHT_OPERATIONS.put('N', (rover) -> rover.setDirection('E'));
        TURNING_RIGHT_OPERATIONS.put('E', (rover) -> rover.setDirection('S'));
        TURNING_RIGHT_OPERATIONS.put('S', (rover) -> rover.setDirection('W'));
        TURNING_RIGHT_OPERATIONS.put('W', (rover) -> rover.setDirection('N'));
    }

    @Override
    public void execute(Rover rover) {
        char roverDirection = rover.getDirection();
        Consumer<Rover> turnRightOperation = TURNING_RIGHT_OPERATIONS.get(roverDirection);
        if (turnRightOperation != null) {
            turnRightOperation.accept(rover);
        }
    }
}