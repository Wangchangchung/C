package cn.edu.xiyou.test;

import cn.edu.util.mail.Mail;
import cn.edu.xiyou.user.UserController;

public class Test {

	public static void main(String[] args) {
		// 生成随机验证码
				String rodm = (int) (Math.random() * 8999 + 1000) + "";

				String smtp = "smtp.163.com";
				String from = "icooc_net@163.com";
				String to = "2834985520@qq.com";
				String copyto = "icooc_net@163.com";
				String subject = "验证码发送";
				// 编写邮箱内容
				String content = "你的验证码为" + rodm;
				String username = "icooc_net@163.com";
				String password = "woshijay7788";
				// 发送邮件
				
				// 生成随机验证码
//				String rodm = (int) (Math.random() * 8999 + 1000) + "";
//
//				String smtp = "smtp.163.com";
//				String from = "zhangpan521y@163.com";
//				String to = "2834985520@qq.com";
//				String copyto = "zhangpan521y@163.com";
//				String subject = "验证码发送";
//				// 编写邮箱内容
//				String content = "你的验证码为" + rodm;
//				String username = "zhangpan521y@163.com";
//				String password = "zhangpan521";
				
				
				
				Mail.sendAndCc(smtp, from, to, copyto, subject, content, username,
						password);
 
	}

}
