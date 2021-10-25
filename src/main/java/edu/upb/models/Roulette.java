/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.models;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import edu.upb.circularDoubles.CircularDoubleList;
import edu.upb.stack.Stack;
import upb.edu.slist.SimpleList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vasqu
 */
public class Roulette {

    CircularDoubleList roulette;
    private int puntuacion;
    
   
    public Roulette() {
        roulette = new CircularDoubleList<Topics>();
        puntuacion=0;    
    }

    public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public CircularDoubleList getRoulette() {
        return roulette;
    }

    public void setRoulette(CircularDoubleList roulette) {
        this.roulette = roulette;
    }
    public void uploadroulette(){
    
        try {
            String archCSV = "src/main/java/edu/upb/data/data.csv";
            CSVReader csvReader;
            csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while((fila = csvReader.readNext()) != null) {
               
            	Topics topic = new Topics(fila[0]);
                String [] opc1= fila[1].split("/");
     
                QyA pregunta1 = new QyA(opc1[0],opc1[1],opc1[2],opc1[3]);
                
                
                String [] opc2= fila[2].split("/");
                QyA pregunta2 = new QyA(opc2[0],opc2[1],opc2[2],opc2[3]);
                
                String [] opc3= fila[3].split("/");
                QyA pregunta3 = new QyA(opc3[0],opc3[1],opc3[2],opc3[3]);
               
              
                topic.getStructure().add(pregunta1);
                //System.out.println(fila[1]);
                topic.getStructure().add(pregunta2);
                topic.getStructure().add(pregunta3);
                roulette.add(topic);
               
                
            }
            csvReader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Roulette.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Roulette.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(Roulette.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void printRoulette() {
        
        Node current=roulette.getFirst();
        
        while(current.getNext()!=roulette.getFirst()){
            
            Topics temp=(Topics) current.getValue();
                System.out.println(temp.getTopic());
                
                temp.getStructure().print();
                current=current.getNext();
        }
        Topics ultimo=(Topics)roulette.getLast().getValue();
        System.out.println(ultimo.getTopic());
        ultimo.getStructure().print();
        
    }
    public Topics girar(){
        int random =(int) ((Math.random() * (20 - 1)) + 1);
        int count=0;
        Node current=roulette.getFirst();
        while(count<random){
       
            current=current.getNext();
            count++;
        }
        Topics temp=(Topics) current.getValue();
        //System.out.println(temp.getTopic());
       
        return (Topics)current.getValue();   
    }
    
        
    

	public void  agregarPregunta(String string, String pNueva) {
		
		String [] opc1= pNueva.split("/");

	    
		QyA preg = new QyA(opc1[0],opc1[1], opc1[2], opc1[3]);

        Node current = roulette.getFirst();
        while(current.getNext()!=null){
        
            Topics temp =(Topics) current.getValue();
            
          
            if(temp.getTopic().equals(string)){
         
                temp.getStructure().add(preg);
               System.out.println(temp.getTopic());
                return;
            }
     
            current=current.getNext();
        }
		
		
	}
	public boolean searchProof(String proof) {
		Node current = roulette.getFirst();
		int stop=0;
        while(current.getNext()!=null && stop<=5){
        
            Topics temp =(Topics) current.getValue();
            
          
            if(temp.getTopic().equals(proof)){
         
               
                return true;
            }
     
            current=current.getNext();
            stop++;
        }
		return false;
		
		
	}
	public Topics serch() {
		Node current = roulette.getFirst();
		int stop=0;
        while(current.getNext()!=null && stop<6){
        
            Topics temp =(Topics) current.getValue();

            SimpleList list =temp.getStructure();
            QyA value =(QyA) list.getLast().getValue();
            if(value==null) {
            	
            	current=current.getNext();
            	stop++;
            	
            }else {
            	
            	return temp;
            }
                
            }
		return null;
     
            
		
	}
}
