package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01 () {
		setTitle("GridLayoutTest");
		setLayout(new GridLayout(0, 3));
		
		add(new JButton("��ư 1"));
		add(new JButton("��ư 2"));
		add(new JButton("��ư 3"));
		add(new JButton("��ư 4"));
		add(new JButton("��ư 5"));
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx01();

	}

}
