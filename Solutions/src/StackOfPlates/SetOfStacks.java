package com.felix.ctci.StackOfPlates;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<E> {
    private int capacity;
    private int stackIndex;
    private ArrayList<Stack<E>> stacks;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        stackIndex = 0;
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }

    public void Push(E element) {
        if (stacks.get(stackIndex).size() == capacity) {
            stacks.add(new Stack<>());
            stackIndex++;
        }

        stacks.get(stackIndex).push(element);
    }

    public E Pop() {
        E element = stacks.get(stackIndex).pop();
        if (stacks.get(stackIndex).empty()) {
            stackIndex--;
            // TODO: Devise a strategy to destroy empty stacks.
        }

        return element;
    }

    public E PopAt(int index) {
        return stacks.get(index).pop();
    }
}
