package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Science_10_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);
   
   private static final Insets insets = new Insets(0, 0, 0, 0);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {"2", "영", "0", "0", "0", "0", "0", "시", "0", "0","0",
		   		   "2", "구", "0", "0", "0", "0", "0", "베", "0", "0", "0",
		   		   "2", "조", "경", "수", "역", "0", "0", "리", "보", "솜", "0",
		   		   "2", "직", "0", "0", "암", "모", "니", "아", "0", "0", "상",
		   		   "2", "0", "0", "0", "0", "세", "0", "0", "0", "0", "대",
		   		   "2", "삼", "0", "0", "적", "혈", "구", "0", "염", "기", "성",
		   		   "2", "엽", "록", "체", "0", "관", "0", "0", "색", "0", "이",
		   		   "2", "충", "0", "0", "0", "0", "0", "0", "체", "0", "론",
		   		   "2", "0", "온", "대", "저", "기", "압", "0", "0", "0", "0",
		   		   "2", "0", "0", "0", "0", "화", "0", "0", "0", "0", "0",
		   		   "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public Science_10_high(String str) {
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
      JTextArea horizon = new JTextArea("가로\r\n" + 
      		"(1,4): 식물세포 내 소기관의 한 종류이며, 광합성을 담당한다.\r\n" + 
      		"(1,8): 한류와 난류가 교차하는 영역을 말한다.\r\n" + 
      		"(2,2): 온대성 저기압이라고도 하며, 중위도 지역에서 자주 발생하는 저기압으로, 한랭 전선과 온난 전선을 동반하는 저기압.\r\n" + 
      		"(3,5): 혈액 속에 들어 있는 붉은색의 고형 성분으로, 주로 골수에서 만들어진다.\r\n" + 
      		"(3,7): 질소와 수소의 화합물. 자극적인 냄새가 나는 무색의 기체.\r\n" + 
      		"(7,8): 단백질을 합성하는 세포소기관\r\n" + 
      		"(8,5): 염기가 지니고 있는 기본적인 성질");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(1,5): 절지동물문 삼엽충류 화석 동물을 통틀어 이르는 말\r\n" + 
      		"(1,10): 식물의 조직 중 세포 분열 능력을 상실한 조직\r\n" + 
      		"(4,8): 퇴적물이 주로 하천,호수 또는 얕은 바다에 쌓여서 굳어진 암석으로 자갈이 많다.\r\n" + 
      		"(5,2): 액체 상태의 물질이 기체 상태로 바뀌는 현상\r\n" + 
      		"(5,7): 온몸의 조직에 그물 모양으로 퍼져 있는 매우 가는 혈관\r\n" + 
      		"(7,10): OOOO기단은 겨울철에 발생하는 대륙성 한랭기단이다.\r\n" + 
      		"(8,5): 염색사가 나사 모양으로 몇 겹으로 꼬여서 두껍게 된 것\r\n" + 
      		"(10,7): 아인슈타인이 시간과 공간이 상대적임을 밝힌 이론.");
      
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
      new Science_10_high("과학/10*10/난이도 상");
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