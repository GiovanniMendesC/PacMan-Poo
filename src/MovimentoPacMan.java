import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



//herda a classe JPanel e implementa as interfaces de ActoinListener e KeyListener
public class MovimentoPacMan extends JPanel implements ActionListener, KeyListener {
    private PacMan pacMan = new PacMan(PacGame.VELOCIDADE, 436, 500);
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
        //leva em consederação o tamanho do pacman (por isso tem +/-10)
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

            if(pacMan.posicaoX+PacGame.VELOCIDADE<=880){//verifica se está dentro do limite do mapa
                //verifica se a posição do pacman ao andar não vai bater numa parede
                if(Mapa.matriz[Math.round((pacMan.posicaoY+10)/20f)][Math.round((pacMan.posicaoX+20+pacMan.velocidade)/20f)]!=1&&Mapa.matriz[Math.round((pacMan.posicaoY-10)/20f)][Math.round((pacMan.posicaoX+20+pacMan.velocidade)/20f)]!=1){
                    pacMan.posicaoX+= pacMan.velocidade;
                }
            }else{//se passar do limite volta pro começo
                pacMan.posicaoX = 0;
            }

        }else if(movendoParaEsquerda){

            if (pacMan.posicaoX-PacGame.VELOCIDADE>=0){
                if(Mapa.matriz[Math.round((pacMan.posicaoY+10)/20f)][Math.round((pacMan.posicaoX-10-pacMan.velocidade)/20f)]!=1&&Mapa.matriz[Math.round((pacMan.posicaoY-10)/20f)][Math.round((pacMan.posicaoX-10-pacMan.velocidade)/20f)]!=1){
                    pacMan.posicaoX-=pacMan.velocidade;
                }
            }else {
                pacMan.posicaoX = 880;
            }

        }else if(movendoParaBaixo){

            if(pacMan.posicaoY+PacGame.VELOCIDADE<=600){
                if(Mapa.matriz[Math.round((pacMan.posicaoY+20+pacMan.velocidade)/20f)][Math.round((pacMan.posicaoX+10)/20f)]!=1&&Mapa.matriz[Math.round((pacMan.posicaoY+20+pacMan.velocidade)/20f)][Math.round((pacMan.posicaoX-10)/20f)]!=1){
                    pacMan.posicaoY+=pacMan.velocidade;
                }
            }else {
                pacMan.posicaoY = 0;
            }

        }else if(movendoParaCima){

            if(pacMan.posicaoY-PacGame.VELOCIDADE>=0){
                if(Mapa.matriz[Math.round((pacMan.posicaoY-10-pacMan.velocidade)/20f)][Math.round((pacMan.posicaoX+10)/20f)]!=1&&Mapa.matriz[Math.round((pacMan.posicaoY-10-pacMan.velocidade)/20f)][Math.round((pacMan.posicaoX-10)/20f)]!=1){
                    pacMan.posicaoY-=pacMan.velocidade;
                }
            }else{
                pacMan.posicaoY = 600;
            }
        }
        //pacPosicao recebe o valor de X após a execução para que fantasma tenha acesso à localização dele
        PacMan.pacPosicaoX = pacMan.posicaoX;
        PacMan.pacPosicaoY = pacMan.posicaoY;
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
