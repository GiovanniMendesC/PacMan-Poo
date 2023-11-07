//classe abstrata base para os personagens
public abstract class Personagens{

    protected int posicaoX;
    protected int posicaoY;
    protected int velocidade;

    private static final int size=30;

    public void setPosicaoX(int posicaox){
        posicaoX = posicaox;
    }
    public void setPosicaoY(int posicaoy){
        posicaoY = posicaoy;
    }


    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

}