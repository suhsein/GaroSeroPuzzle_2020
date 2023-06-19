package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class History_10_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   JTextField[] tf = new JTextField[NUM];
   Color color = new Color(230,230,250);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {
               "2", "홍", "익", "인", "간", "0", "0", "0", "0", "0", "0",
               "2", "경", "0", "현", "0","0", "0", "0", "0", "0", "0",
               "2", "래", "0", "황", "희", "정", "승", "0", "0", "0", "0",
               "2",  "0", "0", "후", "0", "약", "0", "0", "0", "0", "붕",
               "2", "0", "0", "0", "0", "용", "0", "신", "사", "임", "당",
               "2", "0", "0", "0", "0", "0", "0", "0", "도", "0", "정",
               "2", "수", "0", "0", "0", "0","0", "0", "세", "0", "치",
               "2", "원", "0", "0", "0", "상", "감", "청", "자", "0", "0",
               "2", "화", "0", "0", "0", "0", "0", "나", "0", "0", "0",
               "2", "성", "종", "0", "0", "0", "신", "라", "0", "0", "0",
               "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   
   public History_10_low(String str) {
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
      
      //-----x좌표 y좌표 입력 및 글자 비는 곳 검정색, 수정 불가 처리
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
      
      //------그리드에 퍼즐판 추가
      int i = 0;
      
      for(int j = 0; j < 11; j++) {
         for(int k = 0; k < 11; k++) {
         gbAdd(tf[i],k,j); 
         i++;
         }
      }
      
      //---------설명판
      panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
      JTextArea horizon = new JTextArea("가로\r\n" + 
            "(1,10): 널리 인간세계를 이롭게 한다는 뜻으로 단군신화에 나오는 말이다.\r\n" + 
            "(3,8): 세종 때 우의정, 좌의정, 영의정부사 등을 역임한 문신으로 청백리이자 세종의 가장 신임받는 재상.\r\n" + 
            "(7,6): 조선 중기 예술가로 초충도를 그린 여인이자 율곡 이이의 어머니이다.\r\n" + 
            "(5,3): 고려시대 유물로 00기법으로 만든 청자이다. 반 건조된 그릇 표면에 무늬를 음각하는 방식으로 만든 고려인의 독특한 청자 .\r\n" + 
            "(1,1): 조선 제9대 왕으로 경국대전을 완성하고왕조 발전 토대를 마련한 왕.\r\n" + 
            "(1,6): 삼국을 통일한 나라로 이 나라 최초의 여왕은 선덕여왕이다.\r\n");

      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
            "(1,10): 조선후기 평안도에서 일어난 농민반란의 우두머리로 이 농민반란을 000의 난이라고 한다.\r\n" + 
            "(1,4): 정조 때 지어진 성으로 과학적 기술을 사용하여 지은 성이다.\r\n" + 
            "(3,10): 성은 민씨이고 숙종의 계비로 기사환국 때 폐서인이 되었다가 갑술옥사로 다시 와후에 복위한 인물로 그녀를 주인공으로 하여 궁녀가 쓴 소설<0000전>이 전해진다.\r\n" + 
            "(5,8): 조선후기 목민심서 경세유표 등 500여권을 저술한 유학자이자 실학자로 수원화성을 짓는데 많은 기여릃 한 인물.\r\n" + 
            "(7,3): 중국 대륙의 마지막 왕조로 명나라 이후 세워진 왕조이다.\r\n" +
            "(8,6): 영조 아들이자 정조 아버지로 뒤주에 갇혀 죽은 비극적 삶을 산 인물.\r\n"+
            "(10,7): 조선 중기 정치 운영 형태로 관료들이 서로 파벌을 이루어 정권을 다투던 일을 말한다. 동인, 북인, 서인이 있었다.");

      panel2.add(vertical);
      
      vertical.setLineWrap(true); //자동 줄바꿈
      horizon.setLineWrap(true);
      vertical.setEditable(false); //수정 금지
      horizon.setEditable(false);
      
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
      
      this.pack();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }
   
   
   //------그리드에 퍼즐판 추가 메소드
   public void gbAdd(Component c, int x, int y){
       gbc.gridx = x;
       gbc.gridy = y;
       gBag.setConstraints(c,gbc);
       ppanel.add(c);       
   } 
      
   public static void main(String[] args) {   
      new History_10_low("역사/10*10/난이도 상");
   }
   
   //-----------정답 버튼 이벤트 리스너
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