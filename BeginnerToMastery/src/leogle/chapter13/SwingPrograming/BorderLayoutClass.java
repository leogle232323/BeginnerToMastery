package leogle.chapter13.SwingPrograming;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class BorderLayoutClass extends JFrame {

	private static final long serialVersionUID = 1L;
	// 1.��������ڷ�λ�õ�����
	String[] border = { BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.WEST,
			BorderLayout.EAST };
	String[] buttonName = { "center button", "north button", "south button", "west button", "east button" };

	public BorderLayoutClass() {
		setTitle("�������ʹ�ñ߽粼�ֹ�����");
		Container container = getContentPane();
		// 2.���ô���ʹ�ñ߽粼�ֹ�����
		setLayout(new BorderLayout());
		for (int i = 0; i < border.length; i++) {
			// 3.����������Ӱ�ť�������ð�ť����
			container.add(new JButton(buttonName[i]), border[i]);
		}

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new BorderLayoutClass();
	}

}
