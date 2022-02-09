package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 이선경
 *
 */
// 1. 배경화면 설정
// 2. 캐릭터 추가
// 3. 캐릭터 좌우이동
// 4. 좌우 이동 스무스하게

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // paintComponent() 그림 다시 그리는 코드 보유중
	}

	// new 하는 것. 다른데서 안 쓰니까 private
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png")); // 레이블에 이미지 담기
		setContentPane(backgroundMap); // 컨테이너에 백그라운드 넣기

		// player 추가
		player = new Player();
		add(player);
	}

	// 각종 값 세팅. 다른데서 안 쓰니까 private
	private void initSetting() {
		setSize(1000, 640); // 프레임 크기 설정
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정. 앱솔루트 레이아웃
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	// 리스너 만들기. 다른데서 안 쓰니까 private
	private void initListener() {
		// key를 주시하는 리스너
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			// key 떼는 것을 주시하는 리스너
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 오른쪽 키가 떨어졌을 때
					// isRight를 false
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // 왼쪽 키가 떨어졌을 때
					// isLeft를 false
					player.setLeft(false);
				}
			}

			// key 누르는 것을 주시하는 리스너
			@Override
			public void keyPressed(KeyEvent e) {
				// KeyCode 왼쪽 : 37, 오른쪽 : 39, 위쪽 : 38, 아래쪽 : 40
				// System.out.println("키보드 프레스 : " + e.getKeyCode());

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// 키보드를 누르고 있는 동안 right() 메서드를 한번만 실행하고 싶다.
					if (player.isRight() == false) { // 오른쪽 이동하고 있지 않을 때 오른쪽 키 누르면 right() 실행
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// 키보드를 누르고 있는 동안 left() 메서드를 한번만 실행하고 싶다.
					if (player.isLeft() == false) { // 왼쪽 이동하고 있지 않을 때 왼쪽 키 누르면 left() 실행
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) { // 점프하고 있지 않을 때 위쪽 키 누르면 jump() 실행
						player.jump();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
