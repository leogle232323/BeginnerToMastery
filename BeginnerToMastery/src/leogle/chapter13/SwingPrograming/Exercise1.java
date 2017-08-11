package leogle.chapter13.SwingPrograming;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Exercise1 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Exercise1() {
		setTitle("练习1");
		setLayout(new GridLayout(3, 1, 5, 5));
		Container container = getContentPane();
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(1, 5, 5));
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(1, 5, 5));
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(1, 5, 5));

		JComboBox<String> jc = new JComboBox<>(new MyComboBox1());
		jc.setSelectedIndex(0);
		jc.setPreferredSize(new Dimension(280, 30));
		JRadioButton jrb1 = new JRadioButton("男", true);
		JRadioButton jrb2 = new JRadioButton("女");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		JButton jb1 = new JButton("确定");
		JButton jb2 = new JButton("取消");

		jp1.add(jc);
		jp2.add(jrb1);
		jp2.add(jrb2);
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
		new Exercise1();
	}
}

class MyComboBox1 extends AbstractListModel<String>implements ComboBoxModel<String> {
	private static final long serialVersionUID = 1L;
	String selectedItem = null;
	String[] listItem = { "红", "黄", "蓝" };

	@Override
	public int getSize() {
		return listItem.length;
	}

	@Override
	public String getElementAt(int index) {
		return listItem[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		selectedItem = (String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

}

// icon类
class MyIcon implements Icon {
	private int width = 10;
	private int height = 10;

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.fillRect(x, y, width, height);
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}

}
