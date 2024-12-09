import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
 
/**
 * @author: happyaaakkk
 * @date  : 2020年4月5日  
 * @Description:测试布局管理器和setPreferredSize()的用法
 */
public class Test4 {
 
    public static void main(String[] args) throws Exception {
        
        final JFrame jf = new JFrame("测试窗口");
        jf.setSize(1200, 600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //big面板,黑色,绝对布局
        JPanel big = new JPanel();
        big.setLayout(null);
        big.setBackground(Color.BLACK);
        big.setToolTipText("big");//鼠标停留显示文字
        
        //mid面板,蓝色,流式布局
        JPanel mid = new JPanel();
        mid.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 40));
        //mid.setLayout(null);
        mid.setBackground(Color.BLUE);
        mid.setLocation(10, 10);
        mid.setSize(500,500);//上一级是绝对布局，本级使用这种方法设置尺寸
        //mid.setPreferredSize(new Dimension(500,500));//这种会出错
        mid.setToolTipText("mid");//鼠标停留显示文字
        big.add(mid);
 
        //small面板,黄色,流式布局
        JPanel small = new JPanel();
        small.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        small.setBackground(Color.yellow);
        small.setPreferredSize(new Dimension(60,240));//上一级使用了布局管理器，本级需使用这种方法设置尺寸
        //small.setBounds(10, 10, 60, 240);//这种会出错
        small.setToolTipText("small");//鼠标停留显示文字
        for (int i = 0; i < 24; i++) {
	        JButton btn = new JButton();
	        btn.setBackground(Color.GREEN);
	        btn.setOpaque(true);
	        btn.setPreferredSize(new Dimension(20,30));//上一级使用了布局管理器，本级需使用这种方法设置尺寸
	        //btn.setBounds(0, 0, 20, 20);//这种会出错
	        btn.setToolTipText("btn");//鼠标停留显示文字
	        small.add(btn);
        }
        mid.add(small);
        
        jf.setContentPane(big);
        jf.setVisible(true);
    }
 
}