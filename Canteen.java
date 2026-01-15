import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canteen extends JFrame implements ActionListener, MouseListener
{
	private JPanel panel;
	private JLabel label1, label2, imgLabel;
	private JCheckBox cb1, cb2, cb3, cb4, cb5;
	private JButton bt;
	private Food f;

	public Canteen()
	{
		super("Canteen Management System");
		this.setSize(450, 650); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);
		// Changed background to white
		panel.setBackground(Color.WHITE);

		ImageIcon originalIcon = new ImageIcon("canteen.jpeg");
		Image image = originalIcon.getImage(); 
		
		// Resized to 350x120 to maintain the banner's wide aspect ratio
		Image newimg = image.getScaledInstance(350, 120, java.awt.Image.SCALE_SMOOTH); 
		ImageIcon scaledIcon = new ImageIcon(newimg);

		imgLabel = new JLabel(scaledIcon);
		// Centered the banner (450 width - 350 / 2 = 50)
		imgLabel.setBounds(50, 20, 350, 120); 
		panel.add(imgLabel);

		label1 = new JLabel("Select Food Items");
		// Lowered the Y-coordinate to 160 to give the logo space
		label1.setBounds(30, 160, 200, 20);
		label1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(label1);

		cb1 = new JCheckBox("Burger (150)");
		cb1.setBounds(30, 190, 150, 20);
		cb1.setBackground(Color.WHITE); 
		panel.add(cb1);

		cb2 = new JCheckBox("Sandwich (100)");
		cb2.setBounds(30, 220, 150, 20);
		cb2.setBackground(Color.WHITE);
		panel.add(cb2);

		cb3 = new JCheckBox("Drinks (50)");
		cb3.setBounds(30, 250, 150, 20);
		cb3.setBackground(Color.WHITE);
		panel.add(cb3);

		cb4 = new JCheckBox("Khichuri (120)");
		cb4.setBounds(30, 280, 150, 20);
		cb4.setBackground(Color.WHITE);
		panel.add(cb4);

		cb5 = new JCheckBox("Noodles (130)");
		cb5.setBounds(30, 310, 150, 20);
		cb5.setBackground(Color.WHITE);
		panel.add(cb5);

		bt = new JButton("Calculate Bill");
		bt.setBounds(30, 360, 130, 30);
		bt.setBackground(Color.GREEN);
		bt.setFocusable(false);
		panel.add(bt);

		label2 = new JLabel("Total: ");
		label2.setBounds(30, 410, 200, 25);
		label2.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(label2);

		bt.addActionListener(this);
		bt.addMouseListener(this);

		super.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		int total = 0;

		if(cb1.isSelected())
		{
			f = new Burger();
			total = total + f.getPrice();
		}
		if(cb2.isSelected())
		{
			f = new Sandwich();
			total = total + f.getPrice();
		}
		if(cb3.isSelected())
		{
			f = new Drinks();
			total = total + f.getPrice();
		}
		if(cb4.isSelected())
		{
			f = new Khichuri();
			total = total + f.getPrice();
		}
		if(cb5.isSelected())
		{
			f = new Noodles();
			total = total + f.getPrice();
		}

		label2.setText("Total: " + total);
	}

	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == bt)
		{
			bt.setBackground(Color.BLUE);
			bt.setForeground(Color.WHITE);
		}
	}

	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == bt)
		{
			bt.setBackground(Color.GREEN);
			bt.setForeground(Color.BLACK);
		}
	}

	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
}