package crosspuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Science_10_low extends JFrame {
   JPanel ppanel=new JPanel();
   JPanel panel1 = new JPanel();
   JPanel panel2 = new JPanel();
   JPanel lastpanel = new JPanel();
   JTextField[] tf = new JTextField[NUM];
   
   private static final Insets insets = new Insets(0, 0, 0, 0);

   private final static int NUM = 121; //퍼즐판 칸 수
   private final static int x=11;

   String[] arr = {
               "2", "0", "0", "대", "0", "0", "0", "0", "0", "0", "빅",
               "2", "열", "대", "기", "후","0", "0", "0", "0", "0", "뱅",
               "2", "매", "0", "0", "0", "0", "석", "0", "0", "0", "이",
               "2",  "0", "망", "0", "자", "0", "회", "0", "진", "화", "론",
               "2", "0", "원", "0", "석", "굴", "암", "0", "0", "0", "0",
               "2", "0", "경", "도", "0", "절", "0", "0", "소", "0", "0",
               "2", "천", "0", "0", "0", "0","이", "산", "화", "탄", "소",
               "2", "연", "0", "0", "0", "0", "0", "0", "0", "수", "0",
               "2", "자", "외", "선", "0", "0", "0", "뿌", "0", "화", "0",
               "2", "원", "0", "0", "0", "0", "머", "리", "0", "물", "0",
               "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",};
   
   GridBagLayout gBag;
   GridBagConstraints gbc;
   
   public Science_10_low(String str) {
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
             tf[i].setBackground(Color.GRAY);
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
      		"(1,2): 가시광선보다 짧은 파장으로 눈에 보이지 않는 빛. 사람의 피부를 태우거나 살균작용을 한다.\r\n" + 
      		"(1,9): 일 년 내내 매우 덥고 비가 많이 오는 열대 지방의 기후\r\n" + 
      		"(2,5): 지구 위의 위치를 나타내는 좌표축 중에서 세로로 된 것\r\n" + 
      		"(4,6): 경상북도 경주시에 있는, 우리나라의 대표적인 석굴 사원\r\n" + 
      		"(6,1): 곤충의 외부형태 분류-OO, 가슴, 배\r\n" + 
      		"(6,4): 탄소의 산화물. 탄소가 완전 연소를 할 때 생기는 무색 기체(CO2)\r\n" + 
      		"(8,7): 생물은 진화하는 것이라는 주장");

      panel2.add(horizon);
      
      JTextArea vertical = new JTextArea("세로\r\n" + 
      		"(1,4): 천연적으로 존재하여 인간 생활이나 생산 활동에 이용할 수 있는 자원\r\n" + 
      		"(1,9): 식물이 수정한 후 씨방이 자라서 생기는 것. 대개는 이 속에 씨가 들어 있다\r\n" + 
      		"(2,7): 멀리 있는 물체를 크고 정확하게 보게 하는 것\r\n" + 
      		"(3,10): ‘공기’의 다른 말. 천체를 둘러싸고 있는 기체.\r\n" + 
      		"(4,7): 쇳조각을 끌어당기는 물질. N극과 S극으로 이루어짐.\r\n" + 
      		"(5,6): 한 매질에서 다른 매질로 들어갈 때 경계면에서 그 진행 방향이 바뀌는 현상\r\n" + 
      		"(6,8): 탄산 칼슘을 주성분으로 하는 퇴적암. 조개 껍질이나 산호 등 생물의 파편으로 이루어짐.\r\n" + 
      		"(7,2): 주로 지면 아래에 있는 식물 기관\r\n" + 
      		"(8,5): 섭취한 음식물을 분해하여 영양분을 흡수하기 쉬운 형태로 변화시키는 일\r\n" + 
      		"(9,4): 삼대 영양소 가운데 하나로, 녹색식물의 광합성으로 생긴다.\r\n" + 
      		"(10,10): 우주가 대폭발로 형성되었다고 주장하는 이론");

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
      new Science_10_low("과학/10*10/난이도 하");
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
                   tf[i].setBackground(Color.yellow);
                   tf[i].setEditable(false);
                }
             }
          }
      }
   }

}