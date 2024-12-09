import javax.swing.SwingUtilities;
import view.GameMainFrame;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameMainFrame mainFrame= new GameMainFrame();
            mainFrame.setVisible(true);
        });
    }
}
