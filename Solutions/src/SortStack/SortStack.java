package com.felix.ctci.SortStack;

import java.util.Stack;

public class SortStack {
    public static <E extends Comparable<E>> void sort(Stack<E> stack) {
        if (stack == null) {
            throw new IllegalArgumentException();
        }

        if (stack.size() < 2) {
            return;
        }

        Stack<E> temporaryStack = new Stack<>();
        temporaryStack.push(stack.pop());
        E temporaryElement;
        while (!stack.empty()) {
            if (stack.peek().compareTo(temporaryStack.peek()) >= 0) {
                temporaryStack.push(stack.pop());
            } else {
                temporaryElement = stack.pop();
                while (!temporaryStack.empty() && temporaryStack.peek().compareTo(temporaryElement) > 0) {
                    stack.push(temporaryStack.pop());
                }

                temporaryStack.push(temporaryElement);
            }
        }

        while (!temporaryStack.empty()) {
            stack.push(temporaryStack.pop());
        }
    }
}
