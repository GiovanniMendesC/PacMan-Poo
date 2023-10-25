public abstract class Personagens{

    protected int posicaoX;
    protected int posicaoY;
    private int velocidade;

    private static final int size=30;

    public void setPosicaoX(int posicaox){
        posicaoX = posicaox;
    }
    public void setPosicaoY(int posicaoy){
        posicaoY = posicaoy;
    }

    public int getPosicaoX(){
        return posicaoX;
    }
    public int getPosicaoY(){
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