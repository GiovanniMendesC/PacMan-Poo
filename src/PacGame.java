public class PacGame{
    public static final int VELOCIDADE = 10;

    public static void main(String[] args) {
        PacMan pm = new PacMan(VELOCIDADE);
        Ghost  g = new Ghost(VELOCIDADE);

        Painel.Painel();




    }
}