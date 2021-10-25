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
public interface ICircularDouble<T> {
    public void add(T element);
    public void deleteIndex(int index);
    public Node<T> findIndex(int Index);
    public void deleteElemt(T element);
    public Node<T> findElement(T element);
    public void print();
    public void clear();
}
