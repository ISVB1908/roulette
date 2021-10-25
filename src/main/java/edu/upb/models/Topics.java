/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.models;

import edu.upb.stack.Stack;
import upb.edu.slist.SimpleList;

/**
 *
 * @author vasqu
 */
public class Topics {
    private String topic;
    private SimpleList structure;

    public Topics(String topic) {
        this.topic = topic;
        structure = new SimpleList<String>();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public SimpleList getStructure() {
        return structure;
    }

    public void setStructure(SimpleList structure) {
        this.structure = structure;
    }
    public QyA seleccionarPregunta(){
        QyA respuesta =(QyA) structure.getLast().getValue();
        structure.removeLast();

        return respuesta;
    }
   
}

