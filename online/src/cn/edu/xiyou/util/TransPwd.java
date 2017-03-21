package cn.edu.xiyou.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.codec.digest.DigestUtils;

public class TransPwd {
	Connection conn = null;
	String url = "jdbc:mysql://222.24.63.102:3306/online?"
			+ "user=root&password=lzp110&useUnicode=true&characterEncoding=UTF8";

	void tp() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载MySQL驱动程序");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from user;");
			if (result != null) {
				conn.setAutoCommit(false);
				String updateSql = "update user set password=? where id=?";
				PreparedStatement ps = conn.prepareStatement(updateSql);
				while (result.next()) {
					System.out.println(result.getString(5) + "\t" + result.getString(6));
					String password = result.getString(6);
					String md5 = DigestUtils.md5Hex(password);
					ps.setString(1, md5);
					ps.setString(2, result.getString(1));
					ps.addBatch();
				}
				ps.executeBatch();
				conn.commit();
				ps.clearBatch();
				ps.close();
				result.close();
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new TransPwd().tp();
	}
}
