/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.models;

/**
 *
 * @author vasqu
 */
public interface IList<T> {
    //condiciones
    public void add(T elemet);
    public void clear();
    public T find(int index);
    public void remove(int index);
}
