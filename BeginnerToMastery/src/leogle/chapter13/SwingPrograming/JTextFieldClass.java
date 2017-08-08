package leogle.chapter13.SwingPrograming;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JTextFieldClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JTextFieldClass() {
		setTitle("文本框组件");
		setLayout(new FlowLayout(0, 10, 10));
		Container container = getContentPane();
		final JTextField jt = new JTextField("aaa", 20);
		final JButton jb = new JButton("清除");
		container.add(jt, BorderLayout.NORTH);
		container.add(jb);
		jt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setText("触发事件");
			}

		});
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 将文本框置空
				jt.setText("");
				// 焦点回到文本框
				jt.requestFocus();
			}

		});

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTextFieldClass();
	}

}
