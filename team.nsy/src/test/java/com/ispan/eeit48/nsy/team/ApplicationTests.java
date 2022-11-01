package com.ispan.eeit48.nsy.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	 @Autowired private DataSource dataSource;
	@Test
	void contextLoads() throws Exception{
		Connection conn=dataSource.getConnection();
		 String sql="select * from accounts";
		   	PreparedStatement pst=conn.prepareStatement(sql);
		   	ResultSet rs =pst.executeQuery();
		   	rs.next();
		   	       String getname=rs.getString("Companyname");
		   
		   	 String   getid=rs.getString("Accountid");
		   	 System.out.println("id1="+getid+"...name="+getname);
		   	conn.close();
		   	
		   	System.out.println("duck is good");
	}
	@Test
	void contextLoads2() throws Exception{
		
		Connection conn=dataSource.getConnection();
		 String sql="select * from accounts";
		   	PreparedStatement pst=conn.prepareStatement(sql);
		   	ResultSet rs =pst.executeQuery();
		   	rs.next();
		   	       String getname=rs.getString("Companyname");
		   
		   	 String   getid=rs.getString("Accountid");
		   	 System.out.println("id2="+getid+"...name="+getname);
		   	conn.close();
		
	}
	
}

@SpringBootTest
class Application3 {
	@Autowired private DataSource dataSource;
	@Test
	void contextLoads2() throws Exception{
		
		Connection conn=dataSource.getConnection();
		 String sql="select * from accounts";
		   	PreparedStatement pst=conn.prepareStatement(sql);
		   	ResultSet rs =pst.executeQuery();
		   	rs.next();
		   	       String getname=rs.getString("Companyname");
		   
		   	 String   getid=rs.getString("Accountid");
		   	 System.out.println("id3="+getid+"...name="+getname);
		   	conn.close();
			System.out.println("duck is good");
		
	}
	
}



@SpringBootTest
class Application4 {
	@Autowired private DataSource dataSource;
	@Test
	void contextLoads2() throws Exception{
		
		Connection conn=dataSource.getConnection();
		 String sql="select * from accounts";
		   	PreparedStatement pst=conn.prepareStatement(sql);
		   	ResultSet rs =pst.executeQuery();
		   	rs.next();
		   	       String getname=rs.getString("Companyname");
		   
		   	 String   getid=rs.getString("Accountid");
		   	 System.out.println("id4="+getid+"...name="+getname);
		   	conn.close();
		
	}
	
}
