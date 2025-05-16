
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import javax.swing.JScrollPane;

public class Hospitals  extends JFrame 
{
        
    int count = 1;
         String [] Names = new String[5];
        String [] Location = new String[5];
         String [] Inspection  = new String[5];
         
           JLabel L1 = new JLabel ("Hospital Name : ");
    JLabel L2 = new JLabel ("Hospital Location: ");
    JLabel L3 = new JLabel ("Years since inspection : ");
    JLabel L4 = new JLabel ("  ");
    JTextField T1 = new JTextField (20);
    JTextField T2 = new JTextField (20);
    JButton b1 = new JButton ("SAVE ") ;
    JButton b2 = new JButton ("PRINT ") ;
    JButton b3 = new JButton ("CLEAR  ") ;
    JTextArea JResult= new JTextArea(5,5);
     JComboBox<String> majorChoice = new JComboBox<String>();
        public void initialize()
    {
         
       //JComboBox<String> majorChoice = new JComboBox<String>();
        majorChoice.addItem("1 year ");
         majorChoice.addItem("2 years");
         majorChoice.addItem("3 years ");
    
         JPanel jpForm1 = new JPanel();
    JPanel jpForm = new JPanel();
    jpForm.setLayout(new GridLayout(5,2, 10,5));
    jpForm1.setLayout(new GridLayout(1,2, 10,5));
    jpForm.add(L1);
    jpForm.add(T1);
    jpForm.add(L2);
    jpForm.add(T2);
    jpForm.add(L3);
    jpForm.add(majorChoice);
    jpForm.add(L4);
    jpForm.add(b1);
    jpForm1.add(b2);
    jpForm1.add(b3);
    
    
    
    
    b1.addActionListener(new ActionListener()
        {
             public void  actionPerformed  (ActionEvent e  )
                   {
              //istructions inside this function  are exacuted  when the user click save button 
          
              save();
            }
          });
    
    JTextArea JResult= new JTextArea(5,5);
    JResult.setEnabled(false);
    JScrollPane SResults= new JScrollPane(JResult);
    
    JPanel jpMainPanel = new JPanel();
    jpMainPanel.setLayout( new BorderLayout(10,10));
    jpMainPanel.add(jpForm,BorderLayout.NORTH);
    jpMainPanel.add(SResults,BorderLayout.CENTER);
    jpMainPanel.add(jpForm1,BorderLayout.SOUTH);
    jpMainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    add(jpMainPanel);
    
    b2.addActionListener(new ActionListener()
      {
          public void  actionPerformed  (ActionEvent e  )
           {
             //istructions inside this function  are exacuted  when the user click print button 
             
             for (int x = 0 ;x<count ;x++)
         {
              String m =" Hospital Name:"+Names[x] +"\nHospital location : " + Location[x]+ "\nYears Since inspection : " + Inspection[x] + "\n ********************************";
             JResult.setText(m);
             
           }
            }
          });
    
          b3 .addActionListener(new ActionListener(){
        public void  actionPerformed  (ActionEvent e  )
        {
          //istructions inside this function  are exacuted  when the user click save button 
          clear();
            }
          });
    
          JMenuBar mb = new JMenuBar() ;
          JMenu file = new JMenu(" file" ) ;
           JMenu Tools = new JMenu(" Tools" ) ;
           mb.add(file);
           mb.add(Tools);
       JMenuItem exit = new JMenuItem(" exit" );
       JMenuItem save  = new JMenuItem(" save " );  
       JMenuItem print = new JMenuItem(" print" );  
       JMenuItem clear = new JMenuItem(" clear" );
          file.add(exit);
          Tools.add(save);
          Tools.add(print);
          Tools.add(clear);
          
          save.addActionListener(new ActionListener(){
             public void  actionPerformed  (ActionEvent e  )
           {
             
            save();
          
            
            }
          });
          
          print.addActionListener(new ActionListener(){
        public void  actionPerformed  (ActionEvent e  )
        {
           
           for (int x = 0 ;x<count ;x++)
         {
              String m =" Hospital Name:"+Names[x] +"\nHospital location : " + Location[x]+ "\nYears Since inspection : " + Inspection[x] + "\n ********************************";
             JResult.setText(m);
             
           }
            }
          });
           clear.addActionListener(new ActionListener(){
        public void  actionPerformed  (ActionEvent e  )
        {
           
          
          clear () ; 
            }
          });
    
           exit.addActionListener(new ActionListener(){
        public void  actionPerformed  (ActionEvent e  )
        {
          //istructions inside this function  are exacuted  when the user click exit from the bar Menu
          System.exit(0);
          
            }
          });
          
          final int WIDTH = 600;
    final int LENGTH = 400;
    setTitle( " Hospital Inspections" );
    setSize(WIDTH,LENGTH);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setJMenuBar(mb);
    
    
    }
    
     public void clear () 
     {
        T1.setText("");
          T2.setText(""); 
          //This methords clears the TextBox
          //istructions inside this function  are exacuted  when the user click clear  button 
     }

    public void print( )
    {
        // This methord prints when the print button is pressed 
        //istructions inside this function  are exacuted  when the user click print button 
         for (int x = 0 ;x<count ;x++)
         {
              String m =" Hospital Name:"+Names[x] +"\nHospital location : " + Location[x]+ "\nYears Since inspection : " + Inspection[x] + "\n ********************************";
              
              JResult.setText(m);
             
           }
    }
    
    public void save()
    {
        // when the user presses save button this method takes the data and saves it to the arrays 
        //istructions inside this function  are exacuted  when the user click save button 
          String name = T1.getText();
          String location = T2.getText();
          String inspection=majorChoice.getSelectedItem().toString(); 

          for(int x =0;x<5;x++)
          {
            Names[x] = name;
            Location[x]= location;
            Inspection[x]  = inspection;
            
              }
            
            //  if the user try to  saves more than 5 datas the system wont allow it and it will inform them   
          if (count >6){
             JOptionPane.showMessageDialog(null," Maximum inpection count reached ");        
              }
               count = count +1; 
    }
}