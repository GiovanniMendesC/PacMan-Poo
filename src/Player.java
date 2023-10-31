public class Player {
    private String nome;//tem q ser único
    public static float pontuacao;

    public Player(){
        nome = "anônimo";
        pontuacao = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
