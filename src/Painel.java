import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Painel {

    public static void Painel() {
        JFrame frame = new JFrame("PacMan Console");
        MovimentoPacMan mpm = new MovimentoPacMan();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.add(mpm);
        frame.setVisible(true);
    }
}
