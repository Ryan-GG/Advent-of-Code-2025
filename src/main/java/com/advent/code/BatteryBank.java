package com.advent.code;

public record BatteryBank(String value) {

    /**
     * @return Max joltage value of a bank, which is the large value produced
     * by any two characters in {@code value} that index of 10th's place value < index 1's place value
     */
    public int getMaxJoltage() {
        //O(n) scan left to right find max the second max place
        //edge case, if first max place is found at end, can't do that

        int firstIndex = 0;


        for (int i = 0; i < value.length() - 1; i++) {
            int val = value.charAt(i) - '0';
            if (value.charAt(firstIndex) - '0' < val) {
                firstIndex = i;
                if (val == 9) break;
            }
        }

        int secondIndex = firstIndex + 1;

        for (int i = firstIndex + 1; i < value.length(); i++) {
            int val = value.charAt(i) - '0';
            if (value.charAt(secondIndex) - '0' < val) {
                secondIndex = i;
            }
        }

        int tensPlace = (value.charAt(firstIndex) - '0') * 10;
        int firstPlace = value.charAt(secondIndex) - '0';

        return tensPlace + firstPlace;
    }
}
