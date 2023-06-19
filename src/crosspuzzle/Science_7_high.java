package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Science_7_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 64; //퍼즐판 칸 수
   private final static int x=8;

   String[] arr = {"2", "0", "하", "이", "드", "레", "이", "트",
		   		   "2", "0", "0", "슬", "0", "0", "자", "0",
		   		   "2", "0", "0", "점", "0", "0", "액", "체",
		   		   "2", "0", "해", "0", "기", "0", "0", "세",
		   		   "2", "증", "발", "0", "공", "변", "세", "포",
		   		   "2", "0", "고", "0", "0", "0", "0", "분",
		   		   "2", "0", "도", "0", "0", "0", "잠", "열",
		   		   "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Science_7_high(String str) {
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
      JTextArea horizon = new JTextArea("가로\r\n" + 
      		"(1,3): 끓는점 미만의 온도에서 액체 표면의 원자나 분자가 기화하는 현상\r\n" + 
      		"(2,7): 독도에 있는 천연자원. 메탄OOOOOO.\r\n" + 
      		"(4,3): 식물의 기공을 이루고 있는 두 개의 세포\r\n" + 
      		"(6,1): 고체가 액체로, 액체가 기체로 변할 때, 온도 상승의 효과를 나타내지 않고 단순히 물질의 상태를 바꾸는 데 쓰는 열\r\n" + 
      		"(6,5): 일정한 형태를 가지지 못한 물질. 구성하는 분자나 원자의 간격이 기체의 경우보다 좁고, 고체에 비해 응집력이 약하다.");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(2,4): 평균 해수면을 기준으로 하여 잰 어떤 지점의 높이\r\n" + 
      		"(3,7): 대기의 온도가 낮아져서 수증기가 응결하기 시작할 때의 온도\r\n" + 
      		"(4,4): 식물체 내부와 외부 사이에 기체 교환이 일어나는 곳\r\n" + 
      		"(6,7): 이자에서 분비하는 소화 효소를 포함한 맑은 알칼리 액체\r\n" + 
      		"(7,5): 세포의 분열 과정에서 유전체의 양이 변하지 않는 체세포가 행하는 세포 분열");
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
      new Science_7_high("과학/7*7/난이도 상");
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