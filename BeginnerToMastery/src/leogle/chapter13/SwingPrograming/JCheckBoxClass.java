package leogle.chapter13.SwingPrograming;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JCheckBoxClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JCheckBoxClass() {
		setLayout(new BorderLayout());
		Container container = getContentPane();

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		JCheckBox jc1 = new JCheckBox();
		JCheckBox jc2 = new JCheckBox();
		JCheckBox jc3 = new JCheckBox();

		JTextArea jt = new JTextArea(10, 20);

		final JScrollPane scrollPane = new JScrollPane(jt);
		panel1.add(scrollPane);
		container.add(panel1, BorderLayout.NORTH);

		container.add(panel2, BorderLayout.SOUTH);
		panel2.add(jc1);
		jc1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jc1.isSelected()) {
					jt.append("��ѡ�� 1 ��ѡ��\n");
				} else {
					jt.append("��ѡ��1 ��ȡ��ѡѡ�� \n");
				}

			}

		});

		panel2.add(jc2);
		panel2.add(jc3);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JCheckBoxClass();
	}

}