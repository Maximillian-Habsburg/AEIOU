package javaphone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Statement;
public class phoneuser {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("�������û���:");
		String username = userInput.nextLine();
		System.out.println(username);
		System.out.println("�����ֻ���:");
		Long phone = userInput.nextLong();
		System.out.println(phone);
		System.out.println("��������:");
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
				System.out.println("����ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
}

}
