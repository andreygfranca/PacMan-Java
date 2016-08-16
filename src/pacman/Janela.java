package pacman;

import javax.swing.JFrame;

public class Janela extends JFrame
{

    public Janela() 
    {
        this.add(new Grafico());
        this.setTitle("Pacman");
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,320);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Janela();
    }
    
}
