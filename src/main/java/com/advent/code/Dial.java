package com.advent.code;

public class Dial {

    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 99;
    private int position = 50;

    public int getPosition() {
        return position;
    }

    private void setPosition(int position) {
        this.position = position;
    }

    /**
     * @param amount -/+
     *               Moves position between bounds of [0,99]
     */
    public int rotate(int amount) {
        if (amount == 0) return position;
        return amount < 0 ? rotateLeft(amount) : rotateRight(amount);
    }

    private int rotateRight(int amount) {
        amount = Math.abs(amount);
        while (0 < amount) {
            if (position + 1 > MAX_VALUE) {
                setPosition(MIN_VALUE);
            } else {
                setPosition(position + 1);
            }
            amount--;
        }
        return getPosition();
    }

    private int rotateLeft(int amount) {
        amount = Math.abs(amount);
        while (0 < amount) {
            if (position - 1 < MIN_VALUE) {
                setPosition(MAX_VALUE);
            } else {
                setPosition(position - 1);
            }
            amount--;
        }
        return getPosition();
    }
}
