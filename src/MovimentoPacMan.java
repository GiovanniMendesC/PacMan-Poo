import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



//herda a classe JPanel e implementa as interfaces de ActoinListener e KeyListener
public class MovimentoPacMan extends JPanel implements ActionListener, KeyListener {
    private PacMan pacMan = new PacMan(PacGame.VELOCIDADE);
    private int personagemX=436;
    private int personagemY=500;
    private Timer timer;
    private boolean movendoParaDireita = false;
    private boolean movendoParaEsquerda = false;
    private boolean movendoParaCima = false;
    private boolean movendoParaBaixo = false;

    //movimentação do pacman
    public MovimentoPacMan(){
        //timer para executar as intruções do keylistener
        timer = new Timer(10, this);
        timer.start();

        //onde ocorre as modificações de X do pacman
        addKeyListener(this);
        setFocusable(true);
    }

    //método para verificar se o pacman está na posição de uma célula de ponto na matriz e soma pontos
    public void MarcouPonto(){
        //cada direção precisou ser colocada como variável, porque se não o valor era alterado dentro do if
        int i, j, k, l, m, n, o, p;
        i=Math.round((PacMan.pacPosicaoY+10)/20f);
        j=Math.round((PacMan.pacPosicaoX)/20f);
        k=Math.round((PacMan.pacPosicaoY)/20f);
        l=Math.round((PacMan.pacPosicaoX+10)/20f);
        m=Math.round((PacMan.pacPosicaoY-10)/20f);
        n=Math.round((PacMan.pacPosicaoX)/20f);
        o=Math.round((PacMan.pacPosicaoY)/20f);
        p=Math.round((PacMan.pacPosicaoX-10)/20f);

        //se a posição do pacman no mapa de ponto for 1, então soma pontuação
        if(Mapa.mapaPonto[i][j]==1){
            Mapa.mapaPonto[i][j]=0;
            Player.pontuacao++;

        }else if(Mapa.mapaPonto[k][l]==1){
            Mapa.mapaPonto[k][l]=0;
            Player.pontuacao++;

        }else if(Mapa.mapaPonto[m][n]==1){
            Mapa.mapaPonto[m][n]=0;
            Player.pontuacao++;

        }else if(Mapa.mapaPonto[o][p]==1){
            Mapa.mapaPonto[o][p]=0;
            Player.pontuacao++;

        }
    }

    //método que define o que vai acontecer a cada ciclo do timer
    @Override
    public void actionPerformed(ActionEvent e) {

        //verifica que direção está se mexendo
        if(movendoParaDireita){

            if(personagemX+PacGame.VELOCIDADE<=880){//verifica se está dentro do limite do mapa
                //verifica se a posição do pacman ao andar não vai bater numa parede
                if(Mapa.matriz[Math.round((personagemY+10)/20f)][Math.round((personagemX+20+PacGame.VELOCIDADE)/20f)]!=1&&Mapa.matriz[Math.round((personagemY-10)/20f)][Math.round((personagemX+20+PacGame.VELOCIDADE)/20f)]!=1){
                    personagemX+=PacGame.VELOCIDADE;
                }
            }else{//se passar do limite volta pro começo
                personagemX = 0;
            }
            pacMan.setPosicaoX(personagemX);//atualiza o X

        }else if(movendoParaEsquerda){

            if (personagemX-PacGame.VELOCIDADE>=0){
                if(Mapa.matriz[Math.round((personagemY+10)/20f)][Math.round((personagemX-10-PacGame.VELOCIDADE)/20f)]!=1&&Mapa.matriz[Math.round((personagemY-10)/20f)][Math.round((personagemX-10-PacGame.VELOCIDADE)/20f)]!=1){
                    personagemX-=PacGame.VELOCIDADE;
                }
            }else {
                personagemX = 880;
            }
            pacMan.setPosicaoX(personagemX);

        }else if(movendoParaBaixo){

            if(personagemY+PacGame.VELOCIDADE<=600){
                if(Mapa.matriz[Math.round((personagemY+20+PacGame.VELOCIDADE)/20f)][Math.round((personagemX+10)/20f)]!=1&&Mapa.matriz[Math.round((personagemY+20+PacGame.VELOCIDADE)/20f)][Math.round((personagemX-10)/20f)]!=1){
                    personagemY+=PacGame.VELOCIDADE;
                }
            }else {
                personagemY = 0;
            }
            pacMan.setPosicaoY(personagemY);

        }else if(movendoParaCima){

            if(personagemY-PacGame.VELOCIDADE>=0){
                if(Mapa.matriz[Math.round((personagemY-10-PacGame.VELOCIDADE)/20f)][Math.round((personagemX+10)/20f)]!=1&&Mapa.matriz[Math.round((personagemY-10-PacGame.VELOCIDADE)/20f)][Math.round((personagemX-10)/20f)]!=1){
                    personagemY-=PacGame.VELOCIDADE;
                }
            }else{
                personagemY = 600;
            }
            pacMan.setPosicaoY(personagemY);
        }
        //pacPosicao recebe o valor de X após a execução para que fantasma tenha acesso à localização dele
        PacMan.pacPosicaoX = personagemX;
        PacMan.pacPosicaoY = personagemY;
        MarcouPonto();
    }

    //método que define ação para cada tecla pressionada
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

    //método que define ação para cada tecla liberada
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

    //pega a telca pressionada
    @Override
    public void keyTyped(KeyEvent e) {}
}
