package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Science_7_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 64; //퍼즐판 칸 수
   private final static int x=8;

   String[] arr = {"2", "0", "제", "0", "0", "0", "화", "산",
		   	       "2", "0", "주", "기", "율","표", "0", "소",
		   		   "2", "독", "도", "0", "0", "0", "0", "0",
		   		   "2", "0", "0", "0", "0", "0", "태", "풍",
		   	   	   "2", "북", "극", "0", "0", "0", "0", "력",
		   		   "2", "반", "0", "0", "0", "줄", "0", "발",
		   		   "2", "구", "0", "정", "전", "기", "0", "전",
		   		   "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Science_7_low(String str) {
      super(str);//창 이름
      Dimension dim = new Dimension(700,750); //
      setPreferredSize(dim);
      
      //-----창 가운데 오게 하기
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
      JTextArea horizon = new JTextArea("가로\r\n" + 
      		"(1,3): 북반구에서 지구의 자전축과 지구 표면이 만나는 지점으로, 북극해에 위치한다.\r\n" + 
      		"(1,5): 경상북도 울릉군에 속하는 화산섬\r\n" + 
      		"(2,6): 원소를 성질이 비슷한 것끼리 한 줄이 되도록 배열한 도표\r\n" + 
      		"(3,3): 전하가 정지 상태에 있어 흐르지 않고 머물러 있는 전기로, 겨울에 잘 발생한다.+ \r\n" + 
      		"(5,4): 자연재해의 한 종류로, 폭풍우를 수반하는 맹렬한 열대 저기압을 뜻한다.\r\n" + 
      		"(5,7): 땅속에 있는 가스, 마그마 따위가 지각의 터진 틈을 통하여 지표로 분출하는 산");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(1,3): 적도를 경계로 지구를 둘로 나누었을 때의 북쪽 부분\r\n" + 
      		"(2,7): 제주특별자치도의 중심부를 이루는 우리나라 최대의 화산섬\r\n" + 
      		"(5,2): 식물에서 잎을 지탱하고 있는 기둥의 역할을 하는 것\r\n" + 
      		"(7,4): 바람을 이용하여 전기를 만들어 내는 것.\r\n" + 
      		"(7,7): 산소 원소로 만들어진 이원자 분자");
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
      new Science_7_low("과학/7*7/난이도 하");
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