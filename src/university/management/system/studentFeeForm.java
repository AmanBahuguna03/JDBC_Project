package university.management.system;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.awt.event.*;

import javax.swing.*;

public class studentFeeForm extends JFrame implements ActionListener {

	Choice crollno;
	JComboBox cbcourse,cbbranch,cbsemester;
	JLabel labeltotal;
	JButton update,pay,back;
	
	studentFeeForm()
	{
		
		setSize(900,500);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new  ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,50,500,300);
		add(image);
		
		JLabel lblrollnumber = new JLabel("Select Roll No");
		lblrollnumber.setBounds(40,60,150,20);
		lblrollnumber.setFont(new Font("Tahoma", Font.PLAIN,16));
		add(lblrollnumber);
		
		crollno = new Choice();
		crollno.setBounds(200,60,150,20);
		add(crollno);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * from student");
			
			
			while(rs.next())
			{
					crollno.add(rs.getString("rollno"));
			}	
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(40,100,150,20);
		lblname.setFont(new Font("Tahoma", Font.BOLD,16));
		add(lblname);
		
		
		
		final JLabel labelname = new JLabel();
		labelname.setBounds(200,100,150,20);
		labelname.setFont(new Font("Tahoma", Font.PLAIN,16));
		add(labelname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(40,140,150,20);
		lblfname.setFont(new Font("Tahoma", Font.BOLD,16));
		add(lblfname);
		
		
		final JLabel labelfname = new JLabel();
		labelfname.setBounds(200,140,150,20);
		labelfname.setFont(new Font("Tahoma", Font.PLAIN,16));
		add(labelfname);
		
try {
			
			Conn c = new Conn();
			String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next())
			{
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				

			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}

crollno.addItemListener(new ItemListener() {
	public void itemStateChanged(ItemEvent ie) {
	
		try {
			
			Conn c = new Conn();
			String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next())
			{
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
}
});

JLabel lblcourse  = new JLabel("Course");
lblcourse.setBounds(40,180,150,20);
lblcourse.setFont(new Font("Tahoma", Font.BOLD,16));
add(lblcourse);


String course[] = {"BTech","BSc","BCA","BCom","MTech","MSc","MCA","MCom"};
cbcourse = new JComboBox(course);
cbcourse.setBounds(200,180,150,20);
cbcourse.setBackground(Color.WHITE);
add(cbcourse);

JLabel lblbranch  = new JLabel("Branch");
lblbranch.setBounds(40,220,150,20);
lblbranch.setFont(new Font("Tahoma", Font.BOLD,16));
add(lblbranch);


String branch[] = {"Computer Science","Electronics","Mechanical","IT","Civil","Electrical","Petroleum","Biotechnology"};
cbbranch = new JComboBox(branch);
cbbranch.setBounds(200,220,150,20);
cbbranch.setBackground(Color.WHITE);
add(cbbranch);

JLabel lblsemester = new JLabel("Semester");
lblsemester.setBounds(40,260,150,20);
lblsemester.setFont(new Font("Tahoma", Font.BOLD,16));
add(lblsemester);

String semester[] = {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
cbsemester = new JComboBox(semester);
cbsemester.setBounds(200,260,150,20);
cbsemester.setBackground(Color.WHITE);
add(cbsemester);

JLabel lbltotal = new JLabel("Total Payable");
lbltotal.setBounds(40,300,150,20);
lbltotal.setFont(new Font("Tahoma", Font.BOLD,16));
add(lbltotal);

labeltotal = new JLabel();
labeltotal.setBounds(200,300,500,20);
labeltotal.setFont(new Font("Tahoma", Font.PLAIN,16));
add(labeltotal);

update = new JButton("Update");
update.setBounds(30,380,100,25);
update.setBackground(Color.BLACK); //For Background color
update.setForeground(Color.WHITE); //For the label written
update.addActionListener(this);
update.setFont(new Font("serif",Font.BOLD,15));
add(update);

pay = new JButton("Pay Fee");
pay.setBounds(150,380,100,25);
pay.setBackground(Color.BLACK); //For Background color
pay.setForeground(Color.WHITE); //For the label written
pay.addActionListener(this);
pay.setFont(new Font("serif",Font.BOLD,15));
add(pay);

back= new JButton("Back");
back.setBounds(270,380,100,25);
back.setBackground(Color.BLACK); //For Background color
back.setForeground(Color.WHITE); //For the label written
back.addActionListener(this);
back.setFont(new Font("serif",Font.BOLD,15));
add(back);


		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	
		if(ae.getSource()==update)
		{
			
			String course = (String) cbcourse.getSelectedItem();
			String semester = (String) cbsemester.getSelectedItem();
			try {
				
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
				while(rs.next())
				{
					labeltotal.setText(rs.getString(semester));
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==pay)
		{
			
			String rollno = crollno.getSelectedItem();
			String course = (String) cbcourse.getSelectedItem();
			String semester = (String) cbsemester.getSelectedItem();
			String branch = (String) cbbranch.getSelectedItem();
			String total = labeltotal.getText();
			
			try {
				
				Conn c = new Conn();
				String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "College Fee Submitted Successfully");
				setVisible(false);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}else
		{
			setVisible(false);
		}
		
	}
	
	public static void main(String args[])
	{
		new studentFeeForm();
	}
	
}
