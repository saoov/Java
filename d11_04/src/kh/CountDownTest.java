package kh;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CountDownTest extends JFrame {
//Field
	private JLabel label;
	private JButton startBtn;
	private JTextField numberTF;

//내부클래스 : 클래스 안에 작성된 클래스
//Inner class / Nested class 라고 함
//내부클래스는 외부클래스의 멤버 개념이 적용이 됨
//내부클래스에는 static, private, protected 가 사용 가능함
	private class CountThread extends Thread {
		@Override
		public void run() {
			int startNumber = Integer.parseInt(numberTF.getText());
			for (int count = startNumber; count >= 0; count--) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(String.valueOf(count));
			}
		}
	}

//Constructor
	public CountDownTest() {
		this.setTitle("카운트다운 프로그램");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("시작");
//label.setText("Start");
		label.setFont(new Font("Serif", Font.BOLD, 100));
		label.setAlignmentX(CENTER_ALIGNMENT);
		this.add(label, BorderLayout.CENTER);
		startBtn = new JButton("카운트시작하기");
		this.add(startBtn, BorderLayout.SOUTH);
//버튼에 이벤트 설정함 : 익명(Anonymus) 클래스 이용
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//버튼을 클릭하면 스래드가 스타트되게 함
				new CountThread().start();
			}
		});
		numberTF = new JTextField("시작값을 입력하세요.");
		this.add(numberTF, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
// 스래드를 이용한 카운트다운 테스트
		new CountDownTest();
	}
}