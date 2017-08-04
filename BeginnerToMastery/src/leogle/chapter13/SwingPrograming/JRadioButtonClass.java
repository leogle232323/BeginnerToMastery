package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class JRadioButtonClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JRadioButtonClass() {
		setLayout(new FlowLayout());

		Container container = getContentPane();
		// 1.创建单选按钮
		JRadioButton jr1 = new JRadioButton();
		jr1.setSelected(true);
		JRadioButton jr2 = new JRadioButton();
		JRadioButton jr3 = new JRadioButton();
		// 2.将单选按钮添加到按钮组中
		ButtonGroup group = new ButtonGroup();
		group.add(jr1);
		group.add(jr2);
		group.add(jr3);

		container.add(jr1);
		container.add(jr2);
		container.add(jr3);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JRadioButtonClass();
	}

}
