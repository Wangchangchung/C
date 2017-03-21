package cn.edu.xiyou.course;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xiyou.dao.CourseDao;
import cn.edu.xiyou.dao.CourseTypeTwoDao;
import cn.edu.xiyou.dao.CourseVideoDao;
import cn.edu.xiyou.entity.Course;
import cn.edu.xiyou.entity.CourseTypeTwo;
import cn.edu.xiyou.entity.CourseVideo;
import cn.edu.xiyou.user.UserController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import freemarker.template.TemplateException;

/**
 * Course业务Controller
 * 
 * @author zhangpan
 *
 */

@Controller
@RequestMapping("/course")
public class CourseController {

	@Resource
	private CourseDao courseDao;
	@Resource
	private CourseVideoDao courseVideoDao;
	@Resource
	private CourseTypeTwoDao courseTypeTwoDao;

	/**
	 * 展示课程基本信息的页面
	 * 
	 * @param id
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping("/show.html")
	public String showResoursByCourseId(String id, HttpSession session, Map<String, Object> map)
			throws IOException, TemplateException {
		UserController.loginValidate(session, map); // 进行用户登陆的判断
		/*
		 * 1、根据course id查询course信息
		 */
		Course course = courseDao.findOne(id);
		map.put("course", course);

		/*
		 * 2、根据course id查询courseVideo的信息
		 */
		List<CourseVideo> courseVideos = courseVideoDao.findByCourse(course);
		map.put("cv", courseVideos);

		return "html/course/course";

	}

	/**
	 * 网易云课程（临时）
	 * @return
	 */
	@RequestMapping("/wzycourse.html")
	public String wyzcourse(){

		return "html/course/wzycourse";

	}
	
	/**
	 * 在全部课程页面，根据前台所选type找到对应的课程（Ajax请求）
	 * 
	 * @param type
	 * @param page
	 * @param writer
	 * @throws IOException
	 */
	@RequestMapping("showCourseByType.html")
	public void showCourseByType(String type, int page, Writer writer, HttpSession session, Map<String, Object> map)
			throws IOException {
		UserController.loginValidate(session, map); // 进行用户登陆的判断
		String json = "";
		Page<Course> cpage = null;
		if ("all".equals(type)) {
			cpage = courseDao.findAll(new PageRequest(page, 16));
		} else {
			cpage = courseDao.findByCourseTypeTwoId(type, new PageRequest(page, 16));
		}

		if (cpage.getContent().size() > 0) {
			json = JSONArray.toJSONString(cpage);
		}

		writer.append(json);
		writer.flush();
		writer.close();
	}

	/**
	 * 显示后台课程信息
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("load.do")
	public void load(HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Writer writer = response.getWriter();
		List<CourseView> views = new ArrayList<CourseView>();
		ArrayList<CourseTypeTwo> courseTypeTwos = (ArrayList<CourseTypeTwo>) courseTypeTwoDao.findAll();
		List<Course> courses = courseDao.findAll();
		for (int i = 0; i < courses.size(); i++) {
			CourseView view = new CourseView();
			view.setId(courses.get(i).getId());
			view.setName(courses.get(i).getName());
			view.setShortDesc(courses.get(i).getShortDesc());
			view.setLongDesc(courses.get(i).getLongDesc());
			view.setPeople(courses.get(i).getPeople());
			/*
			 * String courseTypeTwoId = courses.get(i).getCourseTypeTwoId(); int
			 * courseTypeTwoIdNum =
			 * Integer.parseInt(courses.get(i).getCourseTypeTwoId());
			 * view.setCourseTypeTwoName(courseTypeTwos.get(courseTypeTwoIdNum).
			 * getName());
			 */
			view.setCourseTypeTwoName(courseTypeTwos.get(Integer.parseInt(courses.get(i).getCourseTypeTwoId())- 1).getName());
			view.setCz("<a href=\"javascript:;\" class=\"btn btn-circle btn-sm blue\" onclick=\"upd('"
					+ courses.get(i).getId() + "')\"><i class=\"fa fa-edit\"></i>修改</a>"
					+ "<a href=\"javascript:;\" class=\"btn btn-circle btn-sm red\" onclick=\"del('"
					+ courses.get(i).getId() + "')\"><i class=\"fa fa-remove\"></i>删除</a>");
			views.add(view);
		}
		map.put("data", views);
		writer.append(JSON.toJSONString(map));
		writer.flush();
		writer.close();

	}

	/**
	 * 添加课程
	 * 
	 */
	@RequestMapping(value = "/addcourse.do")
	public void addCourse(String name, String people, String shortDesc, String longDesc, String courseTypeTwoId,
			Writer writer) throws IOException {
		String s = "ok";
		Course c = new Course();
		c.setId();
		c.setName(name);
		c.setPeople(people);
		c.setShortDesc(shortDesc);
		c.setLongDesc(longDesc);
		c.setCourseTypeTwoId(courseTypeTwoId);
		courseDao.saveAndFlush(c);
		writer.append(s);
		writer.flush();
		writer.close();
	}
	/**
	 * 删除课程
	 */
	/**
	 * 修改课程
	 */
}
