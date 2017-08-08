package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ActionEventClass extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton jb = new JButton("我是按钮，单击我");

	public ActionEventClass() {
		setTitle("动作事件");
		setLayout(null);
		Container container = getContentPane();
		container.add(jb);
		jb.setBounds(10, 10, 300, 100);
		jb.addActionListener(new jbAction());
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	// 定义内部类实现监听器
	class jbAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jb.setText("我被单击了");
		}

	}

	public static void main(String[] args) {
		new ActionEventClass();
	}

}
