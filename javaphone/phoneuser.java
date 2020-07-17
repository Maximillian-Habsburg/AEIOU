package javaphone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;
public class phoneuser {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = userInput.nextLine();
		System.out.println(username);
		System.out.println("输入手机号:");
		Long phone = userInput.nextLong();
		System.out.println(phone);
		System.out.println("输入密码:");
		Long password = userInput.nextLong();
		System.out.println(password);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://locathost:3306/phone","root","123456");
			String sql = "INSERT INTO USER(username,phone,password)VALUE('"+username+"','"+phone+"','"+password+"')";
			System.out.println(sql);
			Statement st =  (Statement) con.createStatement();
			boolean res = st.execute(sql);
			if(res){
				System.out.println("插入成功");
			}else{
				System.out.println("插入失败");
			}
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
}

}
