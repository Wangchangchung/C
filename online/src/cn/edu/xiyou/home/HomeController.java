package cn.edu.xiyou.home;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xiyou.dao.CommentDao;
import cn.edu.xiyou.entity.Comment;
import cn.edu.xiyou.user.UserController;

/**
 * 首页
 * @author zhengjiu
 *
 */
@Controller
public class HomeController {
	
	@Resource
	private CommentDao commentDao;
	
	/**
	 * 在任何页面点击标题栏的课程，专业，专业时跳转的对应页面
	 * @return
	 */
	@RequestMapping(value={"/index.html","/index"})
	public String index(HttpSession session,Map<String, Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/index";
	}
	/**
	 * Java工程师树
	 * 每次加载树的时候同时加载对树的吐槽评论，将评论放到freemaker里面。
	 * 另外，每次提交评论后让其刷新树的页面，此时就会重新自动加载该方法并拿到评论。
	 * @return
	 */
	@RequestMapping("/tree1.html")
	public String tree(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		
		Sort sort = new Sort(Sort.Direction.DESC, "date");		//根据date正序排列
		Page<Comment> cPage = commentDao.findByJobid("1", new PageRequest(0, 3, sort) );
		map.put("comment", cPage.getContent());		//扔到freemaker中
		
		return "html/tree/tree1";
	}
	/**
	 * 前端工程师树
	 * @return
	 */
	@RequestMapping("/tree2.html")
	public String tree2(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		
		Sort sort = new Sort(Sort.Direction.DESC, "date");		//根据date正序排列
		Page<Comment> cPage = commentDao.findByJobid("2", new PageRequest(0, 3, sort) );
		map.put("comment", cPage.getContent());		//扔到freemaker中
		
		return "html/tree/tree2";
	}
	/**
	 * .NET工程师树
	 * 每次加载树的时候同时加载对树的吐槽评论，将评论放到freemaker里面。
	 * 另外，每次提交评论后让其刷新树的页面，此时就会重新自动加载该方法并拿到评论。
	 * @return
	 */
	@RequestMapping("/tree3.html")
	public String tree3(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		
		Sort sort = new Sort(Sort.Direction.DESC, "date");		//根据date正序排列
		Page<Comment> cPage = commentDao.findByJobid("3", new PageRequest(0, 3, sort) );
		map.put("comment", cPage.getContent());		//扔到freemaker中
		
		//System.out.println(JSONArray.toJSONString(cPage.getContent()));
		return "html/tree/tree3";
	}
	/**
	 * PHP工程师树
	 * 每次加载树的时候同时加载对树的吐槽评论，将评论放到freemaker里面。
	 * 另外，每次提交评论后让其刷新树的页面，此时就会重新自动加载该方法并拿到评论。
	 * @return
	 */
	@RequestMapping("/tree4.html")
	public String tree4(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		
		Sort sort = new Sort(Sort.Direction.DESC, "date");		//根据date正序排列
		Page<Comment> cPage = commentDao.findByJobid("4", new PageRequest(0, 3, sort) );
		map.put("comment", cPage.getContent());		//扔到freemaker中
		
		return "html/tree/tree4";
	}
	/**
	 * 电子商务专业
	 * @return
	 */
	@RequestMapping("/major1.html")
	public String major(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/major/major1";
	}
	/**
	 * 软件工程专业
	 * @return
	 */
	@RequestMapping("/major2.html")
	public String major2(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/major/major2";
	}
	/**
	 * 信息管理系统专业
	 * @return
	 */
	@RequestMapping("/major3.html")
	public String major3(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/major/major3";
	}
	/**
	 * 全部课程
	 * @return
	 */
	@RequestMapping("/all_course.html")
	public String all_course(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/all_find/all_course";
	}
	/**
	 * 全部专业
	 * @return
	 */
	@RequestMapping("/all_major.html")
	public String all_major(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/all_find/all_major";
	}
	/**
	 * 全部职业
	 * @return
	 */
	@RequestMapping("/all_job.html")
	public String all_job(HttpSession session, Map<String,Object> map){
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		return "html/all_find/all_job";
	}
	/**
	 * 计划编辑页面
	 * @return
	 */
	@RequestMapping("/plan_edit.html")
	public String plan_edit(){
		return "html/plan/plan_edit";
	}
	/**
	 * 计划执行页面
	 * @return
	 */
	@RequestMapping("/plan_execute.html")
	public String plan_execute(){
		return "html/plan/plan_execute";
	}
	/**
	 * 测试页面
	 * @return
	 */
	@RequestMapping("/test.html")
	public String test(){
		return "html/test";
	}
	
}
