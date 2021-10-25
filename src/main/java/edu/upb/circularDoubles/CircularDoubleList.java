/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.circularDoubles;

import edu.upb.models.ICircularDouble;
import edu.upb.models.Node;

/**
 *
 * @author vasqu
 * @param <T>
 */
public class CircularDoubleList<T> implements ICircularDouble<T>{

    //atributes
    Node<T> first;
    Node<T> last;
    
    //getters and setter

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }
    
    
    //Interface
    @Override
    public void add(T element) {
        Node<T> item = new Node<T> (element);
        if(first==null){
        
            first=item;
            last=first;
            first.setPrevius(last);
        }else{
        
           last.setNext(item);
           item.setPrevius(last);
           last=item;
           last.setNext(first);
           first.setPrevius(last);
        }
    }

    @Override
    public void deleteIndex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node<T> findIndex(int Index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteElemt(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node<T> findElement(T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        Node current=getFirst();
        while(current.getNext()!=first){
            
                System.out.println(current.getValue());
                current=current.getNext();}
        System.out.println(last.getValue());
    }

    @Override
    public void clear() {
        first=null;
    }

    
}
