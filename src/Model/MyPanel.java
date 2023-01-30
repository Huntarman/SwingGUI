package Model;

import javax.swing.*;
import java.awt.Graphics;
public class MyPanel extends JPanel {
    public Layout g;
    public int L1,L2,H,D;
    public double Y1vel , Y2vel;
    public double X1vel , X2vel;

    public  MyPanel(int l1, int l2, int h, int d){
        this.L1 = l1;
        this.L2 = l2;
        this.H = h;
        this.D = d;
        this.g = new Layout(L1,L2,H,D);
    }
    @Override
    protected void paintComponent(Graphics arg){
        super.paintComponent(arg);
        if(g!=null){
            g.drawMe(arg);
        }
    }
    public void setVelocities(){
        this.X1vel = g.getX1vel();
        this.Y1vel = g.getY1vel();
    }
     public void printer(){
         System.out.println("X1 vel:" + this.X1vel + "Y1 vel: " + this.Y1vel);
     }

     public double getX1vel() {
         return X1vel;
     }

     public double getX2vel() {
         return X2vel;
     }

     public double getY1vel() {
         return Y1vel;
     }

     public double getY2vel() {
         return Y2vel;
     }

    public int getL1 (){ return L1;}
}
