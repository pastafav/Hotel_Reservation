package packageA;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import packageB.*;



public class HotelReservation extends JPanel implements ActionListener, ItemListener, MouseListener {
	JFrame frame = new JFrame("Emerald Bay Hotel Reservation");
	JPanel p1 = new JPanel();
	JPanel p1_1 = new JPanel(); 
	JPanel p1_2 = new JPanel(); 
	JPanel p1_3 = new JPanel(); 
	JPanel p1_4 = new JPanel(); 
	JPanel p1_5 = new JPanel(); 
	JPanel p2 = new JPanel();
	JLabel name = new JLabel("Name: ");
	JLabel selectroom = new JLabel("Select room type: ");
	JLabel nights = new JLabel("Staying period (nights): ");
	JLabel services = new JLabel("Additional services: ");
	JLabel discount = new JLabel("Discount Code: ");
	JTextField name_tf = new JTextField(20);
	JTextField dc_tf = new JTextField(20);
	JTextField nights_tf = new JTextField(20);
	JCheckBox bf = new JCheckBox("Breakfast (20$)");
	JCheckBox spa = new JCheckBox("Spa (150$)");
	JCheckBox limo = new JCheckBox("Limousine (120$)");
	JButton proceed = new JButton("Proceed");
	double roomprice;
	double serviceprice;
	double ttroomprice;
	public static String text = "";
	public static double totalprice;
	public static double price_with_dc;
	
	//implicit casting
	RoomType reg = new RoomPrice("Regular", 170);
	RoomType del = new RoomPrice("Deluxe", 330);
	RoomType hon = new RoomPrice("Honeymoon Suite", 500);
	
	JRadioButton room1 = new JRadioButton(reg.getRoomtype() + "(170$ per night)");
	JRadioButton room2 = new JRadioButton(del.getRoomtype() + "(330$ per night)");
	JRadioButton room3 = new JRadioButton(hon.getRoomtype() + "(500$ per night)");
	
	Logo b = new Logo();
	
	public HotelReservation() {
		super();
		p1.setLayout(new GridLayout(5,1));
	
		p1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1_4.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1_5.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		selectroom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		room1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		room2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		room3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		nights.setFont(new Font("Times New Roman", Font.BOLD, 15));
		services.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		spa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		limo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		discount.setFont(new Font("Times New Roman", Font.BOLD, 15));
		proceed.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		p1_1.add(name); p1_1.add(name_tf);
		p1_2.add(selectroom); p1_2.add(room1); p1_2.add(room2); p1_2.add(room3);
		p1_3.add(nights); p1_3.add(nights_tf);
		p1_4.add(services); p1_4.add(bf); p1_4.add(spa); p1_4.add(limo);
		p1_5.add(discount); p1_5.add(dc_tf);
		
		p1.add(p1_1); p1.add(p1_2); p1.add(p1_3); p1.add(p1_4); p1.add(p1_5); 
		
		p2.add(proceed);
		
		room1.addItemListener(this);
		room2.addItemListener(this);
		room3.addItemListener(this);
		bf.addActionListener(this);
		spa.addActionListener(this);
		limo.addActionListener(this);
		proceed.addActionListener(this);
		dc_tf.addActionListener(this);
		b.addMouseListener(this);
		
		frame.setLayout(new BorderLayout());
		frame.add(b);
		frame.add(p1, BorderLayout.EAST);
		frame.add(p2, BorderLayout.SOUTH);
		frame.setSize(920,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == room1 && e.getStateChange() == 1) {
			room1.setSelected(true);
			room2.setSelected(false);
			room3.setSelected(false);
			roomprice = ((RoomPrice) reg).getRoomprice(); //explicit casting
			//System.out.println(roomprice);
		}
		else if(e.getSource() == room2 && e.getStateChange() == 1) {
			room1.setSelected(false);
			room2.setSelected(true);
			room3.setSelected(false);
			roomprice = ((RoomPrice) del).getRoomprice(); //explicit casting
			//System.out.println(roomprice);
		}
		else if(e.getSource() == room3 && e.getStateChange() == 1) {
			room1.setSelected(false);
			room2.setSelected(false);
			room3.setSelected(true);
			roomprice = ((RoomPrice) hon).getRoomprice(); //explicit casting
			//System.out.println(roomprice);
		}
			
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bf) {
			if(e.getSource() == bf && bf.isSelected()) {
				serviceprice += 20;
			}
			else {
				serviceprice -= 20;
			}
			//System.out.println(serviceprice);
		}
		if(e.getSource() == spa) {
			if(e.getSource() == spa && spa.isSelected()) {
				serviceprice += 150;
			}
			else {
				serviceprice -= 150;
			}
			//System.out.println(serviceprice);
		}
		if(e.getSource() == limo) {
			if(e.getSource() == limo && limo.isSelected()) {
				serviceprice += 120;
			}
			else {
				serviceprice -= 120;
			}
			//System.out.println(serviceprice);
		}
		
		if(e.getSource() == proceed) {
			double n = Double.parseDouble(nights_tf.getText());
			ttroomprice = roomprice*n;
			totalprice = ttroomprice + serviceprice;
			//System.out.println(totalprice = ttroomprice + serviceprice);
			
			text = dc_tf.getText();
			if(text.equals("LINS")) {
				price_with_dc = Math.round(totalprice * 0.85);
				//System.out.println(true);	
				//System.out.println(price_with_dc);
			}
			else {
				totalprice = ttroomprice + serviceprice;
				//System.out.println(false);
				//System.out.println(dc_tf.getText());
			}
			
			JFrame Reciept = new Reciept();
			Reciept.setVisible(true);
		}
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 
			
		
				
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if((e.getX() > 10) && (e.getX() < 40) && (e.getY() > 10) && (e.getY() < 40)) {
			p1_1.setBackground(new Color(237,233,227)); //ivory
			p1_2.setBackground(new Color(237,233,227));
			p1_3.setBackground(new Color(237,233,227));
			p1_4.setBackground(new Color(237,233,227));
			p1_5.setBackground(new Color(237,233,227));
			p2.setBackground(new Color(205,198,195)); //stone
			b.setBackground(new Color(231,215,201)); //nude
			room1.setBackground(new Color(237,233,227));
			room2.setBackground(new Color(237,233,227));
			room3.setBackground(new Color(237,233,227));
			bf.setBackground(new Color(237,233,227));
			spa.setBackground(new Color(237,233,227));
			limo.setBackground(new Color(237,233,227));
			//(212,178,167) dusty rose
			//(212,185,175) dusty rose edit

		}

		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if((e.getX() > 10) && (e.getX() < 40) && (e.getY() > 10) && (e.getY() < 40)) {
			p1_1.setBackground(getBackground());
			p1_2.setBackground(getBackground());
			p1_3.setBackground(getBackground());
			p1_4.setBackground(getBackground());
			p1_5.setBackground(getBackground());
			p2.setBackground(getBackground());
			b.setBackground(getBackground());
			room1.setBackground(getBackground());
			room2.setBackground(getBackground());
			room3.setBackground(getBackground());
			bf.setBackground(getBackground());
			spa.setBackground(getBackground());
			limo.setBackground(getBackground());

		}

		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}