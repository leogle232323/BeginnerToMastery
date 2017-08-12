package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FocusEventClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public FocusEventClass() {
		setTitle("焦点事件");
		setLayout(new FlowLayout(0, 10, 10));
		Container container = getContentPane();
		JTextField jt = new JTextField("请单击其他文本框", 10);
		JTextField jt2 = new JTextField("请单击我", 10);
		container.add(jt);
		container.add(jt2);
		jt.addFocusListener(new FocusListener() {
			// 组件获得焦点时，调用该方法
			@Override
			public void focusGained(FocusEvent e) {

			}

			// 组件失去焦点时，调用该方法
			@Override
			public void focusLost(FocusEvent e) {
				JOptionPane.showMessageDialog(FocusEventClass.this, "文本框失去焦点!");
			}

		});

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FocusEventClass();
	}

}
