package Model;

import java.awt.*;
import java.awt.geom.AffineTransform;
public class Layout extends Object{
    public double alpha;
    public static int L1,L2,H,D;
    public double beta = Math.atan2(H , L1 - D) - Math.PI/2;
    public double Y1vel;
    public double Y2vel;
    public double X1vel;
    public double X2vel;
   //public int i;
    @Override
    public void drawMe(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int dx0 = (int) (g2d.getClipBounds().width / 1.6);
        int dy0 = (int) (g2d.getClipBounds().height / 1.6);
        AffineTransform saveAT = g2d.getTransform();

        t = new AffineTransform();
        t.translate(dx0, dy0);
        t.scale(1,-1);
        g2d.setTransform(t);
        g2d.drawOval(D-5,H-5,10,10);

        double x = (L1 * Math.cos(alpha));
        double y = (L1 * Math.sin(alpha));//x i y to wspolrzedne punktu w ktorym konczy sie linia robiaca kolo

        X1vel = (L2 * Math.cos(beta)) + x;
        Y1vel = (L2 * Math.sin(beta)) + y;// to sa wspolrzedne pktu p2

        t.rotate(alpha);
        g2d.setTransform(t);
        g2d.drawLine(0,0,L1,0);
        t.translate(L1, 0);
        beta -= alpha;
        t.rotate(beta);
        beta = Math.atan2((H-y),(D-x));
        g2d.setTransform(t);
        g2d.drawLine(0, 0, L2, 0);
        g2d.setTransform(saveAT);


    }
    public double getX1vel(){return X1vel;}
    public double getY1vel(){return Y1vel;}
    @Override
    public void rotate() {
    alpha += Math.PI/180;
    }

    public Layout(int l1, int l2, int h, int d){
        this.L1 = l1;
        this.L2 = l2;
        this.H = h;
        this.D = d;
    }
}
