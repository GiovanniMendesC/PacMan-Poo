import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

//herda a classe JPanel da biblioteca do swing
public class MovimentoGhost extends JPanel{
    private final Ghost[] fantasma = new Ghost[4];//instancia os 4 fantasmas
    private final Color[] corDoFantasma = {Color.RED, Color.PINK, Color.GREEN, Color.ORANGE};
    private final int[] direcao = {1, 2, 3, 4};//direita, esquerda, cima, baixo
    private final Timer timer, timer1;
    private int contador=0;
    private boolean continua = true;

    //método que verifica se o fantasma está na mesma posição do pacman
    public boolean FantasmaPegouPacman(){
        for(int i=0; i<4; i++){
            if(Math.round(fantasma[i].posicaoX/20f)==Math.round(PacMan.pacPosicaoX/20f)&&Math.round(fantasma[i].posicaoY/20f)==Math.round(PacMan.pacPosicaoY/20f)&&contador==0){
                continua = false;//manda o programa parar
                contador++;//impede a repetição da função
                return true;
            }
        }
        if(contador!=0){
            return true;
        }
        return false;
    }

    //verifica qual a distância do pacman o fantasma vai ficar ao se mexer na direção "direção"
    public float DistanciaNova(int posicaoFantasmaX, int posicaoFantasmaY, Ghost fantasma, int direcao){
        if(direcao == 1){
            posicaoFantasmaX += fantasma.velocidade;
        }else if(direcao == 2){
            posicaoFantasmaX -= fantasma.velocidade;
        }else if(direcao == 3){
            posicaoFantasmaY += fantasma.velocidade;
        }else if(direcao == 4){
            posicaoFantasmaY -= fantasma.velocidade;
        }
        return(float)Math.sqrt(Math.pow((posicaoFantasmaX-PacMan.pacPosicaoX), 2)+Math.pow((posicaoFantasmaY-PacMan.pacPosicaoY), 2));
    }

    //verifica qual a próxima direção o pacman deve seguir para diminuir a distância entre eles
    public int DirecaoNova(Ghost fantasma){
        for(int i=1; i<=4; i++){
            if(DistanciaNova(fantasma.posicaoX, fantasma.posicaoY, fantasma, i)<fantasma.distanciaPacMan(PacMan.pacPosicaoX, PacMan.pacPosicaoY)){
                if(!VaiBater(fantasma, i)) {//verifica se o fantasma vai bater antes de retornar a direção, pra ele parar antes de bater
                    return i;
                }
            }
        }
        return 0; //retorna 0 se for bater, para o fantasma parar
    }

