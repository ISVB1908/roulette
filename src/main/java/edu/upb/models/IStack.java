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
public interface IStack<T> {
    public void push(T element);
    public Node<T> pop();
    public Node<T> peek();
    public int size();
    public boolean isEmpty();
    public void clear();
    public void print();
}
