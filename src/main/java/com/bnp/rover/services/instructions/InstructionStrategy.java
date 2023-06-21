package com.bnp.rover.services.instructions;

import com.bnp.rover.models.Rover;

public interface InstructionStrategy {
    void execute(Rover rover);
}
