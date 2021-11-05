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
public interface IRoulette {
    public void uploadroulette();
    public void printRoulette();
    public Topics girar();
    public void agregarPregunta(String string, String pNueva);
    public boolean isEmpty();
    
}
