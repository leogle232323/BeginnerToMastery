package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Exercise3 extends JFrame {

	private static final long serialVersionUID = 1L;

	public Exercise3() {
		setTitle("练习3");
		// 设置容器为三行一列网格布局
		setLayout(new GridLayout(3, 1, 5, 5));
		Container container = getContentPane();
		// 设置三个panel,设置布局为流布局
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(1, 5, 5));
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(1, 5, 5));
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(1, 10, 10));

		JLabel jlb1 = new JLabel("用户名：");
		JLabel jlb2 = new JLabel("密    码：");
		JTextField jtf = new JTextField(5);
		JPasswordField jpf = new JPasswordField(5);
		jpf.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (jtf.getText().equals("mr") && String.valueOf(jpf.getPassword()).equals("mrsoft")) {
						JOptionPane.showMessageDialog(Exercise3.this, "登录成功！");
					} else {
						JOptionPane.showMessageDialog(Exercise3.this, "登录失败，用户名或密码错误！");
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		JButton jb1 = new JButton("提交");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (jtf.getText().equals("mr") && String.valueOf(jpf.getPassword()).equals("mrsoft")) {
					JOptionPane.showMessageDialog(Exercise3.this, "登录成功！");
				} else {
					JOptionPane.showMessageDialog(Exercise3.this, "登录失败，用户名或密码错误！");
				}
			}

		});
		JButton jb2 = new JButton("重置");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jtf.setText(null);
				jpf.setText(null);
			}

		});

		jp1.add(jlb1);
		jp1.add(jtf);
		jp2.add(jlb2);
		jp2.add(jpf);
		jp3.add(jb1);
		jp3.add(jb2);

		container.add(jp1);
		container.add(jp2);
		container.add(jp3);

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Exercise3();
	}

}
