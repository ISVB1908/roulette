package edu.upb.proroulette;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import edu.upb.models.Topics;
import edu.upb.models.Node;
import edu.upb.models.QyA;
import edu.upb.models.Roulette;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.*;

public class View extends JFrame {

	private JFrame frame;
	private JTextField preguntaAdd;
	private JTextField opcionAAdd;
	private JTextField opcionBAdd;
	private JTextField opcionCAdd;
	private JTextField correctaAdd;
	private Topics actual;
	private String correcta;
	private JTextField topicAdd;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					View window = new View();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public View() {
		

		initialize();
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Roulette prueba = new Roulette();
		prueba.uploadroulette();
                prueba.printRoulette();
		int contador =0;
		actual = prueba.girar();
		QyA pregunta =actual.seleccionarPregunta();	
		setCorrecta(pregunta.getAnswer());
		while(pregunta==null&&contador<5) {
			Node x = prueba.getRoulette().getFirst();
			actual= (Topics) x.getValue();
			pregunta =actual.seleccionarPregunta();
			contador++;
		}
		if(pregunta!=null)
		{



			System.out.println("Su categoria es : "+actual.getTopic()+"\n" + pregunta.toString());
			
		}
		
		
		
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 645, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel title = new JLabel("Roulette");
		title.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.insets = new Insets(0, 0, 5, 5);
		gbc_title.gridx = 5;
		gbc_title.gridy = 1;
		frame.getContentPane().add(title, gbc_title);
		
		JLabel topicLabel = new JLabel(actual.getTopic());
		GridBagConstraints gbc_topicLabel = new GridBagConstraints();
		gbc_topicLabel.insets = new Insets(0, 0, 5, 5);
		gbc_topicLabel.gridx = 5;
		gbc_topicLabel.gridy = 6;
		frame.getContentPane().add(topicLabel, gbc_topicLabel);
		
		JLabel preguntaLabel = new JLabel(pregunta.getQuestion());
		preguntaLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		GridBagConstraints gbc_preguntaLabel = new GridBagConstraints();
		gbc_preguntaLabel.gridheight = 2;
		gbc_preguntaLabel.gridwidth = 9;
		gbc_preguntaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaLabel.gridx = 1;
		gbc_preguntaLabel.gridy = 7;
		frame.getContentPane().add(preguntaLabel, gbc_preguntaLabel);
		
		JLabel aLabel = new JLabel(pregunta.getOpcion1());
		GridBagConstraints gbc_aLabel = new GridBagConstraints();
		gbc_aLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aLabel.gridx = 5;
		gbc_aLabel.gridy = 9;
		frame.getContentPane().add(aLabel, gbc_aLabel);
		JLabel bLabel = new JLabel(pregunta.getOpcion2());
		GridBagConstraints gbc_bLabel = new GridBagConstraints();
		gbc_bLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bLabel.gridx = 5;
		gbc_bLabel.gridy = 10;
		frame.getContentPane().add(bLabel, gbc_bLabel);
		JLabel cLabel = new JLabel(pregunta.getOpcion3());
		GridBagConstraints gbc_cLabel = new GridBagConstraints();
		gbc_cLabel.insets = new Insets(0, 0, 5, 5);
		gbc_cLabel.gridx = 5;
		gbc_cLabel.gridy = 11;
		frame.getContentPane().add(cLabel, gbc_cLabel);
		
		JButton bButton = new JButton("B");
		bButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(getCorrecta());
				if(bLabel.getText().equals(getCorrecta()))
				{
					

					prueba.setPuntuacion(prueba.getPuntuacion()+1);
					JOptionPane.showMessageDialog(bButton, "correct"+"\n"+prueba.getPuntuacion());
				}
				else 
				{
					JOptionPane.showMessageDialog(bButton, "Incorrect"+"\n"+prueba.getPuntuacion());
					System.out.println("Incorrecto");
				}
				actual = prueba.girar();
				int contador =0;
				QyA pregunta =actual.seleccionarPregunta();	
				//setCorrecta(pregunta.getAnswer());
				int stop=0;
				while(pregunta==null && stop<6) {
				actual=prueba.serch();
				pregunta=actual.seleccionarPregunta();
					
					stop++;
					
				}
				if(pregunta==null) {
					prueba.setPuntuacion(prueba.getPuntuacion());;
					JOptionPane.showMessageDialog(bButton, "finalizo el juego"+"\n"+"Su puntuacion fue de: "+prueba.getPuntuacion());
					try {
						Thread.sleep(10000);
						System.exit(0);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				if(pregunta!=null)
				{

					setCorrecta(pregunta.getAnswer());
					topicLabel.setText(actual.getTopic());
					preguntaLabel.setText(pregunta.getQuestion());
					aLabel.setText(pregunta.getOpcion1());
					bLabel.setText(pregunta.getOpcion2());
					cLabel.setText(pregunta.getOpcion3());
					System.out.println("Su categoria es : "+actual.getTopic()+"\n" + pregunta.toString());
					
				}
				
			}
		});
		bButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		GridBagConstraints gbc_bButton = new GridBagConstraints();
		gbc_bButton.anchor = GridBagConstraints.WEST;
		gbc_bButton.insets = new Insets(0, 0, 5, 5);
		gbc_bButton.gridx = 4;
		gbc_bButton.gridy = 10;
		frame.getContentPane().add(bButton, gbc_bButton);
		
		
		
