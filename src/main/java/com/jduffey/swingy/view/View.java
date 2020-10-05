package swingy.view;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;
//import java.awt.GridConstraints;  
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;
import swingy.view.SelectHero;
import swingy.model.heroes.Hero;
import swingy.model.LoadHero;
import java.util.ArrayList;
import swingy.model.NewHero;
import swingy.controller.Controller;
    
public class View extends JFrame implements ActionListener{
  public  Hero hero;
  NewHero newHero = new NewHero();
  Controller controller = new Controller();
  JPanel cards;
      private int currentCard = 1;
      private CardLayout cl;
         JButton select = new JButton("Select Hero");
         JButton nHero = new JButton("New Hero");
         JButton back = new JButton("Back");
         JButton back1 = new JButton("Back");
         JButton start = new JButton("Start");
         JButton left = new JButton("left");
         JButton right = new JButton("Right");
         JButton up = new JButton("Up");
         JButton down = new JButton("Down");

         JButton fight = new JButton("Fight");
         JButton run = new JButton("Run");
         JButton exit = new JButton("Exit");

         JTextField t1 = new JTextField("");
         JLabel hName = new JLabel("Hero Name:");
         JLabel hClass = new JLabel("Hero Class:");
         String[] classes = {"Warrior", "Rogue", "Hunter"};
         JComboBox cbClass = new JComboBox(classes);
         JButton createHero = new JButton("Create Hero");

