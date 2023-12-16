package university.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener {
	
	JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfX, tfXII, tfaadhar;
	JLabel labelrollno;
	JDateChooser dcdob;
	JComboBox cbcourse,cbbranch;
	JButton submit, cancel;

	Random ran = new Random();
	long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
	AddStudent()
	{
		
		setSize(900,700);
		setLocation(350,50);
		
		setLayout(null);
		
		JLabel heading = new JLabel("New Student Details");
		heading.setBounds(310,30,500,50);
		heading.setFont(new Font("seriff", Font.BOLD,30));
		add(heading);
		

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(50,150,100,30);
		lblname.setFont(new Font("seriff", Font.BOLD,20));
		add(lblname);
		
		
		tfname = new JTextField();
		tfname.setBounds(200,150,150,30);
		add(tfname);
		
		JLabel lblfname = new JLabel("Father's Name");
		lblfname.setBounds(400,150,200,30);
		lblfname.setFont(new Font("seriff", Font.BOLD,20));
		add(lblfname);
		
		
		tffname = new JTextField();
		tffname.setBounds(600,150,150,30);
		add(tffname);
		

		JLabel lblrollno = new JLabel("Roll Number");
		lblrollno.setBounds(50,200,200,30);
		lblrollno.setFont(new Font("seriff", Font.BOLD,20));
		add(lblrollno);
		
		labelrollno = new JLabel("2300"+first4);
		labelrollno.setBounds(200,200,200,30);
		labelrollno.setFont(new Font("seriff", Font.BOLD,20));
		add(labelrollno);
		
		JLabel lbldob = new JLabel("Date Of Birth");
		lbldob.setBounds(400,200,200,30);
		lbldob.setFont(new Font("seriff", Font.BOLD,20));
		add(lbldob);
		
		dcdob = new JDateChooser();
		dcdob.setBounds(600,200,150,30);
		add(dcdob);							
		
		JLabel lbladdress= new JLabel("Address");
		lbladdress.setBounds(50,250,200,30);
		lbladdress.setFont(new Font("seriff", Font.BOLD,20));
		add(lbladdress);
		
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,250,150,30);
		add(tfaddress);
		
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(400,250,200,30);
		lblphone.setFont(new Font("seriff", Font.BOLD,20));
		add(lblphone);
		
		
		tfphone = new JTextField();
		tfphone.setBounds(600,250,150,30);
		add(tfphone);
		
		JLabel lblemail= new JLabel("E-mail Id");
		lblemail.setBounds(50,300,200,30);
		lblemail.setFont(new Font("seriff", Font.BOLD,20));
		add(lblemail);
		
		
		tfemail = new JTextField();
		tfemail.setBounds(200,300,150,30);
		add(tfemail);
		
		
		JLabel labelX  = new JLabel("Class X (%)");
		labelX.setBounds(400,300,200,30);
		labelX.setFont(new Font("seriff", Font.BOLD,20));
		add(labelX);
		
		
		tfX = new JTextField();
		tfX.setBounds(600,300,150,30);
		add(tfX);
		
		JLabel lblXII= new JLabel("Class XII (%)");
		lblXII.setBounds(50,350,200,30);
		lblXII.setFont(new Font("seriff", Font.BOLD,20));
		add(lblXII);
		
		
		tfXII = new JTextField();
		tfXII.setBounds(200,350,150,30);
		add(tfXII);
		
		JLabel lblaadhar  = new JLabel("Aadhar Number");
		lblaadhar.setBounds(400,350,200,30);
		lblaadhar.setFont(new Font("seriff", Font.BOLD,20));
		add(lblaadhar);
		
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(600,350,150,30);
		add(tfaadhar);
		

		JLabel lblcourse  = new JLabel("Course");
		lblcourse.setBounds(50,400,200,30);
		lblcourse.setFont(new Font("seriff", Font.BOLD,20));
		add(lblcourse);
		
		
		String course[] = {"B.Tech","BBA","BCA","BSc","BA","BCom","MCA","MBA","MSc","M.Tech","MCom","MA"};
		cbcourse = new JComboBox(course);
		cbcourse.setBounds(200,400,150,30);
		cbcourse.setBackground(Color.WHITE);
		add(cbcourse);
		
		JLabel lblbranch  = new JLabel("Branch");
		lblbranch.setBounds(400,400,200,30);
		lblbranch.setFont(new Font("seriff", Font.BOLD,20));
		add(lblbranch);
		
		
		String branch[] = {"Computer Science","Electronics","Mechanical","IT","Civil","Electrical","Petroleum","Biotechnology"};
		cbbranch = new JComboBox(branch);
		cbbranch.setBounds(600,400,150,30);
		cbbranch.setBackground(Color.WHITE);
		add(cbbranch);
		
		submit = new JButton("Submit");
		submit.setBounds(300,550,120,30);
		// login.setBackground(Color.BLACK); For Background color
		//  login.setForeground(Color.WHITE); For the label written
		submit.addActionListener(this);
		submit.setFont(new Font("serif",Font.BOLD,15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(450,550,120,30);
		// cancel.setBackground(Color.BLACK); For Background color
		//  cancel.setForeground(Color.WHITE); For the label written
		cancel.addActionListener(this);
		cancel.setFont(new Font("serif",Font.BOLD,15));
		add(cancel);
		
	 	setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == submit) {
			
			String name = tfname.getText();
			String fname = tffname.getText();
			String rollno = labelrollno.getText();
			String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String X = tfX.getText();
			String XII = tfXII.getText();
			String aadhar = tfaadhar.getText();
			String course = (String) cbcourse.getSelectedItem();
			String branch = (String) cbbranch.getSelectedItem();
			
			try {
				String query = "insert into student values('"+name+"', '"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+X+"','"+XII+"','"+aadhar+"','"+course+"','"+branch+"')";
				
				Conn c = new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
				setVisible(false);
				
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		else {
			setVisible(false);
		}
	}

	public static void main(String args[]) {
		new AddStudent();
	}
	
}
