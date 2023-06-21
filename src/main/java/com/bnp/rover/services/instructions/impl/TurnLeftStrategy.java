package com.bnp.rover.services.instructions.impl;

import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.InstructionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnLeftStrategy implements InstructionStrategy {

    private static final Map<Character, Consumer<Rover>> TURNING_LEFT_OPERATIONS
            = new HashMap<>();

    static {
        TURNING_LEFT_OPERATIONS.put('N', (rover) -> rover.setDirection('W'));
        TURNING_LEFT_OPERATIONS.put('W', (rover) -> rover.setDirection('S'));
        TURNING_LEFT_OPERATIONS.put('S', (rover) -> rover.setDirection('E'));
        TURNING_LEFT_OPERATIONS.put('E', (rover) -> rover.setDirection('N'));
    }

    @Override
    public void execute(Rover rover) {
        char roverDirection = rover.getDirection();
        Consumer<Rover> turnLeftOperation = TURNING_LEFT_OPERATIONS.get(roverDirection);
        if (turnLeftOperation != null) {
            turnLeftOperation.accept(rover);
        }
    }
}
