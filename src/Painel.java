import javax.swing.JFrame;


public class Painel {

    public static void Painel() {
        JFrame frame = new JFrame("PacMan Console");
        MovimentoPacMan mpm = new MovimentoPacMan();
        MovimentoGhost mg = new MovimentoGhost();



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Define como fechar o programa
        frame.setSize(918, 640);

        frame.add(mpm);//adiciona os dois objetos, no caso o pacman
        frame.add(mg);//o ghost
        //tem q ser os dois para tanto o fantasma quanto o pacman se mexerem

        frame.setVisible(true);//"liga" a imagem
    }

}
