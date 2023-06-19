package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class History_10_high extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   JTextField[] tf = new JTextField[NUM];
   Color color = new Color(230,230,250);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {
               "2", "0", "김", "0", "0", "0", "0", "0", "0", "0", "천",
               "2", "숭", "유", "억", "불","0", "0", "0", "0", "0", "태",
               "2", "0", "신", "0", "0", "0", "0", "0", "조", "계", "종",
               "2", "0", "0", "0", "동", "0", "0", "0", "광", "0", "0",
               "2", "선", "0", "경", "국", "대", "전", "0", "조", "0", "0",
               "2", "죽", "0", "0", "통", "0", "0", "0", "0", "0", "0",
               "2", "교", "정", "도", "감", "0","0", "0", "0", "0", "0",
               "2", "0", "동", "0", "0", "위", "정", "척", "사", "운", "동",
               "2", "0", "행", "0", "0", "0", "0", "0", "육", "0", "0",
               "2", "0", "성", "리", "학", "0", "0", "0", "신", "채", "호",
               "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   
   public History_10_high(String str) {
      super(str);//창 이름
      Dimension dim = new Dimension(1000,1000);
      setPreferredSize(dim);
      
    //-----창 가운데 오게하기
      this.setSize(1000,1000);
      Dimension dim1 = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension dim2 = this.getSize();    
      int xpos = (int)(dim1.getWidth()/2-dim2.getWidth()/2);
      int ypos = (int)(dim1.getHeight()/2-dim2.getHeight()/2);
      this.setLocation(xpos,ypos);;
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
            "(1,9): 유교를 숭상하고 불교를 배척한다는 뜻으로 이성게가 조선을 건국하고 펼친 정책.\r\n" + 
            "(8,8): 고려 후기 지줄이 창시한 불교 종파로 정혜상수, 불립문자, 돈오점수 등을 주장하면서 전종을 중심으로 조계종을 창시하였다.\r\n" +
            "(3,6): 조선시대의 기본법전으로 나라를 다스리는 기준이 된 초고의 법전 세조 때 시작하여 성종 때 완성되었다.\r\n" +
            "(1,4): 고려시대 최충헌 이래 무신정권의 최고 정치기관.\r\n" + 
            "(5,3): 조산 말 많은 유생들이 일본을 서양세력과 동일시 하여 오랑캐라 여기면, 그들과 교역하는 것을 반대하는 운동.\r\n" + 
            "(2,1): 중국 송,명나라 때 학자들에 의하여 성립된 학설로 고려 말에 이 학문이 들어와 성균관 유학자들에게 수용되어 조선이 국시로 유교를 삼는 것에 원돌력이 되었다. 이 학문에 대표적인 학자로 이율곡 이퇴계가 있다.\r\n" + 
            "(8,1): 일제강점기 독립운동가이자 민족사관을 수립하고 한국 근대사학의 기초를 확립한 인물로 조선혁명선언을 짓고 역사란 '아와 비아의 투쟁'이라는 말을 하신 분.\r\n");

      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
            "(2,10): 멸망한 금관가야 왕족 출신으로 김춘추와 손을 잡고 삼국통일에 중추적인 역할을 담당한 장수.\r\n" + 
            "(10,10): 의천의 해동000으로 의천이 만든 것으로 교관겸수, 내외겸전을 제장하며 교리를 연구하는 이론적인 측면과 참선을 수행하는 실천적인 방법을 아우르고자 한것.\r\n" + 
            "(8,8): 중종반종 후 조정에 출사하여 현량과를 주장하고 위훈삭제 등 개혁정시를 단행한 인물로 기묘사화로 인해 쫓겨난 인물.\r\n" + 
            "(4,7): 조선 초기 역사서로 서거정 등이 성종에 왕명을 받아 고조선부터 고려까지의 역사를 엮은 사서.\r\n" + 
            "(6,1): 북한 황해도에 있는 돌다리로 정몽주가 피살된 장소이다.\r\n" +
            "(2,4): 고려 후기 원나라가 일본 정벌을 위해 개경에 설치했던 기구.\r\n"+
            "(8,3): 계유정난으로 권력을 잡은 세조를 몰아내고 단종을 다시 임금으로 받들려다 목숨을 잃은 6명의 충신을 이르는 말.");

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
      new History_10_high("역사/10*10/난이도 하");
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