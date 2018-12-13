package lect10;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	public static void main (String rgsp[]) {
		AudioPlayer player = new AudioPlayer();
		
		JFrame frame = new JFrame("Player");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 80);
		frame.setLocation(1200, 600);
		
		JButton lock = new JButton("Lock");
		JButton prev = new JButton(" << ");
		JButton next = new JButton(" >> ");
		JButton play = new JButton("Play");
		
		lock.addActionListener(e -> {
			player.state.lock();
		});
		prev.addActionListener(e -> player.state.prev());
		next.addActionListener(e -> player.state.next());
		play.addActionListener(e -> {
			player.state.play();
			play.setText(play.getText().equals("Play")?"Stop":"Play");
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(lock);
		panel.add(prev);
		panel.add(play);
		panel.add(next);
		
		frame.add(panel);
	}
}
