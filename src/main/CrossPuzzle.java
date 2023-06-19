package main;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import crosspuzzle.Computer_10_high;
import crosspuzzle.Computer_10_low;
import crosspuzzle.Computer_5_high;
import crosspuzzle.Computer_5_low;
import crosspuzzle.Computer_7_high;
import crosspuzzle.Computer_7_low;
import crosspuzzle.History_10_high;
import crosspuzzle.History_10_low;
import crosspuzzle.History_5_high;
import crosspuzzle.History_5_low;
import crosspuzzle.History_7_high;
import crosspuzzle.History_7_low;
import crosspuzzle.Science_10_high;
import crosspuzzle.Science_10_low;
import crosspuzzle.Science_5_high;
import crosspuzzle.Science_5_low;
import crosspuzzle.Science_7_high;
import crosspuzzle.Science_7_low;

import java.awt.*;
import java.awt.event.*;

class f_frame extends JFrame{
   JButton[] buttons=new JButton[3];
   Color color1=new Color(238,225,255);
   Color color2=new Color(61,92,135);
   
   f_frame() {
      setTitle("가로세로 낱말퀴즈");
      setSize(700, 600);
      createMenu();
      setVisible(true);
      setLocationRelativeTo(null);
      this.setResizable(false);
   }
   
   public void createMenu() {
      JLabel Title=new JLabel("가로세로 낱말퀴즈");
      JLabel category=new JLabel("카테고리");

      Container ct=new Container();
      ct.setLayout(new BoxLayout(ct,BoxLayout.Y_AXIS));
         
      Title.setAlignmentX(CENTER_ALIGNMENT);
      category.setAlignmentX(CENTER_ALIGNMENT);
      
      getContentPane().setBackground(color1);
      ct.add(Box.createVerticalGlue());
      ct.add(Title);
      ct.add(category);
      
      Title.setForeground(color2);
      Title.setFont(new Font("맑은 고딕", Font.BOLD, 40));
      category.setForeground(color2);
      category.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
      
      buttons[0]=new JButton("과학");
      buttons[1]=new JButton("컴퓨터");
      buttons[2]=new JButton("역사");
      
      JPanel buttonPanel=new JPanel();
      
      for(int i=0;i<buttons.length;i++) {
         buttons[i].setBackground(new Color(238,201,234));
         buttons[i].addActionListener(new btnclicklistener());
         buttons[i].setAlignmentX(CENTER_ALIGNMENT);
         buttonPanel.add(buttons[i]);
      }
      
      buttonPanel.setBackground(color1);
      ct.add(Box.createVerticalGlue());
      ct.add(buttonPanel, BorderLayout.SOUTH);
      add(ct);
   }
   class btnclicklistener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         JButton b = (JButton)e.getSource();

         new s_frame(b.getText());
      }
   }
}

class s_frame extends JFrame{
   Color color1=new Color(238,225,255);
   Color color2=new Color(61,92,135);
   Color color3=new Color(238,201,234);
   
   public String menu_s;
   public JRadioButton high;
   public JRadioButton low;
   public JRadioButton fiv;
   public JRadioButton sev;
   public JRadioButton ten;
   
