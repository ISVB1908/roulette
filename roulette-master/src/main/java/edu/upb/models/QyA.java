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
public class QyA<T> {

	private  String question;
	private  String opcion1;
	private  String opcion2;
	private  String opcion3;
	private  String answer;

	public  String getQuestion() {
		return question;
	}

	public void setQuestion( String question) {
		this.question = question;
	}

	public String getOpcion1() {
		return opcion1;
	}

	public void setOpcion1( String opcion1) {
		this.opcion1 = opcion1;
	}

	public QyA(String question, String opcion1,  String opcion2,  String opcion3) {
		super();
		this.question = question;
		this.opcion1 = opcion1;
		this.opcion2 = opcion2;
		this.opcion3 = opcion3;
		calcularRespuesta();
	}

	public  void calcularRespuesta() {
	
		
		if(opcion1.contains("*"))
		{   
			opcion1=opcion1.replace("*", ""); 
			answer= opcion1;	    	
			
		}
		else if(opcion2.contains("*"))
		{   opcion2=opcion2.replace("*", "");
			answer= opcion2;
			
		} 
		else if(opcion3.contains("*"))
		{ opcion3 = opcion3.replace("*", "");
			answer= opcion3;	
			
		} 


	}

	public String getOpcion2() {
		return opcion2;
	}

	public void setOpcion2( String opcion2) {
		this.opcion2 = opcion2;
	}

	public  String getOpcion3() {
		return opcion3;
	}

	public void setOpcion3( String opcion3) {
		this.opcion3 = opcion3;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer( String answer) {
		this.answer = answer;
	}
    @Override
    public String toString()
    {
   	
		return  "Su pregunta es "+ question + " \n "+ "a. "+ opcion1+ "\n " + "b. " + opcion2+ " \n "+ "c. "+opcion3;
   	
    }

}

