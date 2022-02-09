package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 이선경
 *
 */
// 1. 플레이어는 좌우 이동이 가능하다. (x, y 좌표 필요)
// 2. 점프가 가능하다.
// 3. 방울 발사 (나중에 생각하자)

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR, playerL; // 콤마로 한번에 추가 가능

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // up, down

	private static final int JUMPSPEED = 2; // 점프할 때 이동하는 값. 고정
	private static final int SPEED = 4; // 좌우로 이동하는 값. 고정

	// getter
	public boolean isJump() {
		return isJump;
	}

	// setter
	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	// getter
	public boolean isRight() {
		return isRight;
	}

	// setter
	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	// getter
	public boolean isLeft() {
		return isLeft;
	}

	// setter
	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	// new 하는 것
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png"); // 플레이어가 오른쪽일 때
		playerL = new ImageIcon("image/playerL.png"); // 플레이어가 왼쪽일 때
	}

	// 각종 모든 세팅
	private void initSetting() {
		x = 70; // 제일 기본 위치
		y = 535; // 제일 기본 위치
		setIcon(playerR); // 제일 기본 이미지
		setSize(50, 50); // 기본 이미지 size 가로 세로 50
		setLocation(x, y); // Location 내부에서 paintComponent()를 호출함. Player가 호출 될 때마다 x, y의 값을 변경

		isRight = false; // 제일 기본 값. 오른쪽으로 움직이지 않음
		isLeft = false; // 제일 기본 값. 왼쪽으로 움직이지 않음
		isJump = false; // 제일 기본 값. 점프하지 않음
	}

	public void left() {
		isLeft = true; // 왼쪽으로 움직이는 중
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		// 메인 스레드가 너무 바빠서 버벅이는 것! 새로운 스레드 만들어서 일 시키기
		new Thread(() -> { // 람다식
			while (isLeft) { // isLeft = true
				x = x - SPEED; // SPEED만큼 이동
				setLocation(x, y); // Location 내부에서 paintComponent()를 호출함. Player가 호출 될 때마다 x, y의 값을 변경
				try { // 스레드는 무조건 트라이 캐치로 감싸기
					Thread.sleep(10); // 스레드는 아주 잠깐이라도 자야 함. left 메서드가 실행되는 간격
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start(); // 스레드 실행시키기
	}

	public void right() {
		isRight = true; // 오른쪽으로 움직이는 중
		System.out.println("오른쪽 이동");
		setIcon(playerR);

		// 메인 스레드가 너무 바빠서 버벅이는 것! 새로운 스레드 만들어서 일 시키기
		new Thread(() -> { // 람다식
			while (isRight) { // isRight = true
				x = x + SPEED; // SPEED만큼 이동
				setLocation(x, y); // Location 내부에서 paintComponent()를 호출함. Player가 호출 될 때마다 x, y의 값을 변경
				try { // 스레드는 무조건 트라이 캐치로 감싸기
					Thread.sleep(10); // 스레드는 아주 잠깐이라도 자야 함. right 메서드가 실행되는 간격
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start(); // 스레드 실행시키기
	}

	// 키보드 윗방향키
	public void jump() {
		System.out.println("점프");
		isJump = true; // 점프하는 중

		// 메인 스레드가 너무 바빠서 한번에 처리되어서 순간이동하는 것! 새로운 스레드 만들어서 일 시키기
		new Thread(() -> {
			// up
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // Location 내부에서 paintComponent()를 호출함. Player가 호출 될 때마다 x, y의 값을 변경

				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// down
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y); // Location 내부에서 paintComponent()를 호출함. Player가 호출 될 때마다 x, y의 값을 변경

				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 스레드 바깥에서 false하면 스택 종료되기도 전에 메인 스레드가 종료시키기 때문에 스레드 안에서 선언
			isJump = false;
		}).start();
	}
}
