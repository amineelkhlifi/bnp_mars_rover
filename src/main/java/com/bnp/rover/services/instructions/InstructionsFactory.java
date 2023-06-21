package com.bnp.rover.services.instructions;

import com.bnp.rover.services.instructions.impl.MoveForwardStrategy;
import com.bnp.rover.services.instructions.impl.TurnLeftStrategy;
import com.bnp.rover.services.instructions.impl.TurnRightStrategy;

import java.util.HashMap;
import java.util.Map;

public class InstructionsFactory {

    private static final Map<Character, InstructionStrategy> INSTRUCTION_STRATEGIES = new HashMap<>();


    static {
        INSTRUCTION_STRATEGIES.put('L', new TurnLeftStrategy());
        INSTRUCTION_STRATEGIES.put('R', new TurnRightStrategy());
        INSTRUCTION_STRATEGIES.put('M', new MoveForwardStrategy());
    }

    public static InstructionStrategy getMovementStrategy(char instruction) {
        return INSTRUCTION_STRATEGIES.get(instruction);
    }
}
