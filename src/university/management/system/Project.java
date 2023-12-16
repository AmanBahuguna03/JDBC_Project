package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Project extends JFrame implements ActionListener {

	Project()
	{
		
		
		setSize(1540,850);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
		ImageIcon i3 = new  ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		
		JMenu newInfo = new JMenu("New Information");
		newInfo.setForeground(Color.BLUE);
		mb.add(newInfo);
		
		JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
		facultyInfo.setBackground(Color.WHITE);
		facultyInfo.addActionListener(this);
		newInfo.add(facultyInfo);
		
		JMenuItem studentInfo = new JMenuItem("New Student Information");
		studentInfo.setBackground(Color.WHITE);
		studentInfo.addActionListener(this);

		newInfo.add(studentInfo);
		
		setJMenuBar(mb);
		
		JMenu details = new JMenu("Details");
		details.setForeground(Color.RED);
		mb.add(details);
		
		JMenuItem facultyDetail = new JMenuItem("View Faculty Details");
		facultyDetail.setBackground(Color.WHITE);
		facultyDetail.addActionListener(this);
		details.add(facultyDetail);
		
		JMenuItem studentDetail = new JMenuItem("View Student Details");
		studentDetail.setBackground(Color.WHITE);
		studentDetail.addActionListener(this);
		details.add(studentDetail);
		
		JMenu leave = new JMenu("Apply Leave");
		leave.setForeground(Color.BLUE);
		mb.add(leave);
		
		JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
		facultyLeave.setBackground(Color.WHITE);
		facultyLeave.addActionListener(this);
		leave.add(facultyLeave);
		
		JMenuItem studentLeave = new JMenuItem("Student Leave");
		studentLeave.setBackground(Color.WHITE);
		studentLeave.addActionListener(this);
		leave.add(studentLeave);
		
		JMenu leaveDetails = new JMenu("Leave Details");
		leaveDetails.setForeground(Color.RED);
		mb.add(leaveDetails);
		
		JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
		facultyLeaveDetails.setBackground(Color.WHITE);
		facultyLeaveDetails.addActionListener(this);
		leaveDetails.add(facultyLeaveDetails);
		
		JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
		studentLeaveDetails.setBackground(Color.WHITE);
		studentLeaveDetails.addActionListener(this);
		leaveDetails.add(studentLeaveDetails);
		
		JMenu exams = new JMenu("Examination");
		exams.setForeground(Color.BLUE);
		mb.add(exams);
		
		JMenuItem examDetails = new JMenuItem("Results");
		examDetails.setBackground(Color.WHITE);
		examDetails.addActionListener(this);
		exams.add(examDetails);
		
		JMenuItem enterMarks = new JMenuItem("Enter Marks");
		enterMarks.setBackground(Color.WHITE);
		enterMarks.addActionListener(this);
		exams.add(enterMarks);
		
		JMenu updateInfo = new JMenu("Update Details");
		updateInfo.setForeground(Color.RED);
		mb.add(updateInfo);
		
		JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Information");
		updateFacultyInfo.setBackground(Color.WHITE);
		updateFacultyInfo.addActionListener(this);
		updateInfo.add(updateFacultyInfo);
		
		JMenuItem updateStudentInfo = new JMenuItem("Update Student's Information");
		updateStudentInfo.setBackground(Color.WHITE);
		updateStudentInfo.addActionListener(this);
		updateInfo.add(updateStudentInfo);
		
		JMenu fee = new JMenu("Fee Details");
		fee.setForeground(Color.BLUE);
		mb.add(fee);
		
		JMenuItem feeStructure = new JMenuItem("Fees Structure");
		feeStructure.setBackground(Color.WHITE);
		feeStructure.addActionListener(this);
		fee.add(feeStructure);
		
		JMenuItem feeForm = new JMenuItem("Student's Fee Submission Form");
		feeForm.setBackground(Color.WHITE);
		feeForm.addActionListener(this);
		fee.add(feeForm);
		
		
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.RED);
		mb.add(utility);
		
		JMenuItem calc = new JMenuItem("Calculator");
		calc.setBackground(Color.WHITE);
		calc.addActionListener(this);
		utility.add(calc);
		
		JMenuItem notePad = new JMenuItem("Notepad");
		notePad.setBackground(Color.WHITE);
		notePad.addActionListener(this);
		utility.add(notePad);
		
		JMenu about = new JMenu("About");
		about.setForeground(Color.BLUE);
		mb.add(about);
		
		JMenuItem ab = new JMenuItem("About");
		ab.setBackground(Color.WHITE);
		ab.addActionListener(this);
		about.add(ab);
		
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.RED);
		mb.add(exit);
		
		JMenuItem ex = new JMenuItem("Exit");
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		exit.add(ex);
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg = ae.getActionCommand();
				
		if(msg.equals("Exit"))
		{
			setVisible(false);
		}
		else if(msg.equals("Calculator"))
	   	{
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {}
	}
		else if(msg.equals("Notepad"))
		{
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {
				
			}
	}else if(msg.equals("New Faculty Information")) {
	
		new AddTeacher();
	
	}else if(msg.equals("New Student Information"))
	{
		
		new AddStudent();
		
	}else if(msg.equals("View Faculty Details"))
	{
		
		new TeacherDetail();
		
	}else if(msg.equals("View Student Details"))
	{
		
		new StudentDetails();
		
	}else if(msg.equals("Faculty Leave"))
	{
		
		new TeacherLeave();
		
	}else if(msg.equals("Student Leave"))
	{
		
		new StudentLeave();
		
	}else if(msg.equals("Faculty Leave Details"))
	{
		
		new TeacherLeaveDetails();
		
	}else if(msg.equals("Student Leave Details"))
	{
		
		new StudentLeaveDetails();
		
	}else if(msg.equals("Update Faculty Information"))
	{
		
		new updateTeacher();
		
	}else if(msg.equals("Update Student's Informations"))
	{
		
		new updateStudent();
		
	}else if(msg.equals("Results"))
	{
		
		new ExaminationDetails();
		
	}else if(msg.equals("Enter Marks"))
	{
		
		new EnterMarks();
		
	}else if(msg.equals("Fees Structure"))
	{
		
		new FeeStructure();
		
	}else if(msg.equals("About"))
	{
		
		new About();
		
	}else if(msg.equals("Student's Fee Submission Form"))
	{
		
		new studentFeeForm();
		
	}
}
	
	
	public static void main(String args[])
	{
		
		new Project();
		
	}
	
}
