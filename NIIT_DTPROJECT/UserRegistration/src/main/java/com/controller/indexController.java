package com.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Servlet implementation class indexController
 */
@Controller
public class indexController {
	@RequestMapping(value = { "/", "/home" })
	public String showMessage() {
		System.out.println("in controller");
		return "index";
	}

	@RequestMapping("/signin")
	public String Login() {
		return "signin";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String register(@RequestParam("username") String username, @RequestParam("password1") String password1,
			@RequestParam("password2") String password2, @RequestParam("email") String email,
			@RequestParam("dob") Date dob) throws ClassNotFoundException, SQLException {
		if (password1.equals(password2)) {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_db", "root", "root");
			String query1 = "INSERT INTO userdetails VALUES (?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setString(1, username);
			ps.setString(2, password1);
			ps.setString(3, password2);
			ps.setString(4, email);
			ps.setDate(5, (java.sql.Date) dob);
			int i = ps.executeUpdate();
			System.out.println(i);
			return "success";
		} else {
			return "passwordincorect";
		}
	}

	@RequestMapping(value = "/signInCtrl", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_db", "root", "root");
		String query1 = "SELECT * FROM userdetails WHERE username=?";
		PreparedStatement ps = con.prepareStatement(query1);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString("username") + rs.getString("password1"));
			String uname = rs.getString(1);
			String pass = rs.getString(2);
			if ((username.equals(uname)) && (password.equals(pass)))
				return "loginSuccess";

			else
				return "loginFailure";
		}
		return "loginSuccess";

	}

}
