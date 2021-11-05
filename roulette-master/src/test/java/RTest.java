
import edu.upb.models.IRoulette;
import edu.upb.models.Node;
import edu.upb.models.QyA;
import edu.upb.models.Roulette;
import edu.upb.models.Topics;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vasqu
 */
public class RTest {
    protected IRoulette r;
    @Test
    public void uploadFileToRouletteEmpty(){
    
        Roulette prueba = new Roulette();
	prueba.uploadroulette();   
        assertTrue(prueba.isEmpty()); 
    }
    @Test
    public void girarRouletteAndReturnTopic(){
    
        Roulette prueba = new Roulette();
	prueba.uploadroulette();   
        prueba.girar();
        Node current = prueba.getRoulette().getFirst();
        for(int j=0;j<4;j++){
        
            Topics tema = (Topics) current.getValue();
            String temaTexto= tema.getTopic();
            if(j==0){
                String probarTema="Cultura";
                assertEquals(temaTexto, probarTema);
            
            }
            if(j==1){
            
                String probarTema="Arte";
                assertEquals(temaTexto, probarTema);
            }
            if(j==2){
            
                String probarTema="Musica";
                assertEquals(temaTexto, probarTema);
            }
            if(j==3){
            
                String probarTema="Literatura";
                assertEquals(temaTexto, probarTema);
            }
            if(j==4){
            
                String probarTema="Politica";
                assertEquals(temaTexto, probarTema);
            }
            
            current=current.getNext();
            
        }
        
    }
    @Test
    public void girarRouletteAndReturnQuestionAndAnswer(){
    
        Roulette prueba = new Roulette();
	prueba.uploadroulette();   
        Topics tema = prueba.girar();
        QyA qa=tema.seleccionarPregunta();
        assertTrue(qa.getAnswer()!=null);
        assertTrue(qa.getQuestion()!=null);
    }
    @Test
    public void girarRouletteAndReturnOptions(){
    
        Roulette prueba = new Roulette();
	prueba.uploadroulette();   
        Topics tema = prueba.girar();
        QyA qa=tema.seleccionarPregunta();
        assertTrue(qa.getOpcion1()!=null);
        assertTrue(qa.getOpcion2()!=null);
        assertTrue(qa.getOpcion3()!=null);
    }
    @Test
    public void questionHaveAndAnswerInOptions(){
    
        Roulette prueba = new Roulette();
	prueba.uploadroulette();   
        Topics tema = prueba.girar();
        QyA qa=tema.seleccionarPregunta();
        boolean proof=false;
        if(qa.getOpcion1().equals(qa.getAnswer())){
        
          proof=true;  
        }else if(qa.getOpcion2().equals(qa.getAnswer())){
        
          proof=true;  
        }else if(qa.getOpcion3().equals(qa.getAnswer())){
        
          proof=true;  
        }
        assertTrue(proof);
    }
    
    
}
   