    //verifica se o próximo movimento do fantasma colide com a parede
    public boolean VaiBater(Ghost fantasma, int direcao){
        if(fantasma.posicaoX-10>=0) {
            switch (direcao) {
                //cada case verifica pra uma "direção" e leva em consideração o tamanho do pacman
                //usa a função Math.round para aproximar o valor da posição do pacman para que ele não ultrapasse quando o x/20
                case 1:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 10) / 20f)][Math.round((fantasma.posicaoX + 20 + fantasma.velocidade) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10) / 20f)][Math.round((fantasma.posicaoX + 20 + fantasma.velocidade) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 2:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 10) / 20f)][Math.round((fantasma.posicaoX - 10 - fantasma.velocidade) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10) / 20f)][Math.round((fantasma.posicaoX - 10 - fantasma.velocidade) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 3:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY + 20 + fantasma.velocidade) / 20f)][Math.round((fantasma.posicaoX + 10) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY + 20 + fantasma.velocidade) / 20f)][Math.round((fantasma.posicaoX - 10) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                case 4:
                    if (Mapa.matriz[Math.round((fantasma.posicaoY - 10 - fantasma.velocidade) / 20f)][Math.round((fantasma.posicaoX + 10) / 20f)] != 1 && Mapa.matriz[Math.round((fantasma.posicaoY - 10 - fantasma.velocidade) / 20f)][Math.round((fantasma.posicaoX - 10) / 20f)] != 1) {
                        return false;
                    }
                    return true;
                default://se outra direção for indicada ele retorna q vai bater então o fantasma não se mexe
                    return true;
            }
        }else{
            return false;
        }
    }

    //parte principal da movimentação do fantasma
    public MovimentoGhost(){
        //inicia cada fantasma na posição certa
        fantasma[0]=new Ghost(388, 80);
        fantasma[1]=new Ghost(444, 80);
        fantasma[2]=new Ghost(444, 120);
        fantasma[3]=new Ghost(388, 120);

        //esse timer é o que vai fazer a animação e basicamente a moviementação do fantasma
        //a cada ciclo do timer ele realiza os comandos
        timer = new Timer(10, e -> {
            if (continua) {
                for (int i = 0; i < 4; i++) {

                    //verifica se o fantasma ta dentro do range do pacman
                    if (fantasma[i].distanciaPacMan(PacMan.pacPosicaoX, PacMan.pacPosicaoY) > 200) {

                        //if para cada direção de "direção"
                        if (direcao[i] == 1) {
                            //verifica se o X do fantasma está dentro do limite do mapa
                            if (fantasma[i].posicaoX + (fantasma[i].velocidade) <= 880) {
                                //verifica se vai bater antes de deixar ele se mover
                                if (!VaiBater(fantasma[i], direcao[i])) {
                                    fantasma[i].posicaoX += (fantasma[i].velocidade);
                                } else { //se for bater ele escolhe outra direção
                                    direcao[i] = (int) (Math.random() * 4.9 + 0.1);
                                }
                            } else {//se ele ultrapassou o limite do mapa ele faz a volta para "atravessar"
                                fantasma[i].posicaoX = 0;
                            }

                        } else if (direcao[i] == 2) {

                            if (fantasma[i].posicaoX - (fantasma[i].velocidade) > 4) {
                                if (!VaiBater(fantasma[i], direcao[i])) {
                                    fantasma[i].posicaoX -= (fantasma[i].velocidade);
                                } else {
                                    direcao[i] = (int) (Math.random() * 4.9 + 0.1);
                                }
                            } else {
                                fantasma[i].posicaoX = 880;
                            }

                        } else if (direcao[i] == 3) {//mesma coisa, mas com o y

                            if (fantasma[i].posicaoY + (fantasma[i].velocidade) <= 600) {
                                if (!VaiBater(fantasma[i], direcao[i])) {
                                    fantasma[i].posicaoY += (fantasma[i].velocidade);
                                } else {
                                    direcao[i] = (int) (Math.random() * 4.9 + 0.1);
                                }
                            } else {
                                fantasma[i].posicaoY = 0;
                            }

                        } else if (direcao[i] == 4) {//mesma coisa, mas com o y

                            if (fantasma[i].posicaoY - (fantasma[i].velocidade) >= 0) {
                                if (!VaiBater(fantasma[i], direcao[i])) {
                                    fantasma[i].posicaoY -= (fantasma[i].velocidade);
                                } else {
                                    direcao[i] = (int) (Math.random() * 4.9 + 0.1);
                                }
                            } else {
                                fantasma[i].posicaoY = 600;
                            }
                        }

                    } else {//se o fantasma ta dentro do range do pacman
                        //ele tem q se mover para o caminho que deixe a distância menor
                        switch (DirecaoNova( fantasma[i])) {
                            case 0:
                                break;
                            case 1:
                                //verifica se o X está dentro do limite do mapa
                                if (fantasma[i].posicaoX + (fantasma[i].velocidade) <= 860) {

                                    fantasma[i].posicaoX += (fantasma[i].velocidade);

                                } else {//se passou do limite volta pro x=0;
                                    fantasma[i].posicaoX = 0;
                                }
                                break;
                            case 2:
                                if (fantasma[i].posicaoX - (fantasma[i].velocidade) > 4) {

                                    fantasma[i].posicaoX -= (fantasma[i].velocidade);

                                } else {
                                    fantasma[i].posicaoX = 880;
                                }
                                break;
                            case 3:
                                if (fantasma[i].posicaoY + (fantasma[i].velocidade) <= 600) {

                                    fantasma[i].posicaoY += (fantasma[i].velocidade);

                                } else {
                                    fantasma[i].posicaoY = 0;
                                }
                                break;
                            case 4:
                                if (fantasma[i].posicaoY - (fantasma[i].velocidade) >= 0) {

                                    fantasma[i].posicaoY -= (fantasma[i].velocidade);

                                } else {
                                    fantasma[i].posicaoY = 600;
                                }
                                break;
                            default:
                                System.exit(1);
                        }
                    }
                    //chamada de função para pintar novamente o personagem na tela, com a posição atualizada
                    repaint();
                }
            }
        });

        //timer1 faz a contagem de 2s para trocar as direções dos fantasmas
        timer1 = new Timer(2000, e -> {
            for(int i=0; i<4; i++){
                //função Math.random para escolher aleatoriamente
                direcao[i] = (int)(Math.random()*4.9+0.1);
            }

        });
        //iniciando o temporizador
        timer.start();
        timer1.start();

        setFocusable(true);
    }

    //função que desenha os componentes na imagem
    //tanto o fantasma quanto o pacman estão desenhados aqui, assim como a matriz
    //se fossem desenhados em funções diferentes, os componentes seriam apresentados em paineis diferentes
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.BLACK);

        //verifica antes de pintar se o player pegou todos os pontos e se o fantasma pegou o pacman
        if(Player.pontuacao<10&&!FantasmaPegouPacman()) {
            //desenha o fantasma
            for (int i = 0; i < 4; i++) {
                g.setColor(corDoFantasma[i]);
                g.fillRect(fantasma[i].posicaoX, fantasma[i].posicaoY, 30, 30);
            }

            //desenha o mapa
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 45; j++) {
                    //desenha as paredes
                    if (Mapa.matriz[i][j] == 1) {
                        g.setColor(Color.blue);
                        g.fillRect(j * 20, i * 20, 20, 20);
                    }
                    //desenha os pontos
                    if (Mapa.mapaPonto[i][j] == 1) {
                        g.setColor(Color.ORANGE);
                        g.fillOval(j * 20, i * 20, 7, 7);
                    }
                }
            }

            //desenha pacman
            g.setColor(Color.YELLOW);
            g.fillOval(PacMan.pacPosicaoX, PacMan.pacPosicaoY, 30, 30);

            //desenha a pontuação
            g.setColor(Color.ORANGE);
            g.drawString("Pontuação "+(Player.pontuacao), 20, 20);

        }else if(Player.pontuacao==10){//se o player pegar todos os pontos
            //escreve "você ganhou"
            g.setColor(Color.YELLOW);
            Font font = new Font("Arial", Font.PLAIN, 30);
            g.setFont(font);
            g.drawString("YOU WON!", 355, 300);

            //encerra o timer e a execução da movimentação
            timer1.stop();
            timer.stop();
            continua=false;
            repaint();

        }else {//se o fantasma pegou o pacman

            //escreve "fim de jogo"
            g.setColor(Color.YELLOW);
            Font font = new Font("Arial", Font.PLAIN, 30);
            g.setFont(font);
            g.drawString("GAME OVER!", 355, 300);

            //encerra o timer
            timer1.stop();
            timer.stop();
            repaint();
        }
    }

}
