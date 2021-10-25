/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.stack;

import edu.upb.models.IStack;
import edu.upb.models.MyException;
import edu.upb.models.Node;

/**
 *
 * @author vasqu
 * @param <T>
 */
public class Stack<T>  implements IStack<T>{
    //atributtes
    private Node<T> top;
    //getters and setters

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    //interface
    @Override
    public void push(T element) {
        top = new Node<T> (top,element);
    }

    @Override
    public Node<T> pop() {
        if (top == null) {
            throw new MyException("Cannot pop from empty stack");
        }

        Object item = peek();
        top = top.getNext();
        return (Node<T>) item;    }

    @Override
    public Node<T> peek() {
       
        if (top == null) {
            throw new MyException("Cannot peek from empty stack");
        }
        return (Node<T>) top.getValue();    }

    @Override
    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.getNext()) {
            count++;
        }
        return count;    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        
        
    }
    
}
