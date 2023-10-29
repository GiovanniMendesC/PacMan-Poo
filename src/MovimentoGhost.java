import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovimentoGhost extends JPanel{
    //TALVEZ TENHA Q COLOCAR MAIS DE UM MOVIMENTO GHOST OU FAZER TUDO INTERCALANDO COM OS OUTROS FANTASMAS, SE CONSIDERAR A INICIALIZAÇÃO DELES
    private Ghost[] fantasma = new Ghost[4];
    private Color[] corDoFantasma = {Color.RED, Color.PINK, Color.GREEN, Color.ORANGE};
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
                if(!VaiBater(fantasma, i)) {
                    return i;
                }else{

                }
            }
        }
        return 0;
    }

    public boolean VaiBater(Ghost fantasma, int direcao){
        if(fantasma.posicaoX-10>=0) {
            switch (direcao) {
                case 1:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 10) / 20f)][Math.round((fantasma.posicaoX + 20 + PacGame.VELOCIDADE - 1) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10) / 20f)][Math.round((fantasma.posicaoX + 20 + PacGame.VELOCIDADE - 1) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 2:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 10) / 20f)][Math.round((fantasma.posicaoX - 10 - PacGame.VELOCIDADE - 1) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10) / 20f)][Math.round((fantasma.posicaoX - 10 - PacGame.VELOCIDADE - 1) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 3:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 20 + PacGame.VELOCIDADE - 1) / 20f)][Math.round((fantasma.posicaoX + 10) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY + 20 + PacGame.VELOCIDADE - 1) / 20f)][Math.round((fantasma.posicaoX - 10) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 4:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY - 10 - PacGame.VELOCIDADE - 1) / 20f)][Math.round((fantasma.posicaoX + 10) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10 - PacGame.VELOCIDADE - 1) / 20f)][Math.round((fantasma.posicaoX - 10) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                default:
                    return true;
            }
        }else{
            return false;
        }
    }

    public MovimentoGhost(){
        fantasma[0]=new Ghost(388, 80);
        fantasma[1]=new Ghost(444, 80);
        fantasma[2]=new Ghost(444, 120);
        fantasma[3]=new Ghost(388, 120);


        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<4; i++){

                    if(fantasma[i].distanciaPacMan(PacMan.pacPosicaoX, PacMan.pacPosicaoY)>200){
                        if(direcao[i]==1){
                            if(fantasma[i].posicaoX+(PacGame.VELOCIDADE-1)<=880){
                                if(!VaiBater(fantasma[i], direcao[i])){
                                    fantasma[i].posicaoX+=(PacGame.VELOCIDADE-1);
                                }else{
                                    direcao[i] = (int)(Math.random()*4.9+0.1);
                                }
                            }else{
                                fantasma[i].posicaoX=0;
                            }
                        }else if(direcao[i] == 2){
                            if(fantasma[i].posicaoX-(PacGame.VELOCIDADE-1)>4){
                                if(!VaiBater(fantasma[i], direcao[i])){
                                    fantasma[i].posicaoX-=(PacGame.VELOCIDADE-1);
                                }else{
                                    direcao[i] = (int)(Math.random()*4.9+0.1);
                                }
                            }else {
                                fantasma[i].posicaoX = 880;
                            }
                        }else if(direcao[i] == 3){
                            if(fantasma[i].posicaoY+(PacGame.VELOCIDADE-1)<=600){
                                if(!VaiBater(fantasma[i], direcao[i])){
                                    fantasma[i].posicaoY+=(PacGame.VELOCIDADE-1);
                                }else{
                                    direcao[i] = (int)(Math.random()*4.9+0.1);
                                }
                            }else{
                                fantasma[i].posicaoY=0;
                            }
                        }else if(direcao[i] == 4) {
                            if(fantasma[i].posicaoY-(PacGame.VELOCIDADE-1)>=0){
                                if(!VaiBater(fantasma[i], direcao[i])){
                                    fantasma[i].posicaoY -= (PacGame.VELOCIDADE-1);
                                }else{
                                    direcao[i] = (int)(Math.random()*4.9+0.1);
                                }
                            }else{
                                fantasma[i].posicaoY = 600;
                            }
                        }
                    }else{
                        //ele tem q se mover para o caminho que deixe a distância menor
                        switch (DirecaoNova(fantasma[i].posicaoX, fantasma[i].posicaoY, fantasma[i])){
                            case 0:
                                break;
                            case 1:
                                if(fantasma[i].posicaoX+(PacGame.VELOCIDADE-1)<=860){

                                    fantasma[i].posicaoX+=(PacGame.VELOCIDADE-1);

                                }else{
                                    fantasma[i].posicaoX=0;
                                }
                                break;
                            case 2:
                                if(fantasma[i].posicaoX-(PacGame.VELOCIDADE-1)>4){

                                    fantasma[i].posicaoX-=(PacGame.VELOCIDADE-1);

                                }else {
                                    fantasma[i].posicaoX = 880;
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
        for(int i=0; i<30; i++){
            for(int j=0; j<45; j++){
                if(Mapa.matriz[i][j]==1){
                    g.setColor(Color.blue);
                    g.fillRect(j*20, i*20, 20, 20);
                }
                if(Mapa.matriz[i][j]==-1){
                    g.setColor(Color.ORANGE);
                    g.fillOval(j*20, i*20, 7, 7);
                }
            }
        }

        setBackground(Color.BLACK);
    }

}
