package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Myconnect {
	public static void main(String args[]) throws Exception{
		CreatTable();
	}
	public static void CreatTable() throws Exception{
		try {
			Connection con=getconnection();
			PreparedStatement create=con.prepareStatement("CREATE TABLE IF NOT EXISTS firstschema.mamca(rno int(11),name varchar(45),m1 int(11),m2 int(11))");
			create.executeUpdate();
			PreparedStatement statement=con.prepareStatement("INSERT INTO firstschema.mamca(rno,name,m1,m2) values(?,?,?,?)");
		statement.setInt(1, 100002);
	statement.setString(2, "dharmambal");
	statement.setInt(3, 100);
	statement.setInt(4, 99);
	statement.setInt(1, 100003);
	statement.setString(2, "uma");
	statement.setInt(3, 90);
	statement.setInt(4, 99);
			int rowsInserted=statement.executeUpdate();
			if(rowsInserted>0)
			{
				System.out.println("Inserted successfully");
			}
			PreparedStatement statement2=con.prepareStatement("DELETE FROM firstschema.mamca WHERE rno=?");
			statement2.setInt(1, 10001);
			statement2.setInt(1, 10002);
		

		
			int rowsdeleted=statement2.executeUpdate();
			if(rowsdeleted>0)
			{
				System.out.println("rows deleted");
			}
			PreparedStatement statement3=con.prepareStatement("UPDATE firstschema.mamca SET name=?,m1=?,m2=? WHERE rno=?");
			
statement3.setString(1, "uma mahes");
statement3.setInt(2, 100);
statement3.setInt(3, 100);
statement3.setInt(4, 100003);
			int rowsupdated=statement3.executeUpdate();
			if(rowsupdated>0)
			{
				System.out.println("rows updated");
			}
			
			
			
			
} catch (Exception e) {
			System.out.println(e);
		}
		finally{System.out.println("Function completed");}
	
	
		
	
		
	}

	public static Connection getconnection() throws Exception
	{
		try {
			
		String url="jdbc:mysql://localhost:3306/firstschema";
			String user="root";
			String password="manjula";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1=DriverManager.getConnection(url,user,password);
			System.out.println("connected");
			return con1;

			
			
} catch (Exception e) {System.out.println(e);}
			
		return null;
	}
}
		