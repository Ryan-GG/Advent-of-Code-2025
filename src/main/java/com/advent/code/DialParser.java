package com.advent.code;

import java.util.Arrays;
import java.util.List;

public class DialParser {

    public static List<Integer> parseDialInstructions(String instructions) {
        return Arrays.stream(instructions.split("\n"))
                .map(DialParser::parseDialInstruction)
                .toList();
    }

    private static Integer parseDialInstruction(String instruction) {
        char rotation = instruction.charAt(0);
        int rotationAmount = Integer.parseInt(instruction.substring(1));
        return rotation == 'L' ? -rotationAmount : rotationAmount;
    }
}
