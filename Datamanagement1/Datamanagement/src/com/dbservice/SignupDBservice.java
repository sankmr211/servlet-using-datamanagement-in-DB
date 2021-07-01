package com.dbservice;

import java.sql.*;
import com.dto.SignUpBeanClass;

public class SignupDBservice 
{
	Connection ct;
	PreparedStatement pst;
public SignupDBservice() 
{
try {
	Class.forName("com.mysql.jdbc.Driver");
	ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/data_manage","root","");

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}catch (SQLException se) {
	se.printStackTrace();
}	
}
public boolean save(SignUpBeanClass s)
{
	boolean bl=false;
	try {
		pst=ct.prepareStatement("insert into signup_user values(?,?,?,?,?,?)");
		pst.setString(1,s.getName());
		pst.setString(2,s.getPass());
		pst.setString(3,s.getGender());
		pst.setString(4,s.getCountry());
		pst.setString(5,s.getMobile());
		pst.setString(6,s.getAddress());
		int a=pst.executeUpdate();
		if(a>0)
		{
			bl=true;
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bl;
}
public boolean loginDetails(SignUpBeanClass sbc)
{
	boolean bo=false;
	try {
		pst=ct.prepareStatement("select * from signup_user where username=? and password=?");
	    pst.setString(1,sbc.getName());
	    pst.setString(2,sbc.getPass());
	    ResultSet rs=pst.executeQuery();
	    if(rs.next())
	    {
	    	bo=true;
	    }
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bo;
}
}
