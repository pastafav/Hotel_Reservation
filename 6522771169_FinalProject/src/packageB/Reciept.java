package packageB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import packageA.HotelReservation;


public class Reciept extends JFrame implements ActionListener {
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JLabel lb1 = new JLabel("Discount: " );
	JLabel lb2 = new JLabel("Total price: ");
	JLabel em = new JLabel("Emerald Bay Hotel", JLabel.CENTER);
	JLabel notice = new JLabel("<html> *If you don't make a purchase within the time,<br> your reservation will be canceled </html>", JLabel.CENTER);
	JLabel time = new JLabel("", SwingConstants.CENTER);
	JButton purchase = new JButton("Purchase");
	JButton cancel = new JButton("Cancle");
	Timer timer = new Timer(1000, this);
	int i = 40;
	
	public Reciept() {
		
		timer.start();
		time.setFont(new Font("Times New Roman", Font.BOLD, 30));
		em.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lb1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lb2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		purchase.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		notice.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		notice.setForeground(new Color(230,178,167));
		
		if(HotelReservation.text.equals("LINS")) {
			lb1.setText("Discount: 15%");
			lb2.setText("Total price: " + HotelReservation.price_with_dc);
		}
		else {
			lb1.setText("Discount: Unavailable");
			lb2.setText("Total price: " + HotelReservation.totalprice);
		}
		
		purchase.addActionListener(this);
		cancel.addActionListener(this);
		
		p1.setLayout(new BorderLayout());
		p1.setBackground(new Color(212,185,175));
		p1.add(em);
		
		p2.setLayout(new GridLayout(2,1));
		p2.setBackground(new Color(205,198,195));
		p2.add(lb1);
		p2.add(lb2);
		
		p3.setLayout(new BorderLayout());
		p3.setBackground(new Color(163,143,133));
		p3.add(notice);
		
		p4.setLayout(new GridLayout(1,2));
		p4.add(purchase);
		p4.add(cancel);
		
		setTitle("Reciept");
		setLayout(new GridLayout(5,1));
		setSize(400,430);
		this.getContentPane().setBackground(new Color(237,233,227));
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(p1);
		add(p2);
		add(time);
		add(p3);
		add(p4);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ((e.getSource()!= purchase) && (e.getSource()!= cancel)) {
			time.setText(String.valueOf(i));
			i--;
			if (i <= -1) {
				timer.stop();
				time.setText("Payment Unsucessful");
				}
		}
		
		if(e.getSource() == purchase) {
			timer.stop();
			time.setText("Payment Sucessful");
			
		}
		
		if(e.getSource() == cancel) {
			timer.stop();
			time.setText("Payment Unsucessful");
		}
		
	}
	
	

}
