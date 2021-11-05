/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.models;

/**
 *
 * @author vasqu
 * @param <T>
 */
public class Node <T>{
    //atrubutes
    private Node<T> next;
    private Node<T> previus;
    private T value;
    
    //constructor
    public Node(T value) {
        this.value = value;
    }

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }


    //getters and setters
    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevius() {
        return previus;
    }

    public void setPrevius(Node<T> previus) {
        this.previus = previus;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
}