      //Select Hero-
        LoadHero loadhero = new LoadHero();
        String heroes[] = loadhero.getSaved();
         JComboBox cb = new JComboBox(heroes);
         JTextArea area = new JTextArea();
         JTextArea info = new JTextArea("");
         JTextArea stats = new JTextArea();
        CardLayout card;
        Container c; 
    public View(){
   
        JPanel cardPanel = new JPanel(); 

        cl = new CardLayout(); 
        cardPanel.setLayout(cl); 
        JPanel jp1 = new JPanel(); 
        JPanel jp2 = new JPanel();  
        JPanel jp3 = new JPanel();
        JPanel jp4 = new JPanel();
        GridLayout gl2 = new GridLayout(4,1);
        jp2.setLayout(gl2); 
        GridLayout gl3 = new GridLayout(5,2);
        jp3.setLayout(gl3); 
        GridLayout gl4 = new GridLayout(6,1);
        jp4.setLayout(gl4);

        area.setEditable(false);
        info.setEditable(false);
        stats.setEditable(false);
        fight.setVisible(false);
        run.setVisible(false);
        info.setMinimumSize(new Dimension(2, 2));
        jp1.add(select);
        jp1.add(nHero);

        jp2.add(cb); 
        jp2.add(area);
        jp2.add(start);
        jp2.add(back);

        jp3.add(up);
        jp3.add(down);
        jp3.add(left);
        jp3.add(right);
        jp3.add(info);
        jp3.add(stats);
        jp3.add(fight);
        jp3.add(run);
        jp3.add(exit);

        jp4.add(hName);
        jp4.add(t1);
        jp4.add(hClass);
        jp4.add(cbClass);
        jp4.add(createHero);
        jp4.add(back1);


        cardPanel.add(jp1, "1"); 
        cardPanel.add(jp2, "2"); 
        cardPanel.add(jp3, "3"); 
        cardPanel.add(jp4, "4"); 

        up.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                info.setText(controller.moveGui("up"));
                if (controller.checkVilHP()){
                  fight.setVisible(true);
                  run.setVisible(true);
                  up.setVisible(false);
                  down.setVisible(false);
                  left.setVisible(false);
                  right.setVisible(false);
                }
            }
        });

        down.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                info.setText(controller.moveGui("down"));
                if (controller.checkVilHP()){
                  fight.setVisible(true);
                  run.setVisible(true);
                  up.setVisible(false);
                  down.setVisible(false);
                  left.setVisible(false);
                  right.setVisible(false);
                }
            }
        });

        left.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                info.setText(controller.moveGui("left"));
                if (controller.checkVilHP()){
                  fight.setVisible(true);
                  run.setVisible(true);
                  up.setVisible(false);
                  down.setVisible(false);
                  left.setVisible(false);
                  right.setVisible(false);
                }
            } 
        });

        right.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                info.setText(controller.moveGui("right"));
                if (controller.checkVilHP()){
                  fight.setVisible(true);
                  run.setVisible(true);
                  up.setVisible(false);
                  down.setVisible(false);
                  left.setVisible(false);
                  right.setVisible(false);
                }
            } 
        });

        select.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                currentCard = 2; 
                cl.show(cardPanel, "" + (currentCard));
            } 
        });

        start.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
              if ((String) cb.getSelectedItem() != "Select Hero"){
                stats.setText(controller.selectedHeroGui((String) cb.getSelectedItem()));
                info.setText(controller.getPlayerPos());
                currentCard = 3; 
                cl.show(cardPanel, "" + (currentCard));
              }
              else{
                showMessageDialog(null, "Please choose a character!");
              }
            } 
        });

        back.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                currentCard = 1; 
                cl.show(cardPanel, "" + (currentCard));
            } 
        });

        back1.addActionListener(new ActionListener()  
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                currentCard = 1; 
                cl.show(cardPanel, "" + (currentCard));
            } 
        });

        nHero.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
                currentCard = 4; 
                cl.show(cardPanel, "" + (currentCard));
            } 
        });

        createHero.addActionListener(new ActionListener()  
        {
            public void actionPerformed(ActionEvent arg0)
            {
              String tryname = t1.getText();
              if (!tryname.matches("^[a-zA-Z]*$")) { 
                showMessageDialog(null, "Name is invalid please only use letters");
              }
              else {
                boolean check = controller.newHeroGui(t1.getText(), (String) cbClass.getSelectedItem());
                if (check){
                  showMessageDialog(null, "Character name exists. Please use a different name");
                }
                else{
                  stats.setText(controller.selectedHeroGui(null));
                  info.setText(controller.getPlayerPos());
                  currentCard = 3 ;
                  cl.show(cardPanel, "" + (currentCard));
                }
              }
            } 
        });

        cb.addActionListener(e -> {
          if ((!cb.getSelectedItem().equals("Select Hero"))){
            //LoadHero loadhero = new LoadHero();
            String selection = (String) cb.getSelectedItem();
            hero = loadhero.getHeroGui(selection);
            String selected = hero.guiStats();
            area.setText(selected);
          }
          else{
            area.setText("");
          }
        });

        fight.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
               run.setVisible(false);
               String pos = controller.getPlayerPos();
               String txt = controller.fightVil();
               if (txt == null){
                 txt = "You have defeated the enemy!";
                 hero = controller.updateHero();
                 showMessageDialog(null, hero.heroLeveled());
               }
               info.setText(pos + txt);
               if (controller.checkVilDead()){
                  fight.setVisible(false);
                  run.setVisible(false);
                  up.setVisible(true);
                  down.setVisible(true);
                  left.setVisible(true);
                  right.setVisible(true);
                  stats.setText(controller.updateStats());
                }
               
            } 
        });

        exit.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
              controller.saveExit();
            } 
        });

        run.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent arg0) 
            { 
              String playerPos = controller.getPlayerPos();
              String text = controller.run();
              if (text == null){
                run.setVisible(false);
                info.setText(playerPos + "You have failed to escape\nYou must fight!");
              }
              else{
                info.setText(playerPos + text);
                fight.setVisible(false);
                run.setVisible(false);
                up.setVisible(true);
                down.setVisible(true);
                left.setVisible(true);
                right.setVisible(true);
              }
            } 
        });

  
        // used to get content pane 
        getContentPane().add(cardPanel, BorderLayout.NORTH); 
        setLocation(750, 350);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // pack();
    }

     public void actionPerformed(ActionEvent e) {  
      card.next(c);  
    }

    public void updatePos(){

    }

    public void updateTextArea(String data){
      //area.setText(data);
    }

    public void updateStats(String data){

    }

    public void setInfoPanel(String text){
      info.setText(text);
    }

    public JTextArea getInfoPanel() {
      return info;
    }

    public void victory(){
      fight.setVisible(false);
      run.setVisible(false);
      up.setVisible(true);
      down.setVisible(true);
      left.setVisible(true);
      right.setVisible(true);
    }
}