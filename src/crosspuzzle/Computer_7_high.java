package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Computer_7_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 64; //퍼즐판 칸 수
   private final static int x=8;

   String[] arr = {"2", "0", "0", "버", "퍼", "스", "트", "림",
		   			"2", "레", "0", "0", "0","레", "0", "0",
		   			"2", "이", "벤", "트", "0", "드", "0", "라",
		   			"2", "아", "0", "라", "0", "동", "0", "이",
		   			"2", "웃", "0", "이", "0", "기", "0", "브",
		   			"2", "0", "0", "캐", "0", "화", "0", "러",
		   			"2", "0", "0", "치", "0", "0", "트", "리",
		   			"1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Computer_7_high(String str) {
      super(str);//창 이름
      Dimension dim = new Dimension(700,750);
      setPreferredSize(dim);
      
    //-----창 가운데 오게하기
      this.setSize(700,750);
      Dimension dim1 = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension dim2 = this.getSize();    
      int xpos = (int)(dim1.getWidth()/2-dim2.getWidth()/2);
      int ypos = (int)(dim1.getHeight()/2-dim2.getHeight()/2);
      this.setLocation(xpos,ypos);
      
      Font font = new Font("arian",Font.BOLD,40);
      
      
      for(int i = 0; i < NUM; i++) {
         
         if(arr[i] == "0") {
            tf[i] = new JTextField(2);
            tf[i].setBackground(Color.lightGray);
            tf[i].setEditable(false);
            tf[i].setFont(font);
         }
         else if(arr[i]=="1") {
    		 tf[i] = new JTextField(2);
        	 tf[i].setText(String.valueOf(i-(NUM-x)));
        	 tf[i].setBackground(Color.BLACK);
        	 tf[i].setForeground(Color.WHITE);
        	 tf[i].setEditable(false);
         }
         else if(arr[i]=="2") {
        	 tf[i] = new JTextField(2);
        	 tf[i].setBackground(Color.BLACK);
    		 tf[i].setForeground(Color.WHITE);
    		 tf[i].setEditable(false);
    		 if(i==0) {
    			 tf[i].setText(String.valueOf(x-1));
    		 }
    		 else if(i%x==0) {
        	     tf[i].setText(String.valueOf(x-(i/x)-1));
        	 }
        	 else {
        		 tf[i].setText(String.valueOf(i));
        	 }

         }
         else {
         tf[i] = new JTextField(2);
         tf[i].setFont(font);
         }
      } //문자가 비어있으면 입력제한 및 배경색 검정색
   
      gBag = new GridBagLayout(); 
      ppanel.setLayout(gBag);
      gbc = new GridBagConstraints();
      gbc.fill= GridBagConstraints.BOTH;     
      
      int i = 0;
      
      for(int j = 0; j < x; j++) {
         for(int k = 0; k < x; k++) {
         gbAdd(tf[i],k,j); //height랑 width 조절하면 이상해지는 문제
         i++;
         }
      }
      
      //---------설명판
      panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
      JTextArea horizon = new JTextArea("가로\r\n(3,7): 데이터 입출력시 한 바이트가 아니라 주어진 사이즈 만큼의 버퍼 크기대로 한번에 출력할 수 있는 클래스이다.\r\n" + 
            "(0,5): 어떤 특정한 행동이 발생한 그 자체를  말한다. ㅇㅇㅇ핸들러를 통해 처리한다.\r\n"+
            "(6,0): 노드로 이루어진 자료 구조.\r\n");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n(0,6): GUI에서 컴포넌트를 배치하는 방식이다.\r\n"+ 
            "(3,5): 예외를 처리하는 문장으로, 발생한 예외를 throw해서 어떻게 처리할 지에 대한 내용을 담는다.\r\n" + 
            "(5,7): 멀티 스레드 환경에서  하나의 실행 중인 스레드가 완전히 종료 된 후 다음 스레드가 동작할 수 있도록 구현하는 것\r\n" + 
            "(7,5): 주로 소프트웨어를 개발할 때 컴퓨터 프로그램이 사용하는 비휘발성 자원의 모임이다.");
      panel2.add(vertical);
      
      //----------버튼
      JButton answer = new JButton("정답");
      Compare listener = new Compare();
      answer.addActionListener(listener); 
      panel1.add(answer);
      
      //-----패널들을 최종 패널에 세로 정렬
      lastpanel.setLayout(new BoxLayout(lastpanel,BoxLayout.Y_AXIS));
      lastpanel.add(ppanel);
      lastpanel.add(panel1);
      lastpanel.add(panel2);
      add(lastpanel, BorderLayout.CENTER);
      vertical.setLineWrap(true); //자동 줄바꿈
      horizon.setLineWrap(true);
      vertical.setEditable(false); //수정 금지
      horizon.setEditable(false);
      
      this.pack();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
   
   
   
   public void gbAdd(Component c, int x, int y){
       gbc.gridx = x;
       gbc.gridy = y;
       gBag.setConstraints(c,gbc);
       ppanel.add(c);       
       }
      
   public static void main(String[] args) {   
      new Computer_7_high("컴퓨터/7*7/난이도 상");
   }

   class Compare implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         for(int i=0; i<NUM; i++)
         {
            if(arr[i] != "0" && arr[i] != "1" && arr[i] != "2") {
               if(arr[i].equals(tf[i].getText()))
               {
                  tf[i].setBackground(color);
                  tf[i].setEditable(false);
               }
            }
         }
      }
   }

}