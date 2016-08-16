package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Grafico extends JComponent implements Runnable, KeyListener
{

    PacMan player;
    Fantasma fantasma;
    ArrayList <Comida>comidaLista;
    
    boolean controle = true;
    boolean controle2 = true;
    int pontos;
    
            
    public Grafico() 
    {
        pontos = 0;
        comidaLista = new ArrayList<>();
        fantasma = new Fantasma(316, 50);
        player = new PacMan(20, 30, 0, 1);
        new Thread(this).start();
        this.addKeyListener(this);
        this.setFocusable(true);
        
        comidaLista.add(new Comida(39, 43));
        comidaLista.add(new Comida(73, 43));
        comidaLista.add(new Comida(107, 43));
        comidaLista.add(new Comida(141, 43));
        comidaLista.add(new Comida(178, 43));
        comidaLista.add(new Comida(212, 43));
        
        comidaLista.add(new Comida(39, 82));
        comidaLista.add(new Comida(39, 121));
        comidaLista.add(new Comida(39, 160));
        comidaLista.add(new Comida(39, 198));
        
        comidaLista.add(new Comida(141, 159));
        comidaLista.add(new Comida(141, 120));
        comidaLista.add(new Comida(141, 81));
        comidaLista.add(new Comida(175, 81));
        
        comidaLista.add(new Comida(212, 81));
        comidaLista.add(new Comida(212, 120));
        comidaLista.add(new Comida(212, 159));
        comidaLista.add(new Comida(617, 159));
        
        comidaLista.add(new Comida(617, 159));
        comidaLista.add(new Comida(617, 120));
        comidaLista.add(new Comida(617, 81));
        comidaLista.add(new Comida(617, 40));
        
        comidaLista.add(new Comida(246, 120));
        comidaLista.add(new Comida(280, 120));
        comidaLista.add(new Comida(314, 120));
        comidaLista.add(new Comida(348, 120));
        comidaLista.add(new Comida(382, 120));
        comidaLista.add(new Comida(416, 120));
        comidaLista.add(new Comida(450, 120));
        comidaLista.add(new Comida(450, 47));
        comidaLista.add(new Comida(450, 81));
        comidaLista.add(new Comida(450, 159));
        comidaLista.add(new Comida(450, 81));
        comidaLista.add(new Comida(450, 81));
        
        comidaLista.add(new Comida(246, 120));
        comidaLista.add(new Comida(280, 120));
        comidaLista.add(new Comida(314, 120));
        comidaLista.add(new Comida(348, 120));
        
        comidaLista.add(new Comida(382, 120));
        comidaLista.add(new Comida(416, 120));
        comidaLista.add(new Comida(450, 120));
        
        comidaLista.add(new Comida(484, 40));
        comidaLista.add(new Comida(518, 40));
        comidaLista.add(new Comida(552, 40));
        comidaLista.add(new Comida(586, 40));
        comidaLista.add(new Comida(484, 81));
        comidaLista.add(new Comida(518, 81));
        comidaLista.add(new Comida(518, 120));
        comidaLista.add(new Comida(518, 159));
        
        comidaLista.add(new Comida(73, 198));
        comidaLista.add(new Comida(107, 198));
        comidaLista.add(new Comida(141, 198));
        comidaLista.add(new Comida(175, 198));
        comidaLista.add(new Comida(209, 198));
        comidaLista.add(new Comida(243, 198));
        comidaLista.add(new Comida(277, 198));
        comidaLista.add(new Comida(311, 198));
        comidaLista.add(new Comida(379, 198));
        comidaLista.add(new Comida(413, 198));
        comidaLista.add(new Comida(447, 198));
        comidaLista.add(new Comida(481, 198));
        comidaLista.add(new Comida(515, 198));
        comidaLista.add(new Comida(549, 198));
        comidaLista.add(new Comida(583, 198));
        comidaLista.add(new Comida(617, 198));
        
        
        
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        
        Image im;
        im = new ImageIcon ("fundo.png").getImage ( );
        g.drawImage ( im , 0 , 0 , this );
        
        
        
        g.setColor(Color.white);
        Iterator<Comida> it = comidaLista.iterator();
        while (it.hasNext()) {
            Comida comida = it.next();
            g.fillOval(comida.getX(), comida.getY(), 15, 15);
            if(player.getX() > comida.getX()- 20 && player.getX() < comida.getX()+ 20 &&
            player.getY() > comida.getY() - 20 && player.getY() < comida.getY() + 20){
                System.out.println("comeu");
                pontos++;
                System.out.println(pontos);
                player.setPontos(pontos);
                it.remove();
            }
            
        }
        g.drawImage(fantasma.getSprite(), fantasma.getX(), fantasma.getY(), this);
        validate();
        byte [] rgb = { 'P','O','N','T','O','S'};
        g.drawBytes(rgb, 0, 6, 20, 290);

        g.drawString("PONTOS = "+player.getPontos(), 20, 290);

        
        g.setColor(Color.yellow);
        if (controle == true) //Boca Fechada
            g.fillOval(player.getX(), player.getY(), 50, 50);
        else if (controle == false && player.getDir() == 1) //Boca Aberta p/ Direira
            g.fillArc(player.getX(), player.getY(), 50, 50, 30, 280);
        else if (controle == false && player.getDir() == 4) //Boca Aberta p/ Esquerda
            g.fillArc(player.getX(), player.getY(), 50, 50, 210, 280);
        else if (controle == false && player.getDir() == 3) //Boca Aberta p/ Cima
            g.fillArc(player.getX(), player.getY(), 50, 50, 130, 280);
        else if (controle == false && player.getDir() == 2) //Boca Aberta p/ Baixo
            g.fillArc(player.getX(), player.getY(), 50, 50, 310, 280);
    }

    @Override
    public void run() 
    {
        while(true){
            try {
                Thread.sleep(15);
                fantasma.mover();
                player.mover();
                
                

                if (controle2)
                    controle = !controle;
                controle2 = !controle2;
                
                if(player.getX() > fantasma.getX()- 20 && player.getX() < fantasma.getX()+ 20 &&
                player.getY() > fantasma.getY() - 20 && player.getY() < fantasma.getY() + 20){
                    
                    player.perder();
                }
                
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            player.setDir(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            player.setDir(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            player.setDir(4);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.setDir(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}
