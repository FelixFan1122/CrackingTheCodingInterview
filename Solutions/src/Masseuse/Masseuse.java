package com.felix.ctci.Masseuse;

import java.util.Stack;

public class Masseuse {
    private Stack<Integer> appointments;

    public Masseuse(Iterable<Integer> appointments) {
        if (appointments == null) {
            throw new IllegalArgumentException();
        }


        this.appointments = new Stack<>();
        for (Integer appointment : appointments) {
            this.appointments.push(appointment);
        }

        if (this.appointments.empty()) {
            throw new IllegalArgumentException();
        }
    }

    public int getMaxMinutes() {
        int maxPreviousTwo = appointments.pop();
        if (appointments.empty()) {
            return maxPreviousTwo;
        }

        int maxPrevious = Math.max(maxPreviousTwo, appointments.pop());
        if (appointments.empty()) {
            return maxPrevious;
        }

        int max = Math.max(appointments.pop() + maxPreviousTwo, maxPrevious);
        int temp;
        while (!appointments.empty()) {
            temp = max;
            max = Math.max(appointments.pop() + maxPreviousTwo, maxPrevious);
            maxPreviousTwo = maxPrevious;
            maxPrevious = temp;
        }

        return max;
    }
}
