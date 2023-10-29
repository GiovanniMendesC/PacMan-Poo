import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Painel {

    public static void Painel() {
        JFrame frame = new JFrame("PacMan Console");
        MovimentoPacMan mpm = new MovimentoPacMan();
        MovimentoGhost mg = new MovimentoGhost();


        //interface overrite
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(918, 640);
        frame.add(mpm);
        frame.add(mg);
        frame.setVisible(true);

    }
}
