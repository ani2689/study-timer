import javax.swing.*;
import java.awt.*;

public class StudyTimer extends Thread{
    private JPanel timerPanel;
    private JPanel timePanel;
    private JPanel buttonPanel;
    private JButton startButton;
    private JButton endButton;
    private JButton restButton;
    private JButton resetButton;
    private JLabel studyTimeLable;
    private JLabel restTimeLabel;
    private JLabel test1;
    private JLabel text2;
    private JButton exitButton;

    private boolean t=true;
    private boolean f=false;

    private boolean stop=true;

    private boolean studyOn=false;
    private boolean restOn=false;
    private JFrame frame = new JFrame("공부 시계");


    int studyCount=0;
    int restCount=0;

    JButton[] bl={startButton,endButton,restButton,resetButton,exitButton};

    StudyTimer(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        int x = res.width;
        int y = res.height;

        frame.setBounds(280,230,280,230);
        frame.setLocation(x-300,y-300);
        frame.setResizable(false);


        frame.setIconImage(new ImageIcon(StudyTimer.class.getResource("empty.png")).getImage());

        frame.add(timerPanel);

        //frame.setUndecorated(true);
        int blackColor = 50;
        frame.setBackground(new Color(255,255,255,255));
        timerPanel.setBackground(new Color(255,255,255,255));
        timePanel.setBackground(new Color(255,255,255,255));
        buttonPanel.setBackground(new Color(255,255,255,255));

        for(JButton jb: bl){
            jb.setBackground(new Color(blackColor,blackColor,blackColor));
            jb.setForeground(new Color(255,255,255,255));
        }

        bl[0].setVisible(t);
        bl[1].setVisible(f);
        bl[2].setVisible(f);
        bl[3].setVisible(f);
        bl[4].setVisible(t);

        frame.setAlwaysOnTop(true);

        frame.setVisible(t);

        bl[0].addActionListener(e -> {
            bl[0].setVisible(f);
            bl[1].setVisible(t);
            bl[2].setVisible(t);
            bl[3].setVisible(f);
            bl[4].setVisible(f);

            stop=f;

            studyOn=t;
            restOn=f;

            frame.setTitle("공부중...");
            System.out.println("시작");
        });

        bl[1].addActionListener(e -> {
            bl[0].setVisible(f);
            bl[1].setVisible(f);
            bl[2].setVisible(f);
            bl[3].setVisible(t);
            bl[4].setVisible(t);

            stop=t;

            studyOn=f;
            restOn=f;


            frame.setTitle("수고했어요.");
            System.out.println("종료");

        });

        bl[2].addActionListener(e -> {
            bl[0].setVisible(t);
            bl[1].setVisible(t);
            bl[2].setVisible(f);
            bl[3].setVisible(f);
            bl[4].setVisible(f);

            studyOn=f;
            restOn=t;

            frame.setTitle("휴식중...");
            System.out.println("휴식");

        });

        bl[3].addActionListener(e -> {
            bl[0].setVisible(t);
            bl[1].setVisible(f);
            bl[2].setVisible(f);
            bl[3].setVisible(f);
            bl[4].setVisible(t);

            studyCount=0;
            restCount=0;

            frame.setTitle("공부 시계");
            System.out.println("초기화");

        });

        bl[4].addActionListener(e -> {
            System.exit(0);
        });

        start();
    }

    void startTimer(){
    }

    void endTimer(){
    }

    void restTimer(){
    }

    void resetTimer(){
    }

    String timeToString(int time){


        int[] it={0,0,0};
        String[] st=new String[3];

        it[2] = time;
        it[0]=it[2]/60;
        it[1]=it[1]/60;
        it[2]=it[2]%60;
        it[1]=it[1]%60;

        st[0]=""+it[0];

        for(int i=1;i<3;i++){
            if(it[i]<10)
                st[i]="0"+it[i];
            else
                st[i]=""+it[i];
        }

        return st[0]+":"+st[1]+":"+st[2];

    }

    long getTime(long time){
        return time;
    }
    boolean getStop(){
        return stop;
    }

    @Override
    public void run() {
        while(true){
            if(!getStop()) {

                if (studyOn) {
                    studyCount++;
                }
                if (restOn) {
                    restCount++;
                }



            }else{

            }
            try {

                studyTimeLable.setText(timeToString(studyCount));
                restTimeLabel.setText(timeToString(restCount));

                sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
