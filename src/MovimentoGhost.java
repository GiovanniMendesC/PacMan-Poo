import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovimentoGhost extends JPanel{
    //TALVEZ TENHA Q COLOCAR MAIS DE UM MOVIMENTO GHOST OU FAZER TUDO INTERCALANDO COM OS OUTROS FANTASMAS, SE CONSIDERAR A INICIALIZAÇÃO DELES
    private Ghost[] fantasma = new Ghost[4];
    private Color[] corDoFantasma = {Color.RED, Color.PINK, Color.GREEN, Color.ORANGE};
    private int personagemX=100;//provavelmente vai ter que fazer um pra cada fantasma
    private int personagemY=100;
    private int[] direcao = {1, 2, 3, 4};
    private Timer timer, timer1;

    public float DistanciaNova(int posicaoFantasmaX, int posicaoFantasmaY, Ghost fantasma, int direcao){
        if(direcao == 1){
            posicaoFantasmaX += (PacGame.VELOCIDADE-1);
        }else if(direcao == 2){
            posicaoFantasmaX -= (PacGame.VELOCIDADE-1);
        }else if(direcao == 3){
            posicaoFantasmaY += (PacGame.VELOCIDADE-1);
        }else if(direcao == 4){
            posicaoFantasmaY -= (PacGame.VELOCIDADE-1);
        }
        return(float)Math.sqrt(Math.pow((posicaoFantasmaX-PacMan.pacPosicaoX), 2)+Math.pow((posicaoFantasmaY-PacMan.pacPosicaoY), 2));
    }
    public int DirecaoNova(int posicaoFantasmaX, int posicaoFantasmaY, Ghost fantasma){
        for(int i=1; i<=4; i++){
            if(DistanciaNova(fantasma.posicaoX, fantasma.posicaoY, fantasma, i)<fantasma.distanciaPacMan(PacMan.pacPosicaoX, PacMan.pacPosicaoY)){
                return i;
            }
        }
        return 1;
    }

    public MovimentoGhost(){
        fantasma[0]=new Ghost(300, 420);
        fantasma[1]=new Ghost(300, 480);
        fantasma[2]=new Ghost(270, 420);
        fantasma[3]=new Ghost(270, 480);


        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<4; i++){

                    if(fantasma[i].distanciaPacMan(PacMan.pacPosicaoX, PacMan.pacPosicaoY)>300){
                        if(direcao[i]==1){
                            if(fantasma[i].posicaoX+(PacGame.VELOCIDADE-1)<=900){
                                fantasma[i].posicaoX+=(PacGame.VELOCIDADE-1);
                            }else{
                                fantasma[i].posicaoX=0;
                            }
                        }else if(direcao[i] == 2){
                            if(fantasma[i].posicaoX-(PacGame.VELOCIDADE-1)>=0){
                                fantasma[i].posicaoX-=(PacGame.VELOCIDADE-1);
                            }else {
                                fantasma[i].posicaoX = 900;
                            }
                        }else if(direcao[i] == 3){
                            if(fantasma[i].posicaoY+(PacGame.VELOCIDADE-1)<=600){
                                fantasma[i].posicaoY+=(PacGame.VELOCIDADE-1);
                            }else{
                                fantasma[i].posicaoY=0;
                            }
                        }else if(direcao[i] == 4) {
                            if(fantasma[i].posicaoY-(PacGame.VELOCIDADE-1)>=0){
                                fantasma[i].posicaoY -= (PacGame.VELOCIDADE-1);
                            }else{
                                fantasma[i].posicaoY = 600;
                            }
                        }
                    }else{
                        //ele tem q se mover para o caminho que deixe a distância menor
                        switch (DirecaoNova(fantasma[i].posicaoX, fantasma[i].posicaoY, fantasma[i])){
                            case 1:
                                if(fantasma[i].posicaoX+(PacGame.VELOCIDADE-1)<=900){
                                    fantasma[i].posicaoX+=(PacGame.VELOCIDADE-1);
                                }else{
                                    fantasma[i].posicaoX=0;
                                }
                                break;
                            case 2:
                                if(fantasma[i].posicaoX-(PacGame.VELOCIDADE-1)>=0){
                                    fantasma[i].posicaoX-=(PacGame.VELOCIDADE-1);
                                }else {
                                    fantasma[i].posicaoX = 900;
                                }
                                break;
                            case 3:
                                if(fantasma[i].posicaoY+(PacGame.VELOCIDADE-1)<=600){
                                    fantasma[i].posicaoY+=(PacGame.VELOCIDADE-1);
                                }else{
                                    fantasma[i].posicaoY=0;
                                }
                                break;
                            case 4:
                                if(fantasma[i].posicaoY-(PacGame.VELOCIDADE-1)>=0){
                                    fantasma[i].posicaoY -= (PacGame.VELOCIDADE-1);
                                }else{
                                    fantasma[i].posicaoY = 600;
                                }
                                break;
                            default:
                                System.exit(1);
                        }
                    }
                    repaint();
                }
            }
        });
        timer1 = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<4; i++){
                    direcao[i] = (int)(Math.random()*4.9+0.1);
                }

            }
        });
        timer.start();
        timer1.start();
        setFocusable(true);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i<4; i++){
            g.setColor(corDoFantasma[i]);
            g.fillRect(fantasma[i].posicaoX, fantasma[i].posicaoY, 30, 30);
        }
        g.setColor(Color.YELLOW);
        g.fillOval(PacMan.pacPosicaoX,PacMan.pacPosicaoY , 30, 30);
    }

}
