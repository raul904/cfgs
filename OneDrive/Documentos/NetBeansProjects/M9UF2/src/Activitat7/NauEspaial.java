/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Activitat7;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raul
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;

public class NauEspaial extends javax.swing.JFrame {    
    
    public NauEspaial() {
        initComponents();
        }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 300, Short.MAX_VALUE));
        pack();
        }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspaial.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
            }       
        NauEspaial f = new NauEspaial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(480, 560);
        f.setVisible(true);
        }
    }


class PanelNau extends JPanel implements Runnable, KeyListener{
    private int numNaus=10;
    private int numBullets=6;
    int pos=0;
    boolean revisa;
    
    //private int nauPropia=1;
    Nau[] nau;
    Nau jugador;
 
    Bullet[] bullet;
    
    public PanelNau(){        
        nau = new Nau[numNaus];
        bullet = new Bullet [numBullets];
        for (int i=0;i<nau.length;i++) {
            Random rand = new Random();
            int velocitat=(rand.nextInt(3)+5)*10;
            int posX=rand.nextInt(100)+30;
            int posY=rand.nextInt(100)+30;
            int dX=rand.nextInt(3)+1;
            int dY=rand.nextInt(3)+1;
            nau[i]= new Nau(i,posX,posY,dX,dY,velocitat);
       
          
            }
        //Una bala
    
        //Creo la nau propia
        jugador = new Nau(4,200,450,0,0,100);

        
        Thread n = new Thread(this);
        n.start();   
        
        addKeyListener(this);
        setFocusable(true);
        }
    @Override
    public void keyTyped(KeyEvent e){
    
    }
    @Override
    public void keyPressed(KeyEvent e){
        //System.out.println("Key pressed code="+ e.getKeyCode()+ ", char="+ e.getKeyChar());
     
        //System.out.println(e.getKeyCode());
        
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:               
                this.jugador.setDsx(-5);
                  //if ( this.jugador.setX>= 430 - this.jugador.SettX || this.jugador.setX<= this.jugador.SettX)   this.jugador.setDsx = -   this.jugador.setDsx;
                
            break;   
            
            case KeyEvent.VK_RIGHT:
                this.jugador.setDsx(5);             
                break;
             
            case KeyEvent.VK_SPACE:
               if (bullet[pos]==null) {
                bullet[pos] = new Bullet(pos, jugador.getX()+20,jugador.getY(), 0, -10, 70);
                }
                         pos++;
                if (pos==bullet.length) {
                    pos = 0;
                }
                break;
                
               
                
        

        }
    
    }
    @Override
    public void keyReleased(KeyEvent e) {
         this.jugador.setDsx(0);
    }
       
    public void run() {
        System.out.println("Inici fil repintar");
        while(true) {
            try { Thread.sleep(100);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();            
            }                   
        }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
      
      double rang;
        double colisio;
        
        for(int y=0; y<nau.length;++y){
           if (nau[y]!=null) {
            nau[y].pinta(g);
           } 
           if (jugador!=null) {
        jugador.pinta(g);
           }
            for(int i=0; i<bullet.length;i++) {
                if ((bullet[i] != null)&&(nau[y]!=null)) {
                   if(bullet[i].getY() < 0) {
                       bullet[i] = null;
                   } else {
                       bullet[i].pinta(g);
                  
                       rang = Math.sqrt((bullet[i].getX() - nau[y].getX())*(bullet[i].getX() - nau[y].getX())
                               + (bullet[i].getY() - nau[y].getY())*(bullet[i].getY() - nau[y].getY()));
                          if (jugador!=null) {
                       colisio = Math.sqrt((jugador.getX() - nau[y].getX())*(jugador.getX() - nau[y].getX())
                        + (jugador.getY() - nau[y].getY())*(jugador.getY() - nau[y].getY()));
                           if (colisio<30) {
                           if(!revisa) {
                               jugador=null;
                            JOptionPane.showMessageDialog(null,"T'han xocat", "Has perdut.", 
                                JOptionPane.ERROR_MESSAGE);
                                revisa = true;
                                System.exit(0);
                                    }
                            
                                           }
                                            }
                       
                       if (rang<25) {
                           nau[y]=null;
                           bullet[i]=null;
                           numNaus--;                       
                                    }
                        }
                                                        }
                
                                                }
                                    }
        
                                    }

     class Bullet extends Thread {
            private int numero;
            private int x,y;
            private int dsy,dsx;
            private int v;
            private int tx = 10;
            private int ty = 10;
            
            private String img = "/images/bullet.jpg";
            private Image image2;

        public Bullet(int numero, int x, int y, int dsx, int dsy, int v) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        image2 = new ImageIcon(Nau.class.getResource("bullet.png")).getImage();
        Thread t = new Thread(this);
        t.start();
        }

        public int getDsy() {
            return dsy;
        }

        public void setDsy(int dsy) {
            this.dsy = dsy;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getTx() {
            return tx;
        }

        public void setTx(int tx) {
            this.tx = tx;
        }

        public int getTy() {
            return ty;
        }

        public void setTy(int ty) {
            this.ty = ty;
        }
            

    
    public synchronized void pinta (Graphics g) {
           Graphics2D g2d = (Graphics2D)g;
           g2d.drawImage(this.image2, x, y, null);
           }
           
      public synchronized void moure (){
 
        y=y + dsy;

        }
    
      public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }

    
    }
     
        
}


class Nau extends Thread {
    private int numero;
    private int x,y;
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;

    private String img = "/images/nau.jpg";
    private Image image;

    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDsy() {
        return dsy;
    }

    public void setDsy(int dsy) {
        this.dsy = dsy;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }
    
    
    public Nau(int numero, int x, int y, int dsx, int dsy, int v ) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        image = new ImageIcon(Nau.class.getResource("nau.png")).getImage();
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public synchronized void moure (){
        x=x + dsx;
        y=y + dsy;
        // si arriva als marges ...
        if ( x>= 430 - tx || x<= tx) dsx = - dsx;
        if ( y >= 460 - ty || y<=ty ) dsy = - dsy;
        }
    
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
        }
    
    

    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }
    }
