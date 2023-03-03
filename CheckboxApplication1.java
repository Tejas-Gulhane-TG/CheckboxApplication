/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.checkboxapplication1;

/**
 *
 * @author TEJAS
 */
import java.awt.*;
import java.awt.event.*;
class CheckboxApplication1 extends Frame implements ItemListener,TextListener,ActionListener
{
    Label l1,l2;
    TextField t1,t2,t3,t4,t5,t6;
    Checkbox c1,c2,c3,c4;
    Button btnsel,btnclear,btnrevert;

    CheckboxApplication1()
    {
    	setSize(600,700);
//        setBackground(Color.black);
    	setTitle("Arithmetic operations on two numbers");
    	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
    	setLayout(null);
    	setFont(new Font("Arial black",Font.BOLD,20) );
    	Label lheader = new Label("Arithmetic operations on two numbers",Label.CENTER);
        lheader.setBounds(10,50,580,50);
        lheader.setBackground(Color.yellow);
    	add(lheader);

    	//first number
    	l1 = new Label("First Number ");
    	l1.setBounds(50,130,200,40);
    	add(l1);
    	t1 = new TextField();
    	t1.setBounds(300,130,200,40);
    	add(t1);
        t1.addTextListener(this);


    	//second number
    	l2 = new Label("Second Number ");
    	l2.setBounds(50,200,200,40);
    	add(l2);
    	t2 = new TextField();
    	t2.setBounds(300,200,200,40);
    	add(t2);
        t2.addTextListener(this);

    	//Addition
    	c1 = new Checkbox("Addition ");
    	c1.setBounds(50,270,200,40);
    	c1.addItemListener(this);
    	add(c1);
    	t3 = new TextField();
    	t3.setBounds(300,270,200,40);
    	add(t3);
    	t3.setEnabled(false);

    	//subtraction
    	c2 = new Checkbox("Subtraction");
    	c2.setBounds(50,340,200,40);
    	c2.addItemListener(this);
    	add(c2);
    	t4 = new TextField();
    	t4.setBounds(300,340,200,40);
    	add(t4);
    	t4.setEnabled(false);

        //multiplication
    	c3 = new Checkbox("Multiplication");
    	c3.setBounds(50,410,200,40);
    	c3.addItemListener(this);
    	add(c3);
    	t5 = new TextField();
    	t5.setBounds(300,410,200,40);
    	add(t5);
    	t5.setEnabled(false);
    	
    	//multiplication
    	c4 = new Checkbox("Division");
    	c4.setBounds(50,480,200,40);
     	c4.addItemListener(this);
    	add(c4);
    	t6 = new TextField();
    	t6.setBounds(300,480,200,40);
    	add(t6);
    	t6.setEnabled(false);
       
        btnsel = new Button("Select All");
        btnsel.setBounds(50,550,120,40);
        add(btnsel);
        btnsel.addActionListener(this);

        btnclear = new Button("Clear All");
        btnclear.setBounds(215,550,120,40);
        add(btnclear);
        btnclear.addActionListener(this);

        btnrevert = new Button("Revert");
        btnrevert.setBounds(380,550,120,40);
        add(btnrevert);
        btnrevert.addActionListener(this);
        enabled(false);
       	
    }
    public void textValueChanged(TextEvent te)
    {
        if(t1.getText().length()>0 && t2.getText().length()>0)
           enabled(true);
        else
           enabled(false);
    }
    void enabled(boolean s)
    {
         c1.setEnabled(s);
         c2.setEnabled(s);
         c3.setEnabled(s);
         c4.setEnabled(s);
         btnsel.setEnabled(s);
         btnclear.setEnabled(s);
         btnrevert.setEnabled(s);       
    }
    void changeState(boolean s)
    {
        c1.setState(s);
        c2.setState(s);
        c3.setState(s);
        c4.setState(s);
    }
    void revertState()
    {
         c1.setState(!c1.getState());
         c2.setState(!c2.getState());
         c3.setState(!c3.getState());
         c4.setState(!c4.getState());
    }
   
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnsel)
            changeState(true);
        else
            if(ae.getSource()==btnclear)
              changeState(false);
            else 
                if(ae.getSource()==btnrevert)
                   revertState();
    }
    public void itemStateChanged(ItemEvent ie)
    {
        try
        {
    	double n1 = Double.parseDouble(t1.getText());
        double n2 = Double.parseDouble(t2.getText());
    	
         if(c1.getState())
           {
           	  double a = n1+n2;
           	  t3.setText(""+a);
           }
         else
         	t3.setText("");

          if(c2.getState())
           {
           	  double s = n1-n2;
           	  t4.setText(""+s);
           }
         else
         	t4.setText("");

          if(c3.getState())
           {
           	  double m = n1*n2;
           	  t5.setText(""+m);
           }
         else
         	t5.setText("");

          if(c4.getState())
           {
           	  double d = n1/n2;
           	  t6.setText(""+d);
           }
         else
         	t6.setText("");
     }catch(Exception e)
     {}
    }
	public static void main(String[] args) {
		 (new CheckboxApplication1()).setVisible(true);
	}
}