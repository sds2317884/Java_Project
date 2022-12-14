package mainView;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class ViewerMain {
	private static JTextField nameInput;
	private static JTextField numInput;
	private static JTextField emailInput;
	private static JTextField phoneText01;
	private static JTextField phoneText02;
	private static JTextField phoneText3;
	private static JTable table;
	private static JTextField serchText;
	private static JLabel genderText;

	static String name;
	static String num;
	static String gender;
	static String phone;
	static String email;
	static String[] userData = new String[4];
	
	
	public static void main(String[] args) {
		
		AccessDB adb = new AccessDB();
		
		String tableHeader[] = {"학번", "이름", "성별", "전화번호", "이메일"};
		String tableContents[][] = {
				{"20221234", "홍길동", "남", "010-1234-1234", "email1234@gmail.com"},
				{"20221234", "홍길동", "남", "010-1234-1234", "email1234@gmail.com"}
		};
		
		JFrame viewer = new JFrame();
		
		viewer.setSize(400,700);
		viewer.getContentPane().setLayout(null);
		
		JLabel nameText = new JLabel("이름");
		nameText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		nameText.setHorizontalAlignment(SwingConstants.LEFT);
		nameText.setBounds(26, 44, 41, 32);
		viewer.getContentPane().add(nameText);
		
		JLabel numText = new JLabel("학번");
		numText.setHorizontalAlignment(SwingConstants.LEFT);
		numText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		numText.setBounds(187, 44, 41, 32);
		viewer.getContentPane().add(numText);
		
		JLabel emailText = new JLabel("이메일");
		emailText.setHorizontalAlignment(SwingConstants.LEFT);
		emailText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		emailText.setBounds(26, 88, 52, 32);
		viewer.getContentPane().add(emailText);
		
		JLabel genderText;
		genderText = new JLabel("성별");
		genderText.setHorizontalAlignment(SwingConstants.LEFT);
		genderText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		genderText.setBounds(249, 88, 41, 32);
		viewer.getContentPane().add(genderText);
		
		JLabel phoneText = new JLabel("연락처");
		phoneText.setHorizontalAlignment(SwingConstants.LEFT);
		phoneText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		phoneText.setBounds(26, 132, 52, 32);
		viewer.getContentPane().add(phoneText);
		
		nameInput = new JTextField();
		nameInput.setBounds(62, 44, 94, 32);
		viewer.getContentPane().add(nameInput);
		nameInput.setColumns(10);
		
		numInput = new JTextField();
		numInput.setColumns(10);
		numInput.setBounds(221, 44, 147, 32);
		viewer.getContentPane().add(numInput);
		
		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(72, 88, 165, 32);
		viewer.getContentPane().add(emailInput);
		
		phoneText01 = new JTextField();
		phoneText01.setColumns(10);
		phoneText01.setBounds(72, 132, 77, 32);
		viewer.getContentPane().add(phoneText01);
		
		phoneText02 = new JTextField();
		phoneText02.setColumns(10);
		phoneText02.setBounds(180, 132, 77, 32);
		viewer.getContentPane().add(phoneText02);
		
		phoneText3 = new JTextField();
		phoneText3.setColumns(10);
		phoneText3.setBounds(291, 132, 77, 32);
		viewer.getContentPane().add(phoneText3);
		
		JLabel phoneText_1 = new JLabel("-");
		phoneText_1.setHorizontalAlignment(SwingConstants.LEFT);
		phoneText_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		phoneText_1.setBounds(161, 132, 18, 32);
		viewer.getContentPane().add(phoneText_1);
		
		JLabel phoneText_1_1 = new JLabel("-");
		phoneText_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		phoneText_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		phoneText_1_1.setBounds(269, 132, 18, 32);
		viewer.getContentPane().add(phoneText_1_1);
		
		JRadioButton male = new JRadioButton("남");
		male.setBounds(283, 93, 52, 23);
		viewer.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("여");
		female.setBounds(327, 93, 52, 23);
		viewer.getContentPane().add(female);
		
		ButtonGroup genderBtn = new ButtonGroup();
		genderBtn.add(female);
		genderBtn.add(male);
		
		
		JComboBox serch = new JComboBox();
		serch.setBounds(26, 193, 94, 27);
		viewer.getContentPane().add(serch);
		
		serchText = new JTextField();
		serchText.setColumns(10);
		serchText.setBounds(126, 188, 110, 32);
		viewer.getContentPane().add(serchText);
		
		JTable table = new JTable(tableContents,tableHeader);
		table.setBounds(26, 232, 344, 357);
		viewer.getContentPane().add(table);
		
		JButton upload = new JButton("등록");
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				num = numInput.getText();
				userData[0] = nameInput.getText();
				phone = (phoneText01.getText() + "-" +phoneText02.getText() + "-" +phoneText3.getText());
				userData[1] = (phoneText01.getText() + "-" +phoneText02.getText() + "-" +phoneText3.getText());
				if(male.isSelected()) {
					gender = "남";
					userData[2] = "남";
				}else {
					gender = "여";
					userData[2] = "여";
				}
				email = emailInput.getText();
				userData[3] = emailInput.getText();
				
				if(adb.insert(num, userData[0], userData[1], userData[2], userData[3]) == 1) {
					System.out.println("저장에 성공하였습니다.");
				}else {
					System.out.println("중복된 데이터가 존재합니다.");
				}
			}
		});
		upload.setBounds(26, 601, 77, 65);
		viewer.getContentPane().add(upload);
		
		JButton shutdown = new JButton("종료");
		shutdown.setBounds(291, 601, 77, 65);
		viewer.getContentPane().add(shutdown);
		
		JButton delete = new JButton("삭제");
		delete.setBounds(201, 601, 77, 65);
		viewer.getContentPane().add(delete);
		
		JButton edit = new JButton("수정");
		edit.setBounds(112, 601, 77, 65);
		viewer.getContentPane().add(edit);
		
		JButton serchBtn = new JButton("조회");
		serchBtn.setBounds(237, 192, 62, 29);
		viewer.getContentPane().add(serchBtn);
		
		JButton serchAllBtn = new JButton("전체조회");
		serchAllBtn.setBounds(291, 192, 77, 29);
		viewer.getContentPane().add(serchAllBtn);
		
		
		viewer.setVisible(true);
	}
}
