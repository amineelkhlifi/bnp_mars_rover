package com.bnp.rover.services.instructions.impl;

import com.bnp.rover.models.Rover;
import com.bnp.rover.services.instructions.InstructionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MoveForwardStrategy implements InstructionStrategy {
    private static final Map<Character, Consumer<Rover>> MOVE_OPERATIONS = new HashMap<>();

    static {
        MOVE_OPERATIONS.put('N', Rover::incrementY);
        MOVE_OPERATIONS.put('E', Rover::incrementX);
        MOVE_OPERATIONS.put('S', Rover::decrementY);
        MOVE_OPERATIONS.put('W', Rover::decrementX);
    }

    @Override
    public void execute(Rover rover) {
        char direction = rover.getDirection();
        Consumer<Rover> moveOperation = MOVE_OPERATIONS.get(direction);
        if (moveOperation != null) {
            moveOperation.accept(rover);
        }
    }
}
