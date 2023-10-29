public class Ghost extends Personagens{
    public Ghost(int pacVelocidade){
        setVelocidade(pacVelocidade);
    }
    public Ghost(int posicaoInicialX, int posicaoInicialY){
        setPosicaoX(posicaoInicialX);
        setPosicaoY(posicaoInicialY);
    }
    @Override
    public void setVelocidade(int pacVelocidade){
        super.setVelocidade(pacVelocidade+2);
    }

    public float distanciaPacMan(int pacmanX, int pacmanY){
        return (float)Math.sqrt(Math.pow((posicaoX-pacmanX), 2)+Math.pow((posicaoY-pacmanY), 2));
    }
}