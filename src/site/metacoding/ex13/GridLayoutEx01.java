package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01 () {
		setTitle("GridLayoutTest");
		setLayout(new GridLayout(0, 3));
		
		add(new JButton("버튼 1"));
		add(new JButton("버튼 2"));
		add(new JButton("버튼 3"));
		add(new JButton("버튼 4"));
		add(new JButton("버튼 5"));
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx01();

	}

}
