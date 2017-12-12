package com.felix.ctci.QueueViaStack;

import java.util.Stack;

public class MyQueue<E> {
    private final Stack<E> forwardStack = new Stack<>();
    private final Stack<E> backwardStack = new Stack<>();

    public E Dequeue() {
        while (!forwardStack.empty()) {
            backwardStack.push(forwardStack.pop());
        }

        return backwardStack.pop();
    }

    public void Enqueue(E element) {
        while (!backwardStack.empty()) {
            forwardStack.push(backwardStack.pop());
        }

        forwardStack.push(element);
    }
}
