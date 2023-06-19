package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class History_5_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   Color color = new Color(230,230,250);
  // Color color1 = new Color(136,206,250);

   private final static int NUM = 36; //퍼즐판 칸 수
   private final static int x=6;

   String[] arr = {"2", "고", "인", "돌", "0", "문",
               "2", "0", "조", "0", "0", "무",
               "2", "0", "0", "0", "0", "비",
               "2", "세", "종", "대", "왕", "0",
               "2", "조", "0", "0", "0", "0",
               "1", "1", "1", "1", "1", "1",};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   JTextField[] tf = new JTextField[NUM];
   
   public History_5_low(String str) {
      super(str);//창 이름
      Dimension dim = new Dimension(700,600);
      setPreferredSize(dim);
      
    //-----창 가운데 오게하기
      this.setSize(700,600);
      Dimension dim1 = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension dim2 = this.getSize();    
      int xpos = (int)(dim1.getWidth()/2-dim2.getWidth()/2);
      int ypos = (int)(dim1.getHeight()/2-dim2.getHeight()/2);
      this.setLocation(xpos,ypos);
      
      Font font = new Font("arian",Font.BOLD,40);
      
      
      for(int i = 0; i < NUM; i++) {
         
         if(arr[i] == "0") {
            tf[i] = new JTextField(2);//(2)이게 텍스트필드 크기를 조절하는 중
            tf[i].setBackground(Color.lightGray);
            tf[i].setEditable(false);
            tf[i].setFont(font);
         }
         else if(arr[i]=="1") {
           tf[i] = new JTextField(2);
            tf[i].setText(String.valueOf(i-(NUM-x)));
            tf[i].setBackground(Color.black);
            tf[i].setForeground(Color.WHITE);
            tf[i].setEditable(false);
         }
         else if(arr[i]=="2") {
            tf[i] = new JTextField(2);
            tf[i].setBackground(Color.black);
           tf[i].setForeground(Color.WHITE);
           tf[i].setEditable(false);
           if(i==0) {
              tf[i].setText(String.valueOf(x-1));
           }
           else if(i%6==0) {
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
      
      for(int j = 0; j < 6; j++) {
         for(int k = 0; k < 6; k++) {
         gbAdd(tf[i],k,j); //height랑 width 조절하면 이상해지는 문제
         i++;
         }
      }
      
      //---------설명판
      panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
      JTextArea horizon = new JTextArea("가로\r\n(1,5): 청동기 시대의 대표적인 무덤\r\n" + 
              "(2,2): 한글을 창제한 조선 제 4대 왕\r\n" +
              "(1,1): 사도세자 아들로 수원화성을 건립한 조선 제 22대 왕");
      
      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n(2,5): 조선 제 16대 왕으로 00반정을 일으켜 광해군을 몰아내고 왕이된 왕\r\n" + 
              "(5,4): 신라 왕으로 삼국을 통일한 왕이다.\r\n" + 
              "(2,2): 조선 제 7대 왕으로 조카인 단종을 죽이고 왕이된 왕.\r\n" );
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
      new History_5_low("역사/5*5/난이도 하");
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