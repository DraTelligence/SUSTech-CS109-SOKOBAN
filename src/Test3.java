import java.awt.*;
import javax.swing.*;

public class Test3 {
    private static JPanel createPanel(Color bg, int x, int y, int width, int height) {
        JPanel panel = new JPanel(); // 创建一个JPanel
        panel.setOpaque(true); // 设置不透明
        panel.setBackground(bg); // 设置背景颜色
        panel.setBounds(x, y, width, height); // 设置面板的位置和宽高
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Demo01"); // 设置窗口标题
        frame.setSize(400, 300); // 设置窗口显示大小

        JLayeredPane layeredPane = new JLayeredPane(); // 创建层级面板

        JPanel panel01 = createPanel(Color.RED, 90, 30, 100, 100);
        layeredPane.add(panel01, 1);
        JPanel panel02 = createPanel(Color.YELLOW, 150, 50, 100, 100);
        layeredPane.add(panel02, 2, 0);
        JPanel panel03 = createPanel(Color.BLUE, 120, 90, 100, 100);
        layeredPane.add(panel03, 3, 1);
        JPanel panel04 = createPanel(Color.GREEN, 170, 110, 100, 100);
        layeredPane.add(panel04, 5 ,1);

        frame.add(layeredPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口默认关闭操作
        frame.setLocationRelativeTo(null); // 相对屏幕居中
        frame.setVisible(true); // 设置窗口可见
    }
}
