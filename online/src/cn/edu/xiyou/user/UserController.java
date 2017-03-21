package cn.edu.xiyou.user;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;

import cn.edu.util.mail.Mail;
import cn.edu.xiyou.dao.UserDao;
import cn.edu.xiyou.dao.UserTypeDao;
import cn.edu.xiyou.entity.User;
import cn.edu.xiyou.json.CodeEnum;
import cn.edu.xiyou.json.JsonObject;
import cn.edu.xiyou.util.FileUpload;

/**
 * 用户操作
 * 
 * @author zhengjiu
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserDao userDao;

	@Resource
	private UserTypeDao userTypeDao;

	/**
	 * 用户登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/login.html")
	public String user_login() {
		return "html/user/user_login";
	}

	/**
	 * 注册时，用户类型选择页面
	 * 
	 * @return
	 */
	@RequestMapping("/type_select.html")
	public String user_type_select() {
		return "html/user/user_type_select";
	}

	/**
	 * 用户注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/register.html")
	public String user_register(int type) {
		if(type == 1){
			
			return "html/user/university_register";
		}
		return "html/user/take_office_register";
	}

	/**
	 * 用户信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/userinfo.html")
	public String userinfo(String id, Map<String, Object> map) {
		User user = userDao.findById(id);
		map.put("user", user);
		return "html/user/user_info";
	}
	
	/**
	 * 用户信息修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/userUpdate.html")
	public String userupdate(String id, Map<String, Object> map) {
		User user = userDao.findById(id);
		map.put("user", user);
		return "html/user/userUpdate";
	}
	
	/**
	 * 用户信息修改页面
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/update.html")
	public String update(String id, String name, String university, String major, HttpServletResponse response) throws IOException {
		String msg = "error";
		User u = userDao.findById(id);
		if(u !=null){
			u.setName(name);
			u.setUniversity(university);
			u.setMajor(major);
			userDao.saveAndFlush(u);
			msg = "ok";
		}
		return "redirect:/user/userinfo.html";
	}
	
	/**
	 * 用户密码修改页面
	 * 
	 * @return
	 */
	@RequestMapping("/changePassword.html")
	public String changepassword(String id, Map<String, Object> map) {
		User user = userDao.findById(id);
		map.put("user", user);
		return "html/user/changePassword";
	}
	
	
	/**
	 * 管理员界面
	 * 
	 * @return
	 */
	@RequestMapping("/admin.html")
	public String adminUI(){
		return "html/admin/admin";
	}
	
	/**
	 * 注册成功页面
	 */
	@RequestMapping("success.html")
	public String success(){
		return "html/user/register_success";
	}
	/**
	 * 用户注册方法
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/submit.html")
	public String submit(String type, String email, String password,String name,
			String text1, String text2, String emailCode, Writer writer,
			HttpSession session) throws IOException {
		System.out.println(type);
		// System.out.println(username);
		System.out.println(password);
		System.out.println(emailCode);
		// System.out.println(password_again);
		System.out.println(text1);
		System.out.println(text2);

		// 验证数据
		if (EmailValidate(email) && PwdValidate(password)
				&& TextValidate(text1) && TextValidate(text2)
				&& EmailCodeValidate(session, emailCode)) {
			User user = new User();
			user.setUserType(userTypeDao.findOne(type));
			user.setEmail(email);
			String md5 = DigestUtils.md5Hex(password);
			user.setPassword(md5);
			user.setName(name);
			switch (type) {
			case "1":
				// 大学生
				user.setUniversity(text1);
				user.setMajor(text2);
				break;
			case "2":
				// 就职人员
				user.setCompany(text1);
				user.setPosition(text2);
				break;
			default:
				break;
			}
			userDao.saveAndFlush(user);
			session.setAttribute("user", user);
			return "html/user/register_success";
		} else {
			return "html/500";
		}
	}

	/**
	 * ajax 验证用户名是否存在
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/checkUserName.html")
	public void checkUserName(String email, Writer write) throws IOException {
		List<User> users = userDao.findByEmail(email);
		if (users.size() == 0) {
			write.append("error");
		} else {
			write.append("ok");
		}
		write.flush();
		write.close();
	}

	/**
	 * 发送验证码
	 * 
	 * @param session
	 * @param email
	 * @throws IOException
	 */
	@RequestMapping("/sendCode.html")
	public void sendCode(HttpSession session, String email, Writer write)
			throws IOException {

		// 生成随机验证码
		String rodm = (int) (Math.random() * 8999 + 1000) + "";

		String smtp = "smtp.163.com";
		String from = "icooc_net@163.com";
		String to = email;
		String copyto = "icooc_net@163.com";
		String subject = "验证码发送"; 
		// 编写邮箱内容
		String content = "欢迎注册icooc大学生职业教育网站，你的验证码为" + rodm;
		String username = "icooc_net@163.com";
		String password = "woshijay7788";
		// 发送邮件
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username,
				password);
		// 存验证码到Session
		session.setAttribute("eamilCode", rodm);
		write.append("ok");
		write.flush();
		write.close();
	}

	// 验证码验证
	public boolean EmailCodeValidate(HttpSession session, String eamilCode) {
		// 从session获得验证码
		String code = (String) session.getAttribute("eamilCode");
		System.out.println(code + "code--------------------");
		System.out.println(eamilCode + "eamilCode-----------------");

		// 判断传过来的验证码 为不为空
		if (eamilCode != null && !eamilCode.isEmpty()) {
			// 判断验证码是否正确
			if (eamilCode.equals(code)) {
				System.out.println("EmailCodeValidate+==========" + true);
				return true;
			} else {
				System.out.println("EmailCodeValidate+==========11" + false);
				return false;
			}
		} else {
			System.out.println("EmailCodeValidate+==========22" + false);
			return false;
		}
	}

	// 邮箱 验证
	public boolean EmailValidate(String email) {
		String str = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(str);
		Matcher mat = pattern.matcher(email);

		System.out.println("email +===================" + mat.matches());
		return mat.matches();

	}

	// 密码 验证
	public boolean PwdValidate(String password) {
		if (password != null && !password.isEmpty()) {
			if (password.length() > 18 || password.length() < 6) {
				System.out.println("pwd===================" + false);
				return false;
			} else {
				System.out.println("pwd===================" + true);
				return true;
			}
		} else {
			System.out.println("pwd===================" + false);
			return false;
		}
	}

	// 文本验证
	public boolean TextValidate(String text) {
		if (text != null && !text.isEmpty()) {
			System.out.println("Text=================" + true);
			return true;
		} else {
			System.out.println("Text=================" + false);
			return false;
		}
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/loginAction.html")
	public void loginAction(String username, String password,
			HttpSession session, Writer writer)
			throws IOException {
		if (username.equals("admin") || password.equals("password")) {
			User user = new User();
			user.setName("管理员");
			user.setPassword("password");
			session.setAttribute("user", user);
			writer.append("admin");
		} else {
			String md5 = DigestUtils.md5Hex(password);
			List<User> users = userDao.findByEmailAndPassword(username,
					md5);
			if (users.size() > 0) {
				session.setAttribute("user", users.get(0)); // 往session放入用户信息
				writer.append("ok");
			} else {
				writer.append("error");
			}
			writer.flush();
			writer.close();
		}
	}

	/**
	 * 验证session 看是否登录过
	 * 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	// @RequestMapping("/loginValidate.html")
	public static void loginValidate(HttpSession session,
			Map<String, Object> map) {
		User user = (User) session.getAttribute("user");
//		if (user == null) { // 判断用户是否登陆，然后往freemarker中放入判断的信息
//			map.put("login", "<a href='"
//					+ session.getServletContext().getAttribute("path")
//					+ "/user/login.html'>登陆</a>/<a href='"
//					+ session.getServletContext().getAttribute("path")
//					+ "/user/type_select.html'>注册</a>");
//		} else {
//			map.put("login", user.getName()
//					+ "/<a href='javascript:logout();'>退出登陆</a>");
//		}
		map.put("user", user);
	}

	@RequestMapping("/logoutAction.html")
	public void logoutAction(HttpSession session, Map<String, Object> map,
			Writer writer) throws IOException {
		session.removeAttribute("user");
		writer.append("ok");
		writer.flush();
		writer.close();
	}

	/**
	 * 验证密码并且修改
	 * @param password
	 */
	@RequestMapping("validatePassword.do")
	public void validatePassword(String password, String password1, String id, HttpServletResponse response) throws Exception{
		String msg = "error";
		Writer writer = response.getWriter();
		User user = userDao.findById(id);
		String oldPassword = user.getPassword();
		String newPassword = DigestUtils.md5Hex(password);
		if(oldPassword != null && oldPassword.equals(newPassword)){
			if(password1 != null){
				String npassword = DigestUtils.md5Hex(password1);
				user.setPassword(npassword);
				userDao.saveAndFlush(user);
			}
			msg = "ok";
		}
		writer.append(msg);
		writer.flush();
		writer.close();
	}
	
	
	/**
	 * 无线端登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/login.do")
	public void login(Integer apptype, String userid, String username, String password,
			HttpSession session, Writer writer)
			throws IOException {
			String md5 = DigestUtils.md5Hex(password);
			List<User> users = userDao.findByEmailAndPassword(username,
					md5);
			JsonObject json = new JsonObject();
			if (users.size() > 0) {
				 // 往session放入用户信息
				User user = users.get(0);
				json.setData(user);
				json.setCode(CodeEnum.SUCCESS.getCode());
				json.setMessage(CodeEnum.SUCCESS.getMessage());
			} else {
				json.setCode(CodeEnum.PASSWORDERROR.getCode());
				json.setMessage(CodeEnum.PASSWORDERROR.getMessage());
			}
			writer.write(JSON.toJSONString(json));
			writer.flush();
			writer.close();
	}
	
	/**
	 * 无线端修改密码
	 * @param apptype
	 * @param userid
	 * @param password
	 * @param newPassword
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("changePassword.do")
	public void changePassword(Integer apptype, String userid, String password, String newPassword, HttpServletResponse response) throws Exception{
		Writer writer = response.getWriter();
		User user = userDao.findById(userid);
		String oldPassword = user.getPassword();
		String password2 = DigestUtils.md5Hex(password);
		JsonObject json = new JsonObject();
		if(oldPassword != null && oldPassword.equals(password2)){
			if(newPassword != null){
				String npassword = DigestUtils.md5Hex(newPassword);
				user.setPassword(npassword);
				userDao.saveAndFlush(user);
				json.setCode(CodeEnum.SUCCESS.getCode());
				json.setMessage(CodeEnum.SUCCESS.getMessage());
			}else{
				json.setCode(CodeEnum.NULLERROR.getCode());
				json.setMessage(CodeEnum.NULLERROR.getMessage());
			}
		}else{
			json.setCode(CodeEnum.PASSWORDERROR.getCode());
			json.setMessage(CodeEnum.PASSWORDERROR.getMessage());
		}
		writer.write(JSON.toJSONString(json));
		writer.flush();
		writer.close();
	}
	
	/**
	 * 修改头像
	 * @param password
	 */
	@RequestMapping("changeHead.do")
	public void changeHead(Integer apptype, String userid, HttpServletResponse response, HttpServletRequest request) throws Exception{
		Writer writer = response.getWriter();
		User user = userDao.findById(userid);
		JsonObject json = new JsonObject();
		String path = FileUpload.upload(request);
		if(path != null){
			user.setHead(path);
			json.setCode(CodeEnum.SUCCESS.getCode());
			json.setMessage(CodeEnum.SUCCESS.getMessage());
			userDao.saveAndFlush(user);
		}else{
			json.setCode(CodeEnum.SERVERERROR.getCode());
			json.setMessage(CodeEnum.SERVERERROR.getMessage());
		}
		writer.write(JSON.toJSONString(json));
		writer.flush();
		writer.close();
	}
	
}
