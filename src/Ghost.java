public class Ghost extends Personagens{
    public Ghost(int pacVelocidade){
        setVelocidade(pacVelocidade);
    }
    @Override
    public void setVelocidade(int pacVelocidade){
        super.setVelocidade(pacVelocidade+2);
    }
}