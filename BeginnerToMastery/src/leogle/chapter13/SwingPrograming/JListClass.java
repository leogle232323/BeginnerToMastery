package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class JListClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JListClass() {
		setTitle("列表框组件");
		Container container = getContentPane();
		setLayout(null);
		// 1.使用ListModel提供初始化列表框参数
		JList<String> jList = new JList<>(new MyListModel());
		JScrollPane js = new JScrollPane(jList);
		js.setBounds(100, 100, 100, 100);
		container.add(js);

		// 2.使用数组作为初始化列表框的参数
		String[] contents = { "列表1", "列表2", "列表3", "列表4", "列表5" };
		JList<String> jList2 = new JList<>(contents);
		JScrollPane js2 = new JScrollPane(jList2);
		js2.setBounds(200, 200, 100, 100);
		container.add(js2);

		// 3.使用Vector类型数据作为初始化列表框的参数
		Vector<String> contents3 = new Vector<>();
		JList<String> jList3 = new JList<>(contents3);
		contents3.add("列表1");
		contents3.add("列表2");
		contents3.add("列表3");
		JScrollPane js3 = new JScrollPane(jList3);
		js3.setBounds(300, 300, 100, 100);
		container.add(js3);

		// 4.使用DefaultListModel创建列表框
		final String[] flavors = { "列表1", "列表2", "列表3", "列表4", "列表5", "列表6" };
		final DefaultListModel<String> items = new DefaultListModel<>();
		final JList<String> jList4 = new JList<>(items);
		for (int i = 0; i < flavors.length; i++) {
			items.addElement(flavors[i]);
		}
		JScrollPane js4 = new JScrollPane(jList4);
		js4.setBounds(300, 100, 100, 100);
		container.add(js4);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListClass();
	}

}

class MyListModel extends AbstractListModel<String> {

	private static final long serialVersionUID = 1L;
	// 设置列表框内容
	private String[] contents = { "列表1", "列表2", "列表3", "列表4" };

	@Override
	public int getSize() {
		return contents.length;
	}

	@Override
	public String getElementAt(int index) {
		if (index < contents.length) {
			return contents[index];
		} else {
			return null;
		}
	}

}