		JButton cButton = new JButton("C");
		cButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				System.out.println(getCorrecta());
				if(cLabel.getText().equals(getCorrecta()))
				{
					

					prueba.setPuntuacion(prueba.getPuntuacion()+1);;
					JOptionPane.showMessageDialog(cButton, "correct"+"\n"+prueba.getPuntuacion());
				}
				else 
				{
					JOptionPane.showMessageDialog(cButton, "Incorrect"+"\n"+prueba.getPuntuacion());
					System.out.println("Incorrecto");
				}
				actual = prueba.girar();
				int contador =0;
				QyA pregunta =actual.seleccionarPregunta();		
				//setCorrecta(pregunta.getAnswer());
				int stop=0;
				while(pregunta==null && stop<6) {
					actual=prueba.serch();
					pregunta=actual.seleccionarPregunta();
					stop++;
					
				}
				if(pregunta==null) {
					prueba.setPuntuacion(prueba.getPuntuacion());;
					JOptionPane.showMessageDialog(bButton, "finalizo el juego"+"\n"+"Su puntuacion fue de: "+prueba.getPuntuacion());
					try {
						Thread.sleep(1000);
						System.exit(0);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				
				if(pregunta!=null)
				{

					setCorrecta(pregunta.getAnswer());
					topicLabel.setText(actual.getTopic());
					preguntaLabel.setText(pregunta.getQuestion());
					aLabel.setText(pregunta.getOpcion1());
					bLabel.setText(pregunta.getOpcion2());
					cLabel.setText(pregunta.getOpcion3());
					System.out.println("Su categoria es : "+actual.getTopic()+"\n" + pregunta.toString());
					
				}
			}
		});
		cButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_cButton = new GridBagConstraints();
		gbc_cButton.anchor = GridBagConstraints.WEST;
		gbc_cButton.insets = new Insets(0, 0, 5, 5);
		gbc_cButton.gridx = 4;
		gbc_cButton.gridy = 11;
		frame.getContentPane().add(cButton, gbc_cButton);
		
		
		
		JButton aButton = new JButton("A");
		aButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		aButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				//
				
				
				
				System.out.println(getCorrecta());
				if(aLabel.getText().equals(getCorrecta()))
				{
					

					prueba.setPuntuacion(prueba.getPuntuacion()+1);
					JOptionPane.showMessageDialog(aButton, "correct"+"\n"+prueba.getPuntuacion());
					System.out.println("correcto");
				}
				else 
				{
					JOptionPane.showMessageDialog(aButton, "Incorrect"+"\n"+prueba.getPuntuacion());
					System.out.println("Incorrecto");
				}
				actual = prueba.girar();
				int contador =0;
				QyA pregunta =actual.seleccionarPregunta();		
				//setCorrecta(pregunta.getAnswer());
				int stop=0;
				while(pregunta==null && stop<6) {
					actual=prueba.serch();
					pregunta=actual.seleccionarPregunta();
					stop++;
					
				}
				if(pregunta==null) {
					prueba.setPuntuacion(prueba.getPuntuacion());;
					JOptionPane.showMessageDialog(aButton, "finalizo el juego"+"\n"+"Su puntuacion fue de: "+prueba.getPuntuacion());
					
					try {
						Thread.sleep(10000);
						System.exit(0);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					
				}
				

				
				if(pregunta!=null)
				{

					setCorrecta(pregunta.getAnswer());
					topicLabel.setText(actual.getTopic());
					preguntaLabel.setText(pregunta.getQuestion());
					aLabel.setText(pregunta.getOpcion1());
					bLabel.setText(pregunta.getOpcion2());
					cLabel.setText(pregunta.getOpcion3());
					//correcta=pregunta.getAnswer();
					System.out.println("Su categoria es : "+actual.getTopic()+"\n" + pregunta.toString());
					
				}
				
			}
		});
		GridBagConstraints gbc_aButton = new GridBagConstraints();
		gbc_aButton.anchor = GridBagConstraints.WEST;
		gbc_aButton.insets = new Insets(0, 0, 5, 5);
		gbc_aButton.gridx = 4;
		gbc_aButton.gridy = 9;
		frame.getContentPane().add(aButton, gbc_aButton);
		
		JLabel TopicLabel = new JLabel("Tema");
		GridBagConstraints gbc_TopicLabel = new GridBagConstraints();
		gbc_TopicLabel.insets = new Insets(0, 0, 5, 5);
		gbc_TopicLabel.anchor = GridBagConstraints.EAST;
		gbc_TopicLabel.gridx = 4;
		gbc_TopicLabel.gridy = 13;
		frame.getContentPane().add(TopicLabel, gbc_TopicLabel);
		
		topicAdd = new JTextField();
		GridBagConstraints gbc_topicAdd = new GridBagConstraints();
		gbc_topicAdd.insets = new Insets(0, 0, 5, 5);
		gbc_topicAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_topicAdd.gridx = 5;
		gbc_topicAdd.gridy = 13;
		frame.getContentPane().add(topicAdd, gbc_topicAdd);
		topicAdd.setColumns(10);
		
		JLabel preguntaAddLabel = new JLabel("Pregunta");
		GridBagConstraints gbc_preguntaAddLabel = new GridBagConstraints();
		gbc_preguntaAddLabel.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaAddLabel.anchor = GridBagConstraints.EAST;
		gbc_preguntaAddLabel.gridx = 4;
		gbc_preguntaAddLabel.gridy = 14;
		frame.getContentPane().add(preguntaAddLabel, gbc_preguntaAddLabel);
		
		preguntaAdd = new JTextField();
		GridBagConstraints gbc_preguntaAdd = new GridBagConstraints();
		gbc_preguntaAdd.insets = new Insets(0, 0, 5, 5);
		gbc_preguntaAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_preguntaAdd.gridx = 5;
		gbc_preguntaAdd.gridy = 14;
		frame.getContentPane().add(preguntaAdd, gbc_preguntaAdd);
		preguntaAdd.setColumns(10);
		
		JLabel opcionAAddLabel = new JLabel("Opcion A");
		GridBagConstraints gbc_opcionAAddLabel = new GridBagConstraints();
		gbc_opcionAAddLabel.insets = new Insets(0, 0, 5, 5);
		gbc_opcionAAddLabel.anchor = GridBagConstraints.EAST;
		gbc_opcionAAddLabel.gridx = 4;
		gbc_opcionAAddLabel.gridy = 15;
		frame.getContentPane().add(opcionAAddLabel, gbc_opcionAAddLabel);
		
		opcionAAdd = new JTextField();
		GridBagConstraints gbc_opcionAAdd = new GridBagConstraints();
		gbc_opcionAAdd.insets = new Insets(0, 0, 5, 5);
		gbc_opcionAAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_opcionAAdd.gridx = 5;
		gbc_opcionAAdd.gridy = 15;
		frame.getContentPane().add(opcionAAdd, gbc_opcionAAdd);
		opcionAAdd.setColumns(10);
		
		JLabel opcionBAddLabel = new JLabel("Opcion B");
		GridBagConstraints gbc_opcionBAddLabel = new GridBagConstraints();
		gbc_opcionBAddLabel.insets = new Insets(0, 0, 5, 5);
		gbc_opcionBAddLabel.anchor = GridBagConstraints.EAST;
		gbc_opcionBAddLabel.gridx = 4;
		gbc_opcionBAddLabel.gridy = 16;
		frame.getContentPane().add(opcionBAddLabel, gbc_opcionBAddLabel);
		
		opcionBAdd = new JTextField();
		GridBagConstraints gbc_opcionBAdd = new GridBagConstraints();
		gbc_opcionBAdd.insets = new Insets(0, 0, 5, 5);
		gbc_opcionBAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_opcionBAdd.gridx = 5;
		gbc_opcionBAdd.gridy = 16;
		frame.getContentPane().add(opcionBAdd, gbc_opcionBAdd);
		opcionBAdd.setColumns(10);
		
		JLabel opcionCAddLabel = new JLabel("Opcion C");
		GridBagConstraints gbc_opcionCAddLabel = new GridBagConstraints();
		gbc_opcionCAddLabel.insets = new Insets(0, 0, 5, 5);
		gbc_opcionCAddLabel.anchor = GridBagConstraints.EAST;
		gbc_opcionCAddLabel.gridx = 4;
		gbc_opcionCAddLabel.gridy = 17;
		frame.getContentPane().add(opcionCAddLabel, gbc_opcionCAddLabel);
		
		opcionCAdd = new JTextField();
		GridBagConstraints gbc_opcionCAdd = new GridBagConstraints();
		gbc_opcionCAdd.insets = new Insets(0, 0, 5, 5);
		gbc_opcionCAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_opcionCAdd.gridx = 5;
		gbc_opcionCAdd.gridy = 17;
		frame.getContentPane().add(opcionCAdd, gbc_opcionCAdd);
		opcionCAdd.setColumns(10);
		
		JLabel correcionAddLabel = new JLabel("Correcta");
		GridBagConstraints gbc_correcionAddLabel = new GridBagConstraints();
		gbc_correcionAddLabel.insets = new Insets(0, 0, 5, 5);
		gbc_correcionAddLabel.anchor = GridBagConstraints.EAST;
		gbc_correcionAddLabel.gridx = 4;
		gbc_correcionAddLabel.gridy = 18;
		frame.getContentPane().add(correcionAddLabel, gbc_correcionAddLabel);
		
		correctaAdd = new JTextField();
		GridBagConstraints gbc_correctaAdd = new GridBagConstraints();
		gbc_correctaAdd.insets = new Insets(0, 0, 5, 5);
		gbc_correctaAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_correctaAdd.gridx = 5;
		gbc_correctaAdd.gridy = 18;
		frame.getContentPane().add(correctaAdd, gbc_correctaAdd);
		correctaAdd.setColumns(10);
		
		JButton addButton = new JButton("Agregar");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean proof=true;
				if(opcionAAdd.getText().isBlank() || opcionBAdd.getText().isBlank() || opcionCAdd.getText().isBlank() || preguntaAdd.getText().isBlank() || topicAdd.getText().isBlank() ) {
					System.out.println(opcionAAdd.getText()+opcionBAdd.getText()+opcionCAdd.getText()+preguntaAdd.getText());
					JOptionPane.showMessageDialog(addButton, "no has llenado correctamente los campos");
					
				}
				else if(!correctaAdd.getText().equals(opcionBAdd.getText()) && !correctaAdd.getText().equals(opcionCAdd.getText()) && !correctaAdd.getText().equals(opcionAAdd.getText())) {
					proof=false;
					JOptionPane.showMessageDialog(addButton, "no coincide la opcion correcta con las opciones");
					
				}
				
				else if(proof=true && prueba.searchProof(topicAdd.getText())) {
					System.out.println("entro");
					String a =opcionAAdd.getText();
					String b =opcionBAdd.getText();
					String c =opcionCAdd.getText();
					if(correctaAdd.getText().equals(opcionAAdd.getText())) {
						a="*"+a+"*";
					}
					if(correctaAdd.getText().equals(opcionBAdd.getText())) {
						b="*"+b+"*";
					}
					if(correctaAdd.getText().equals(opcionCAdd.getText())) {
						c="*"+c+"*";
					}
					String send =preguntaAdd.getText()+"/"+a+"/"+b+"/"+c;
					prueba.agregarPregunta(topicAdd.getText(), send);
					JOptionPane.showMessageDialog(addButton, "agregada");
					correctaAdd.setText("");
					opcionAAdd.setText("");
					opcionBAdd.setText("");
					opcionCAdd.setText("");
					topicAdd.setText("");
					preguntaAdd.setText("");
					prueba.printRoulette();
					
				}else {
					
					JOptionPane.showMessageDialog(addButton, "no se pudo agregar");
				}
					
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 5;
		gbc_addButton.gridy = 19;
		frame.getContentPane().add(addButton, gbc_addButton);
	}

	public String getCorrecta() {
		return correcta;
	}

	public void setCorrecta(String correcta) {
		this.correcta = correcta;
	}

	
}
