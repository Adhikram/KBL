import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class Kbl extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3,b4;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,n=0;  
    int m[]=new int[11];      
    Kbl(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();  //Initialize the radio button     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
         b1=new JButton("Next");     //create the Button with there name
        b2=new JButton("Bookmark"); 
		b3=new JButton("Yes");
		//b4=new JButton("Exit");
        b1.addActionListener(this);  
        b2.addActionListener(this);  
		b3.addActionListener(this);
		//b4.addActionListener(this);
        add(b1);add(b2); add(b3);//add(b4); //add the button
        set();  
        l.setBounds(30,40,450,20);//set the size and ppsition of the buttons  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);
		b3.setBounds(170,240,100,30);
		//b4.setBounds(370,240,100,30);
		//Terminate the program when the user closes the application.	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,450);  //set the size of the frame
    }  
    public void actionPerformed(ActionEvent e)      //Buttons are action to be performmed
    {		
	if(e.getSource()==b3)
	{
		l.setText("WELCOME TO KON BANEGA LAKHPATI");
	}
	if(e.getSource()==b4);
	{
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate the program when the user closes the application. 
	}	
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==10)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
			//if(current==0)
			//	b3.setEnabled(false);
			  //  b1.setText("Next");
            }
			
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  //After clicking the bookmark button the questions willbe added on bookmark
            bk.setBounds(480,20+30*x,100,30);       //set the size of the new bookmark button
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==10)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())       //bookmarks are counting
                count=count+1;  
            n=current;  
            current=m[y];  
            set();
            ((JButton)e.getSource()).setEnabled(false);  
            current=n;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  //result are count
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"You Win Rs."+count*10000); //result is printing 
            System.exit(0); //use for exit aafter result out
		
        }  
    }  
    void set()  
    {  
          
		if(current==0)
		{
		l.setText("Do You Want To Play ?");	
		jb[4].setSelected(false);
		} 
			
		jb[4].setSelected(true);//QUESTION ARE WRITTEN HERE
        if(current==1)  
        {  
            l.setText("Que1:Ball pen function on which one of the following principle ");  
            jb[0].setText("Boyle's law");jb[1].setText("Gravitational force");jb[2].setText("surface tension");jb[3].setText("Viscosity");   
        }  
        if(current==2)  
        {  
            l.setText("Que2: Where is Salar Jung Museum situated??");  
            jb[0].setText("Hydrabd");jb[1].setText("Jaipur");jb[2].setText("Lucknow");jb[3].setText("Mumbai");  
        }  
        if(current==3)  
        {  
            l.setText("Que3: Sensex is related to");  
            jb[0].setText("BSE");jb[1].setText("NSE");jb[2].setText("RBI");jb[3].setText("SEBI");  
        }  
        if(current==4)  
        {  
            l.setText("Que4: The World Population Day is celebrated on?");  
            jb[0].setText("11th july");jb[1].setText("12th july");jb[2].setText("15th july");jb[3].setText("11August");  
        }  
        if(current==5)  
        {  
            l.setText("Que5: National Integration Council is chaired by?");  
            jb[0].setText("The President");jb[1].setText("The Prime Minister");jb[2].setText("The Defence Minister");jb[3].setText("The Home Minister");  
        }  
        if(current==6)  
        {  
            l.setText("Que6: Where is Brhadeshwar Temple is situated ?");  
            jb[0].setText("Kanchi");jb[1].setText("Madurai");jb[2].setText("shri shailan");jb[3].setText("Tanjore");  
        }  
        if(current==7)  
        {  
            l.setText("Que7: The First Solar City of India is ? ");  
            jb[0].setText("Anandpur Sahib");jb[1].setText("Mumbai");jb[2].setText("Bangaluru");  
                        jb[3].setText("Delhi");  
        }  
        if(current==8)  
        {  
            l.setText("Que8: ultrasoonic waves are produce by ");  
            jb[0].setText("Pelter's effect");jb[1].setText("piezoelectric effect");jb[2].setText("Doppler effect");  
                        jb[3].setText("Coulomb's effect");         
        }  
        if(current==9)  
        {  
            l.setText("Que9: Who was the architect who designed TAJ MAHAL?");  
            jb[0].setText("Mohammmad Hussain");jb[1].setText("Ustad-isa");jb[2].setText("Shah Abbas");jb[3].setText("Ismail");  
        }  
        if(current==10)  
        {  
            l.setText("Que10: Who Developed the concept of e-mail?");  
            jb[0].setText("Bill Gates");jb[1].setText("Arthur C Clark");jb[2].setText("Ray Tomlinson");  
                        jb[3].setText("Sabiir Bhatia");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {                            //Answear are written here
	if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[3].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[2].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[1].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[1].isSelected());  
        if(current==10)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new Kbl("K B L");  
    }  
}