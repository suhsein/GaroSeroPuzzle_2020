package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class History_7_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);

   private final static int NUM = 64; //퍼즐판 칸 수
   private final static int x=8;

   String[] arr = {"2", "이", "성", "계", "0", "박", "정", "희", 
		           "2", "순", "0", "0", "0","0", "종", "0", 
		           "2", "신", "라", "0", "0", "단", "0", "근", 
		           "2", "0", "0", "광", "해", "군", "0", "초", 
		           "2", "0", "0", "0", "0", "0", "0", "고", 
		           "2", "0", "0", "광", "개", "토", "대", "왕", 
		           "2", "0", "0", "종", "0", "0","0", "0",
		           "1", "1", "1", "1", "1", "1", "1", "1"};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public History_7_low(String str) {
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
      JTextArea horizon = new JTextArea("가로 \r\n" + 
      		"(1,7): 조선을 건국한 왕.\r\n" + 
      		"(5,7): 5-16 군사정변을 통해 대통령이 된 군인.\r\n" + 
      		"(1,5): 삼국을 통일한 나라이며 알에서 태어난 박혁거세가 세운 나라.\r\n" + 
      		"(3,4): 인조반정으로 폐위된 왕이자 임진왜란 이후 부국강병 기틀을 다졌다. \r\n" + 
      		"(3,2): 고구려 전성기를 이끈 왕으로 처음으로 독자적 연호를 사용한 왕.");   
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(1,7): 시호로 룽무를 쓰며 난중일기를 쓰신 분으로 옥포대첩, 한산대첩, 명량해전, 노량해전을 이끄신 장군.\r\n" + 
      		"(6,7): 조선 제 2대왕으로 재임 2년후 보위를 이방원에게 양위한 왕.\r\n" + 
      		"(5,5): 우리 민족 최초의 국가인 고조선을 세운 왕 홍익인간 뜻으로 나라를 세우셨다.\r\n" + 
      		"(7,5): 백제시대 전성기를 이끈 왕으로 고국원왕을 살해한 왕.\r\n" + 
      		"(3,2): 고려 왕으로 노비 안검법을 제정한 왕.");
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
      new History_7_low("역사/7*7/난이도 하");
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