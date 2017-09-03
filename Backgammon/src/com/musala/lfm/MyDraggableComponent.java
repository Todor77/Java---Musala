package com.musala.lfm;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class MyDraggableComponent
    extends JComponent {
  
 
  private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

  

  public MyDraggableComponent() {
    setBorder(new LineBorder(Color.BLUE, 3));
    setBackground(Color.WHITE);
    setSize(30, 30);
    setOpaque(true);

    addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) { }

      @Override
      public void mousePressed(MouseEvent e) {
        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = getX();
        myY = getY();
      }

      @Override
      public void mouseReleased(MouseEvent e) { 
    	  
      }

      @Override
      public void mouseEntered(MouseEvent e) { }

      @Override
      public void mouseExited(MouseEvent e) { }

    });
    addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent e) {
    	  
    		  int deltaX = e.getXOnScreen() - screenX;
    	        int deltaY = e.getYOnScreen() - screenY;

    	        setLocation(myX + deltaX, myY + deltaY);
    	      
       
      }

      @Override
      public void mouseMoved(MouseEvent e) { }

    });
  }
 

public static void main(String[] args) {
	  
	    JFrame f = new JFrame("Backgammon");
	    f.setSize(500, 500);
	    f.setLayout(null);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    f.setLocationRelativeTo(null);
	    f.setResizable(false);
	    
	    try {
			f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("board.jpg")))));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	    
	    JLabel place_ = new JLabel();
	    JLabel place_1 = new JLabel();
	    JLabel place_2 = new JLabel();
	    JLabel place_3 = new JLabel();
	    place_3.setSize(30, 100);
	    place_3.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    place_3.setLocation(205, 373);
	    place_2.setSize(30, 100);
	    place_2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    place_2.setLocation(302, 373);
	    place_1.setSize(30, 100);
	    place_1.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    place_1.setLocation(460, 0);
	    place_.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	    place_.setLocation(0, 0);
	    place_.setSize(30, 100);
	    place_.setOpaque(false);
	    place_1.setOpaque(false);
	    place_2.setOpaque(false);
	    place_3.setOpaque(false);
	    
	    
	    JButton prvaKocka = new JButton();
	    JButton vtoraKocka = new JButton();
	    JButton rolling = new JButton("Roll");
	    JButton startGame = new JButton("Start Game");

	    prvaKocka.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
	    vtoraKocka.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
	    
	    startGame.setSize(100, 55);
	    startGame.setLocation(350, 200);
	    
	    rolling.setSize(70, 55);
	    rolling.setLocation(78, 200);
	    
	    vtoraKocka.setSize(30, 30);
	    vtoraKocka.setLocation(227, 190);
	    prvaKocka.setSize(30, 30);
	    prvaKocka.setLocation(227, 230);
	 
	    
	   
	   
	   
	    f.add(startGame);
	    f.add(prvaKocka);
	    f.add(vtoraKocka);
	    f.add(rolling);
	    f.add(place_3);
	    f.add(place_2);
	    f.add(place_1);
	    f.add(place_);
	  
	  
	    MyDraggableComponent firstOne = new MyDraggableComponent();
 	    MyDraggableComponent secondOne = new MyDraggableComponent();
		firstOne.setLocation(1, 1);
		secondOne.setLocation(1, 70);
	
		f.add(firstOne);
		f.add(secondOne);
	    
	
	    
	    startGame.addActionListener(new ActionListener() {
			
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				firstOne.setLocation(1, 1);
				secondOne.setLocation(1, 70);
			
				f.add(firstOne);
				f.add(secondOne);
				
					    
				}
				
			
		});
	    
	    rolling.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				int randomNumber = random.ints(1, 1, 7).findFirst().getAsInt();
				int randomNumber2 = random.ints(1, 1, 7).findFirst().getAsInt();
				 int max = (int)(Math.random() * 41 + 180);
				    int min = (int)(Math.random() * 41 + 230);

				  
				int range = (max - min) + 1;     
			
				   int locationX = (int)(Math.random() * 20) + min;
				   int locationY = (int)(Math.random() * 20) + min;
				
				   prvaKocka.setLocation(locationX, locationY);
				   locationX += 20;
				   locationY += 20;
				   vtoraKocka.setLocation(locationY, locationX);
				   prvaKocka.setText(String.valueOf(randomNumber2));
				   vtoraKocka.setText(String.valueOf(randomNumber));
				
			}
		});
	   
	    f.setVisible(true);
	  }
	

}
