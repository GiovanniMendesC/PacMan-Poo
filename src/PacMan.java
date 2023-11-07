public class PacMan extends Personagens{
    public PacMan(int velocidade){
        setVelocidade(velocidade);
    }
    public PacMan(int velocidade, int xInicial, int yInicial){
        setVelocidade(velocidade);
        setPosicaoX(xInicial);
        setPosicaoY(yInicial);
    }

    public static int pacPosicaoX;
    public static int pacPosicaoY;
}