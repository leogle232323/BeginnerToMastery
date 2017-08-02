package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class FlowLayoutClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public FlowLayoutClass() {
		setTitle("������ʹ�������ֹ�����");
		Container container = getContentPane();
		// 1.���ô���ʹ�������ֹ�������ʹ����Ҷ��룬�����������֮���ˮƽ����봹ֱ���
		setLayout(new FlowLayout(2, 10, 10));
		// 2.��������ѭ�����10����ť
		for (int i = 0; i < 10; i++) {
			container.add(new JButton("button" + i));
		}
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FlowLayoutClass();
	}

}
