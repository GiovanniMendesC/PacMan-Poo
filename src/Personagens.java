public class Personagens{

    private static int posicaoX;
    private static int posicaoY;
    private int velocidade;

    private static final int size=30;

    public static void setPosicaoX(int posicaox){
        posicaoX = posicaox;
    }
    public static void setPosicaoY(int posicaoy){
        posicaoY = posicaoy;
    }

    public static int getPosicaoX(){
        return posicaoX;
    }
    public static int getPosicaoY(){
        return posicaoY;
    }

    public int getSize(){
        return size;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getVelociade(){
        return velocidade;
    }
}