   s_frame(String buttoncontent){
      setTitle("가로세로 낱말퀴즈");
      setSize(700,600);
      secondMenu(buttoncontent);
      menu_s=buttoncontent;
      setVisible(true);
      setLocationRelativeTo(null);
      this.setResizable(false);
   }
   public void secondMenu(String buttoncontent) {
       JLabel menu=new JLabel(buttoncontent);
      menu.setAlignmentX(CENTER_ALIGNMENT);
      
      Container con=new Container();
      con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
      
      getContentPane().setBackground(color1);
      
      menu.setForeground(color2);
      menu.setFont(new Font("맑은 고딕", Font.BOLD, 40));
      
      con.add(Box.createVerticalGlue());
      con.add(menu);
      con.add(Box.createVerticalGlue());
      

      JPanel selectpan=new JPanel();
      selectpan.setLayout(new FlowLayout());
      selectpan.setBackground(color1);
      
      JPanel pn1=new JPanel();
      pn1.setBorder(new TitledBorder(null, "난이도",TitledBorder.LEADING,TitledBorder.TOP,null,null));
      pn1.setBackground(color1);
      pn1.setPreferredSize(new Dimension(600,80));
      selectpan.add(pn1);
      
      ButtonGroup group1=new ButtonGroup();
      high=new JRadioButton("상");
      high.setBackground(color1);
      group1.add(high);
      pn1.add(high);
      low=new JRadioButton("하");
      low.setBackground(color1);
      group1.add(low);
      pn1.add(low);
      
      JPanel pn2=new JPanel();
      pn2.setBorder(new TitledBorder(null,"크기",TitledBorder.LEADING, TitledBorder.TOP,null,null));
      pn2.setBackground(color1);
      pn2.setPreferredSize(new Dimension(500,80));
      selectpan.add(pn2);
      
      
      ButtonGroup group2=new ButtonGroup();
      fiv=new JRadioButton("5x5");
      fiv.setBackground(color1);
      group2.add(fiv);
      pn2.add(fiv);
      sev=new JRadioButton("7x7");
      sev.setBackground(color1);
      group2.add(sev);
      pn2.add(sev);
      ten=new JRadioButton("10x10");
      ten.setBackground(color1);
      group2.add(ten);
      pn2.add(ten);
      
      
      con.add(selectpan);
      
      JButton play=new JButton("play");
      play.setPreferredSize(new Dimension(95,60));
      play.setBackground(color3);
      play.addActionListener(new playclicklistener());
      selectpan.add(play);
      
      add(con);
      
   }
   
   class playclicklistener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         if(menu_s=="과학") {
            if(high.isSelected()) {
               if(fiv.isSelected()) {
                  new Science_5_high("과학/5*5/난이도 상"); 
                  }
               else if(sev.isSelected()) {
                  new Science_7_high("과학/7*7/난이도 상"); 
               }
               else if(ten.isSelected()) {
                  new Science_10_high("과학/10*10/난이도 상"); 
               }
            }
            else if(low.isSelected()) {
               if(fiv.isSelected()) {
                  new Science_5_low("과학/5*5/난이도 하"); 
                  }
               else if(sev.isSelected()) {
                  new Science_7_low("과학/7*7/난이도 하"); 
               }
               else if(ten.isSelected()) {
                  new Science_10_low("과학/10*10/난이도 하"); 
               }
            }
         }
         //-------컴퓨터
         else if(menu_s=="컴퓨터")  {
            if(high.isSelected()) {
               if(fiv.isSelected()) {
                  new Computer_5_high("컴퓨터/5*5/난이도 상"); 
                  }
               else if(sev.isSelected()) {
                  new Computer_7_high("컴퓨터/7*7/난이도 상"); 
               }
               else if(ten.isSelected()) {
                  new Computer_10_high("컴퓨터/10*10/난이도 상"); 
               }
            }
            else if(low.isSelected()) {
               if(fiv.isSelected()) {
                  new Computer_5_low("컴퓨터/5*5/난이도 하"); 
                  }
               else if(sev.isSelected()) {
                  new Computer_7_low("컴퓨터/7*7/난이도 하"); 
               }
               else if(ten.isSelected()) {
                  new Computer_10_low("컴퓨터/10*10/난이도 하"); 
               }
            }
         }
         //--------역사
         else if(menu_s=="역사")  {
            if(high.isSelected()) {
               if(fiv.isSelected()) {
                  new History_5_high("역사/5*5/난이도 상"); 
                  }
               else if(sev.isSelected()) {
                  new History_7_high("역사/7*7/난이도 상"); 
               }
               else if(ten.isSelected()) {
                  new History_10_high("역사/10*10/난이도 상"); 
               }
            }
            else if(low.isSelected()) {
               if(fiv.isSelected()) {
                  new History_5_low("역사/5*5/난이도 하"); 
                  }
               else if(sev.isSelected()) {
                  new History_7_low("역사/7*7/난이도 하"); 
               }
               else if(ten.isSelected()) {
                  new History_10_low("역사/10*10/난이도 하"); 
               }
            }
         }
      }
   }
}

public class CrossPuzzle extends JFrame {
   
   public static void main(String args[]) {
      new f_frame();
   }
}