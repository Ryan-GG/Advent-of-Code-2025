package com.advent.code;

public record Id(long value) {
    /**
     * @return if no substring of {@code value} repeats itself immediately
     */
    public boolean isValid() {
        String s = Long.toString(value);
        return !s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2));
    }

    public boolean isValidPartTwo() {
        String s = Long.toString(value);
        int len = s.length();

        for (int windowSize = 1; windowSize <= len / 2; windowSize++) {
            if (len % windowSize != 0) continue;
            String pattern = s.substring(0, windowSize);
            boolean repeatedFully = true;
            for (int windowIndex = 1; windowIndex < len / windowSize; windowIndex++) {
                String window = s.substring(windowIndex * windowSize, (windowIndex * windowSize) + windowSize);
                if (!pattern.equals(window)) {
                    repeatedFully = false;
                    break;
                }
            }

            if (repeatedFully) {
                return false;
            }
        }
        return true;
    }
}
