/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upb.edu.slist;

import edu.upb.models.IList;
import edu.upb.models.Node;

/**
 *
 * @author vasqu
 */
public class SimpleList<T> implements IList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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
    @Override
    public void add(T element) {
        Node<T> n = new Node<T>(element);
        size++;
        if(first==null){
        
            first=n;
            last=first;
        }else{
        
            last.setNext(n);
            last=last.getNext();
        }
    }

    @Override
    public void clear() {
        first=null;
    }

    @Override
    public T find(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int index) {
        Node<T> current=getFirst();
        //initialize counter
        int count=0;
        if(index>=getSize()||index<0){
        
            System.out.println("index doesn't exist");
        }
        //check if the list have some element
        else if (index==0&&current!=null){
        
            this.first=current.getNext();
            current=null;
        }else {
        
            //porque cono un do while
            //count until one less to the index
            while(count<index-1){
                    current=current.getNext();
                    count++;   
            }
            //System.out.println("actual:"+current.getValue());
            //change the nex for remove one
            current.setNext(current.getNext().getNext());
            size--;
        }
    }

    public void print(){
        //initialize current 
        Node current=getFirst();
        int count=0;
        //go  trough the list until current is null
        while(current!=null){
            
            System.out.println(current.getValue());
            current=current.getNext();
            
        }
        
    }
    public boolean removeLast(){
        
        
        Node current=getFirst();
        last.setValue(null);
        if(current.getValue()==null){
            return true;
        }
        //go  trough the list until current is null
        while(current.getNext().getValue()!=null){
            
            current=current.getNext();
            
        }
        //System.out.println(current.getValue());
        last=current;
        return false;
        
    }
    
}
