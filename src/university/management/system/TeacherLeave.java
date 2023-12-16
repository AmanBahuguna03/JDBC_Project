package university.management.system;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class TeacherLeave extends JFrame implements ActionListener{

	Choice cempid, ctime;
	JDateChooser dcdate;
	JButton submit, cancel;
	
	TeacherLeave()
	{
		
		setSize(500,550);
		setLocation(550,100);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		JLabel heading = new JLabel("Apply Leave (Teacher)");
		heading.setBounds(40,50,300,30);
		heading.setFont(new Font("seriff", Font.BOLD,20));
		add(heading);
		
		JLabel lblempid = new JLabel("Search By Employee ID");
		lblempid.setBounds(60,100,200,20);
		lblempid.setFont(new Font("seriff", Font.PLAIN,18));
		add(lblempid);
		
		cempid = new Choice();
		cempid.setBounds(60,130,200,20);
		add(cempid);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from teacher");
			
			
			while(rs.next())
			{
				cempid.add(rs.getString("empid"));
			}	
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(60,180,200,20);
		lbldate.setFont(new Font("seriff", Font.PLAIN,18));
		add(lbldate);
		
		dcdate = new JDateChooser();
		dcdate.setBounds(60,210,200,30);
		add(dcdate);
		
		JLabel lbltime = new JLabel("Time Duration");
		lbltime.setBounds(60,260,200,20);
		lbltime.setFont(new Font("seriff", Font.PLAIN,18));
		add(lbltime);
		
		ctime = new Choice();
		ctime.setBounds(60,290,200,20);
		ctime.add("Full Day");
		ctime.add("Half Day");
		add(ctime);
		
		submit = new JButton("Submit");
		submit.setBounds(60,350,100,25);
		submit.setBackground(Color.BLACK); //For Background color
		submit.setForeground(Color.WHITE); //For the label written
		submit.addActionListener(this);
		submit.setFont(new Font("serif",Font.BOLD,15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(200,350,100,25);
		 cancel.setBackground(Color.BLACK); //For Background color
		 cancel.setForeground(Color.WHITE); //For the label written
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif",Font.BOLD,15));
		add(cancel);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae )
	{
		
		if(ae.getSource() == submit)
		{
			
			String empid = cempid.getSelectedItem();
			String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "insert into teacherLeave values('"+empid+"','"+date+"','"+duration+"')";
			
			try {
				
				Conn c = new Conn();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Confirmed");
				setVisible(false);
				
			}catch(Exception e)
			{
				
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
	
	
	public static void main(String args[])
	{
		
		new TeacherLeave();
		
	}
	
}
