package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JComboBoxClass extends JFrame {

	private static final long serialVersionUID = 1L;

	JComboBox<String> jc = new JComboBox<>(new MyComboBox());
	JLabel jl = new JLabel("请选择证件");

	public JComboBoxClass() {
		Container container = getContentPane();
		setTitle("下拉列表框组件");
		setLayout(new GridLayout(2, 1, 5, 5));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		// 设置默认选中第一个项目
		jc.setSelectedIndex(0);
		JTextArea jt = new JTextArea(5, 10);
		jt.setText(jc.getSelectedItem().toString() + " 被选中");
		JScrollPane js = new JScrollPane(jt);

		jp1.add(jl);
		jp1.add(jc);
		jp2.add(js);

		container.add(jp1);
		container.add(jp2);

		jc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jt.setText(jc.getSelectedItem().toString() + " 被选中");
			}

		});
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new JComboBoxClass();
	}
}

class MyComboBox extends AbstractListModel<String>implements ComboBoxModel<String> {
	private static final long serialVersionUID = 1L;
	String selectedItem = null;
	String[] test = { "身份证", "军人证", "学生证", "工作证" };

	// 返回下拉列表中项目中的数目
	@Override
	public int getSize() {
		return test.length;
	}

	// 根据索引返回值
	@Override
	public String getElementAt(int index) {
		return test[index];
	}

	// 设置下拉列表框项目
	@Override
	public void setSelectedItem(Object anItem) {
		selectedItem = (String) anItem;
	}

	// 获取下拉列表框中的项目
	@Override
	public Object getSelectedItem() {
		return selectedItem;
	}

}
