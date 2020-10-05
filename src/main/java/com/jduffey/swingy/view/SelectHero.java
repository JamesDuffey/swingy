package swingy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// public class SelectHero extends JPanel {        
//     JComboBox cb = new JComboBox();
//     JButton back = new JButton("Back");
//     JButton start = new JButton("Start");
//     JTextArea area=new JTextArea();

//     public JPanel SelectHero(){
//         JPanel selectGui = new JPanel();
//         GridLayout gbLayout = new GridLayout(2, 3);
//         this.setLayout(gbLayout);
//         add(cb);
//         add(back);
//         add(start);
//         add(area);
//         selectGui.setVisible(true);
//         return selectGui;
//     }
// }

public class SelectHero extends JFrame implements ActionListener{  
CardLayout card;  
JButton b1,b2,b3;  
Container c;  
    public void CardLayoutExample(){  
          
        c=getContentPane();  
        card=new CardLayout(40,30);  
//create CardLayout object with 40 hor space and 30 ver space  
        c.setLayout(card);
          
        b1=new JButton("Apple");
        b2=new JButton("Boy");
        b3=new JButton("Cat");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
              
        c.add("a",b1);c.add("b",b2);c.add("c",b3);  
                          
    }  
    public void actionPerformed(ActionEvent e) {  
    card.next(c);  
    }
}