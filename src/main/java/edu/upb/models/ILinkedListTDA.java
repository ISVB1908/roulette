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
public interface ILinkedListTDA<T> {
    public void add(T element);
    public Node<T> indexFind(int index);
    public void indexDelete(int index);
    public Node<T> findFirst();
    public Node<T> findLast();
    public void deleteFirst();
    public void  deleteLast();
    public void clean();  
    public void print();
}
