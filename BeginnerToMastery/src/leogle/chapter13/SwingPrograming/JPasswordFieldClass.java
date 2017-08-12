package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.WindowConstants;

public class JPasswordFieldClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPasswordFieldClass() {
		setTitle("密码框组件");
		setLayout(new FlowLayout(1, 10, 10));
		Container container = getContentPane();
		JPasswordField jp = new JPasswordField(20);
		// 设置回显字符
		jp.setEchoChar('*');
		container.add(jp);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JPasswordFieldClass();
	}

}
