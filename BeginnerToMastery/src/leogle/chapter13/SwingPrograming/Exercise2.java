package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Exercise2 extends JFrame {

	private static final long serialVersionUID = 1L;

	public Exercise2() {
		setTitle("练习2");
		setLayout(new FlowLayout(1, 5, 5));
		Container container = getContentPane();
		final String[] itemOut = { "项目1", "项目2", "项目3", "项目4" };
		JComboBox<String> jcb = new JComboBox<>();
		// 设置组件的首选大小
		jcb.setPreferredSize(new Dimension(300, 25));
		JButton jb = new JButton("点击我");
		jb.setPreferredSize(new Dimension(100, 25));
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int itemCount = jcb.getItemCount();
				List<String> itemIn = new ArrayList<>();
				for (int i = 0; i < itemCount; i++) {
					itemIn.add(jcb.getItemAt(i));
				}

				for (int j = 0; j < itemOut.length; j++) {
					if (!itemIn.contains(itemOut[j])) {
						jcb.addItem(itemOut[j]);
						break;
					} else if (j == itemOut.length - 1 && itemIn.contains(itemOut[j])) {
						JOptionPane.showMessageDialog(Exercise2.this, "所有项目都已添加");
					}
				}

			}

		});

		// 将下拉列表框和按钮添加进容器
		container.add(jcb);
		container.add(jb);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Exercise2();
	}

}
