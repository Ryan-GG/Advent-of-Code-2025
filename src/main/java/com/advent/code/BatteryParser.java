package com.advent.code;

import java.util.Arrays;
import java.util.List;

public class BatteryParser {

    public static List<BatteryBank> parse(String input) {
        return Arrays.stream(input.split("\n")).map(BatteryBank::new).toList();
    }
}
