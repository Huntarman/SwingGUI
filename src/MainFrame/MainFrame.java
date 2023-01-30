package MainFrame;

import Model.MyPanel;
//import Model.VelXPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 *  Michał Zajdel
 *  java 17
 *  cd Lab04
 *  Compilation: javac -sourcepath src/ -d build/prodution/Lab04 src/Mainframe/Mainframe.java
 *  Running: java.exe -p "build/prodution/Lab04" -m Lab04/MainFrame.MainFrame
 *  jar : jar cfv Lab04_pop.jar -C build/prodution/Lab04 .
 *  runningjar : java -p Lab04_pop.jar -m Lab04/MainFrame.MainFrame
 */
public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField L1Field;
    private JTextField L2Field;
    private JTextField HField;
    private JTextField DField;
    private JButton StartButton = new JButton("Start");
    private MyPanel Machine;
    //private VelXPanel VelGraph;
    private static int L1;
    private static int L2;
    private static int H;
    private static int D;
    public static void main(String[] args) {
        try {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void animate() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 360;
                //VelGraph.setXes(0,0);
                while (i>0) {
                    Machine.g.rotate();
                    Machine.repaint();
                    Machine.setVelocities();
                    Machine.printer();
                   // VelGraph.setXes(Machine.getX1vel(),Machine.getX2vel());
                   // VelGraph.repaint();
                    i--;
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                    }
                }
            }
        });
        t.start();
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        StartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                L1 = Integer.parseInt(L1Field.getText());
                L2 = Integer.parseInt(L2Field.getText());
                H = Integer.parseInt(HField.getText());
                D = Integer.parseInt(DField.getText());
                Machine = new MyPanel(L1,L2,H,D);
                Machine.setBackground(new Color(255, 255, 255));
                Machine.setBounds(125, 10, 350, /*300*/ 400);
                contentPane.add(Machine);
               //VelXPanel VelGraph = new VelXPanel(0,0);
               //VelGraph.setBackground(new Color(255, 255, 255));
               //VelGraph.setBounds(125, 355, 350, 80);
               //contentPane.add(VelGraph);
                animate();
            }
        });
        StartButton.setBounds(10, 224, 85, 21);
        contentPane.add(StartButton);

        L1Field = new JTextField();
        L1Field.setBounds(10, 25, 96, 19);
        contentPane.add(L1Field);
        L1Field.setColumns(10);

        JLabel L1label = new JLabel("L1:");
        L1label.setBounds(10, 45, 45, 13);
        contentPane.add(L1label);

        L2Field = new JTextField();
        L2Field.setBounds(10, 65, 96, 19);
        contentPane.add(L2Field);
        L2Field.setColumns(10);

        HField = new JTextField();
        HField.setBounds(10, 105, 96, 19);
        contentPane.add(HField);
        HField.setColumns(10);

        DField = new JTextField();
        DField.setBounds(10, 145, 96, 19);
        contentPane.add(DField);
        DField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("D:");
        lblNewLabel_1.setBounds(10, 165, 45, 13);
        contentPane.add(lblNewLabel_1);

        JLabel L3label = new JLabel("H:");
        L3label.setBounds(10, 125, 45, 13);
        contentPane.add(L3label);

        JLabel L2label = new JLabel("L2:");
        L2label.setBounds(10, 85, 45, 13);
        contentPane.add(L2label);

    }
}

