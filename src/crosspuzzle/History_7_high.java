package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class History_7_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 64; //퍼즐판 칸 수
   private final static int x=8;

   String[] arr = { "2", "5", "16", "0", "0", "0", "을", "사", 
		   			"2", "18", "0", "0", "생","0", "미", "0", 
		   			"2", "0", "0", "0", "육", "0", "의", "0", 
		   			"2", "0", "0", "갑", "신", "정", "변", "0", 
		   			"2", "0", "0", "오", "0", "0", "0", "호", 
		   			"2", "광", "무", "개", "혁", "0", "0", "패", 
		   			"2", "0", "0", "혁", "0", "균","역", "법", 
		   			"1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public History_7_high(String str) {
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
      		"(1,7): 0월00일에 박정희 소장이 군사 정변을 일으켜 권력을 잡은 사건\r\n" + 
      		"(6,7): 00늑약이라고 한다 일본이 강제로 대한제국의 외교권을 빼앗기 위해 체결한 조약\r\n" + 
      		"(3,4): 김옥균을 비롯한 급진개화파가 일으킨 정변\r\n" + 
      		"(1,2): 대한제국이 완전한 자주적 독립권을 지켜 나가기 위해서 러일전쟁이 일어난 1904년까지 자주적으로 단행한 내정개혁\r\n" + 
      		"(5,1): 조선 후기 영조 때 군역의 부담을 경감하기 위하여 만든 세법");    
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(1,7): 0월00일에 광주 시민들이 벌인 민주화운동이다. 정변을 일으켜 정권을 차지한 신군부 세력과 계엄령에 반대하고 민주화를 요구하였다.\r\n" + 
      		"(3,4): 고종 때 근대화 하기 위한 목적으로 시행한 것으로 이것을 통해 신분제가 폐지되고 공식문서에 한글을 사용하고 과부의 재혼이 허가 되고 많은 학교가 세워졌다.\r\n" + 
      		"(4,6): 세조가 단종의 왕위를 빼앗자 벼슬을 버리고 절개를 지킨 여섯 명의 신하로 김시습,원호,이맹전,조려,성담수,남효은이다.\r\n" + 
      		"(6,7): 조선 말기 최초의 대규모 항일의명, 명성황후 민씨 시해사건과 단발령의 강제시행에 분격한 유생들이 친일내각의 타도와 일본세력의 구축을 목표로 일으켰다. \r\n" + 
      		"(7,3): 태종 떄 처음실시한 제도롤 16세 이상의 양인 남자에게 호패를 가지고 다니게 하던 제도");
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
      new History_7_high("역사/7*7/난이도 상");
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