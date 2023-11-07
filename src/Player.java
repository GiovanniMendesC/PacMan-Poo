//classe que iria funcionar para o banco de dados
public class Player {
    private String nome;
    public static float pontuacao;

    public Player(){
        nome = "anônimo";
        pontuacao = 0;
    }

    public Player(String nome){
        this.nome = nome;
        pontuacao = 0;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
