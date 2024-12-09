import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//顶层容器 (框架)
import javax.swing.JButton; //中间容器（常用的面板）
import javax.swing.JFrame; //按钮
import javax.swing.JPanel; //文本框实现类
import javax.swing.JTextField;//动作事件

public class Test2 {

    static int clicknum = 0;

    public static void main(String[] args) {

        JFrame jframe1 = new JFrame("title"); // 窗口

        jframe1.setSize(1000, 400); // 设置窗口大小

        jframe1.setLayout(new FlowLayout(FlowLayout.CENTER,0,200));

        JPanel jpanel1 = new JPanel(); // 面板1
        JPanel jpanel2 = new JPanel();
        
        jframe1.setBounds(1,1,2000,1000);

        jframe1.add(jpanel2); // 面板添加入窗口
        jframe1.add(jpanel1);

        jpanel1.setSize(new Dimension(800,200));
        jpanel1.setBackground(Color.BLUE);
        jpanel2.setSize(new Dimension(800,200));
        jpanel2.setBackground(Color.CYAN);

        JButton jbt1 = new JButton("Button1"); // 按钮1

        jpanel1.add(jbt1); // 按钮1添加入面板

        JTextField jtextfield1 = new JTextField("", 18); // 长度18列的，显示的文本框

        jpanel1.add(jtextfield1); // 文本框添加入面板

        jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭时操作

        jframe1.setVisible(true); // 设置可见

        // 创建响应动作监听器类，重写ActionListener接口的actionPerformed()方法

        class jbt1_hander implements ActionListener

        {

            @Override

            public void actionPerformed(ActionEvent e)

            {

                jtextfield1.setText("单击Button1 " + (++clicknum) + " 次");

            }

        }

        // 为按钮注册（添加）动作监听器

        jbt1.addActionListener(new jbt1_hander());

    }

}
// blog.csdn.net/msh2016/article/details/104362494