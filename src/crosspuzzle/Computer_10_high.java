package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Computer_10_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);
   
   private static final Insets insets = new Insets(0, 0, 0, 0);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {"2", "0", "0", "0", "0", "서", "버", "0", "0", "0","0",
		   			"2", "0", "0", "0", "0", "블", "0", "정", "보", "은","닉",
		   			"2", "0", "0", "애", "플", "릿", "0", "0", "안", "0", "0",
		   			"2", "0", "0", "플", "0", "0", "다", "형", "성", "0", "0",
		   			"2", "크", "0", "리", "0", "0", "0", "식", "0", "0", "0",
		   			"2", "리", "0", "케", "0", "패", "키", "지", "0", "0", "0",
		   			"2", "티", "0", "이", "0", "0", "0", "정", "적", "변", "수",
		   			"2", "컬", "렉", "션", "0", "직", "0", "자", "0", "0", "0",
		   			"2", "섹", "0", "0", "0", "렬", "0", "0", "포", "0", "0",
		   			"2", "션", "0", "캡", "슐", "화", "0", "네", "트", "워", "크",
		   			"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Computer_10_high(String str) {
      super(str);//창 이름
      Dimension dim = new Dimension(1000,1000);
      setPreferredSize(dim);
      
    //-----창 가운데 오게하기
      this.setSize(1000,1000);
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
      JTextArea horizon = new JTextArea("가로\r\n(5,10): 클라이언트에게 네트워크를 통해 정보나 서비스를 제공하는 컴퓨터 시스템.\r\n" + 
            "(6,9): 코드 내부 데이터와 메서드를 숨기고 공개 인터페이스를 통해서만 접근이 가능하도록 하는 코드 보안 기술\r\n"+
            "(3,7): Java 언어로 구성된 작은 응용 프로그램으로 웹브라우저에서만 실행 가능하다.\r\n"+
            "(6,7): 하나의 메소드나 클래스가 있을 때 이것들이 다양한 방법으로 동작하는 것을 의미한다.\r\n"+
            "(5,5): 서로 관련이 있는 클래스 또는 인터페이스들을 묶어 놓은 묶음이다.\r\n"+
            "(6,4): 정적으로 할당되는 변수이며, 프로그램 실행 전반에 걸쳐 변수의 수명이 유지된다. \r\n"+
            "(0,3): '목록성 데이터를 처리하는 자료구조'를 통칭한다. \r\n"+
            "(3,0): 필요한 속성(Attribute) 와 행위(Method) 를 하나로 묶고 그중 일부를 외부에서 사용하지 못하도록 은닉하는 것.\r\n"+
            "(6,4): 컴퓨터들이 통신 기술을 이용하여 그물망처럼 연결된 통신 이용 형태.");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n(0,6): 둘 이상의 쓰레드가 동시에 실행될 경우 생길 수 있는 동시 접근 문제를 발생시킬 수 있는 코드 블록.\r\n"+ 
            "(3,7): 운영체제에서 실행되는 모든 소프트웨어.\r\n" + 
            "(5,10): 자바 플랫폼에서 컴포넌트를 기반으로 한 웹 애플리케이션을 개발할 때 사용하는 핵심 기술이다.\r\n" + 
            "(7,9): 자바는 몇 가지 보안 메커니즘을 구현하여 잘못된 프로그램으로 인해 생기는 피해를 막아주도록 설계되어 있기 때문에 ㅇㅇㅇ이 높다.\r\n"+
            "(7,7): 어떠한 값을 출력 및 입력할 때 그 값이 정수인지 문자인지 실수인지를 컴퓨터에게 알려주는 문자를 말한다.\r\n" + 
            "(5,3): 객체의 내용을 바이트 단위로 변환하여 파일 또는 네트워크를 통해서 스트림(송수신)이 가능하게 하는것을 의미한다.\r\n"+
            "(8,2): 인터넷 프로토콜 스위트에서 운영 체제 통신의 종단점을 말한다.");
      
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
      new Computer_10_high("컴퓨터/10*10/난이도 상");
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