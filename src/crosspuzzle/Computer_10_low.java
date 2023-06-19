package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Computer_10_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {"2", "오", "0", "반", "복", "문", "0", "0", "0", "0","0",
		   			"2", "버", "0", "0", "0", "자", "바", "가", "상", "머","신",
		   			"2", "라", "벨", "0", "배", "열", "0", "0", "속", "0","0",
		   			"2", "이", "0", "0", "0", "0", "0", "0", "0", "0","0",
		   			"2", "딩", "0", "0", "0", "0", "인", "터", "페", "이","스",
		   			"2", "0", "0", "0", "클", "래", "스", "0", "0", "0","레",
		   			"2", "0", "예", "0", "0", "0", "턴", "0", "메", "소","드",
		   			"2", "0", "외", "0", "0", "0", "스", "0", "0", "켓","0",
		   			"2", "0", "처", "0", "0", "형", "변", "환", "0", "0","0",
		   			"2", "0", "리", "스", "너", "0", "수", "0", "0", "0","0",
		   			"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Computer_10_low(String str) {
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
      
      setResizable(false);
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
      JTextArea horizon = new JTextArea("가로\r\n(0,8): 자바 GUI의 컴포넌트 중 하나로 사용자 입장에서 읽는 것은 가능하지만 쓰는 것은 불가능한 오브젝트이다.\r\n" + 
            "(3,10): 어떠한 조건이 만족될 때 까지 반복해서 문장을 수행하는 조건문.\r\n"+
            "(5,9): 자바 바이트 코드를 플랫폼 고유의 기계어로 변환하여 실행하는 가상장치이다.\r\n"+
            "(4,7): 같은 자료형 변수들의 집합\r\n"+
            "(6,6): 상수와 추상 메소드의 집합으로 생성자를 가질 수 없으며 따라서 객체화가 불가능하다.\r\n"+
            "(4,5): 객체를 정의하는 틀 또는 설계도와 같은 의미로 사용된다.\r\n"+
            "(8,4): 자바에서 클래스 내의 함수를 말한다.\r\n"+
            "(5,2): 변수 또는 상수의 타입을 다른 타입으로 변환하는 것을 말한다. \r\n"+ 
            "(2,0): 이벤트 ㅇㅇㅇ란 이벤트가 발생했을 때 그 처리를 담당하는 함수를 가리키며 이벤트 핸들러라고도 한다.");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n(0,10): 상위 클래스가 가지고 있는 메서드를 하위 클래스가 재정의해서 사용하는 것.\r\n"+ 
            "(5,10): 메모리에 저장된 일련의 연속된 문자(character)들의 집합을 의미한다.\r\n" + 
            "(8,9): 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것.\r\n" + 
            "(2,4): 실행 흐름상 오류가 발생했을 때 오류를 그대로 실행시키지 않고 오류에 대응하는 방법을 제시하는 개념이나 하드웨어 구조.\r\n" + 
            "(6,6): 클래스 내에서 선언된 변수로 인스턴스에 종속되어 인스턴스 생성 시마다 새로운 저장공간을 할당하는 변수이다.\r\n" + 
            "(9,4): 컴퓨터 네트워크를 경유하는 프로세스 간 통신의 종착점이다.\r\n" + 
            "(10,6): 어떠한 프로그램 내에서, 특히 프로세스 내에서 실행되는 흐름의 단위를 말한다.");
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
      new Computer_10_low("컴퓨터/10*10/난이도 하");
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