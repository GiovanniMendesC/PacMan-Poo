public class PacGame{
    public static final int VELOCIDADE = 4;

    public static void main(String[] args) {
        PacMan pm = new PacMan(VELOCIDADE);
        Ghost  g = new Ghost(VELOCIDADE);
        Player pp = new Player();

        Painel.Painel();
    }
}