package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class JRadioButtonClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JRadioButtonClass() {
		setLayout(new FlowLayout());

		URL url = JRadioButtonClass.class.getResource("wo.png");
		Icon icon = new ImageIcon(url);
		Container container = getContentPane();
		// 1.������ѡ��ť
		JRadioButton jr1 = new JRadioButton("��ѡ��ť1", icon, true);
		jr1.setSelected(true);
		JRadioButton jr2 = new JRadioButton("��ѡ��ť2");
		JRadioButton jr3 = new JRadioButton("��ѡ��ť3");
		// 2.����ѡ��ť��ӵ���ť����
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
