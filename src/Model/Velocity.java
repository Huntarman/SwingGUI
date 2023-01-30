//package Model;
//
//import java.awt.*;
//import java.awt.geom.AffineTransform;
//
//public class Velocity extends Object{
//    public int X1;
//    public int X2;
//    public int i;
//    public void setXes(int x1,int x2){
//        this.X1 = x1;
//        this.X2 = x2;
//    }
//    @Override
//    public void drawMe(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        int dx0 = 0;
//        int dy0 = (int) (g2d.getClipBounds().height / 2);
//        AffineTransform saveAT = g2d.getTransform();
//        t = new AffineTransform();
//        t.translate(dx0, dy0);
//        t.scale(1,-1);
//        g2d.setTransform(t);
//        g2d.drawLine(0,0,i,X2 - X1);
//        t.translate(i++, X2-X1);
//        g2d.setTransform(saveAT);
//    }
//
//    @Override
//    public void rotate() {
//
//    }
//}
//