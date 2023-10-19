import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MovimentoPacMan extends JPanel implements ActionListener, KeyListener {
    private int personagemX=1;
    private int personagemY=1;
    private Timer timer;
    private boolean movendoParaDireita = false;
    private boolean movendoParaEsquerda = false;
    private boolean movendoParaCima = false;
    private boolean movendoParaBaixo = false;

    public MovimentoPacMan(){
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(personagemX, personagemY, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(movendoParaDireita){
            if(personagemX+PacGame.VELOCIDADE<=1900){
                personagemX+=PacGame.VELOCIDADE;
            }else{
                personagemX = 0;
            }
            PacMan.setPosicaoX(personagemX);
        }else if(movendoParaEsquerda){
            if (personagemX-PacGame.VELOCIDADE>=0){
                personagemX-=PacGame.VELOCIDADE;
            }else {
                personagemX = 1900;
            }
            PacMan.setPosicaoX(personagemX);
        }else if(movendoParaBaixo){
            if(personagemY+PacGame.VELOCIDADE<=1000){
                personagemY+=PacGame.VELOCIDADE;
            }else {
                personagemY = 0;
            }
            PacMan.setPosicaoY(personagemY);
        }else if(movendoParaCima){
            if(personagemY-PacGame.VELOCIDADE>=0){
                personagemY-=PacGame.VELOCIDADE;
            }else{
                personagemY = 1000;
            }
            PacMan.setPosicaoY(personagemY);
        }
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT){
            movendoParaDireita = true;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            movendoParaEsquerda = true;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            movendoParaBaixo = true;
        }
        if(keyCode == KeyEvent.VK_UP){
            movendoParaCima = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT){
            movendoParaDireita = false;
        }
        if(keyCode == KeyEvent.VK_LEFT){
            movendoParaEsquerda = false;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            movendoParaBaixo = false;
        }
        if(keyCode == KeyEvent.VK_UP){
            movendoParaCima = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
