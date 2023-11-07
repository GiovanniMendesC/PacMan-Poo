public class Ghost extends Personagens{//herda personagens
    public Ghost(int posicaoInicialX, int posicaoInicialY){//inicia o fantasma na posição
        setPosicaoX(posicaoInicialX);
        setPosicaoY(posicaoInicialY);
        setVelocidade(PacGame.VELOCIDADE-1);
    }

    public float distanciaPacMan(int pacmanX, int pacmanY){
        return (float)Math.sqrt(Math.pow((posicaoX-pacmanX), 2)+Math.pow((posicaoY-pacmanY), 2));
    }

    public static int[] fantasmaX= new int[4];
}