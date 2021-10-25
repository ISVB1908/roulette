package edu.upb.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * A small queue interface. You can query the size of the queue and ask whether
 * it is empty, add and remove items, and peek at the front item.
 */
public interface IQueue {

    /**
     * Adds the given item to the rear of the queue.
     * @param item
     */
    void enqueue(Object item);

    /**
     * Removes the front item from the queue and returns it.
     * 
     * @return 
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    Object dequeue();

    /**
     * Returns the front item from the queue without popping it.
     * 
     * @return 
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    Object peek();

    /**
     * Returns the number of items currently in the queue.
     * @return 
     */
    int size();

    /**
     * Returns whether the queue is empty or not.
     * @return 
     */
    boolean isEmpty();
}