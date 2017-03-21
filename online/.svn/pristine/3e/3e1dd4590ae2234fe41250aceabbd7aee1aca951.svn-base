package cn.edu.xiyou.admin;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xiyou.dao.CourseDao;
import cn.edu.xiyou.dao.CourseTypeTwoDao;
import cn.edu.xiyou.dao.JobDao;
import cn.edu.xiyou.dao.JobTypeDao;
import cn.edu.xiyou.entity.JobType;

@Controller
@RequestMapping("/admin")
public class AdminController {


	@Resource
	private CourseTypeTwoDao courseTypeTwoDao;

	@Resource
	private CourseDao courseDao;

	@Resource
	private JobDao jobDao;
	
	@Resource
	private JobTypeDao jobTypeDao;
	
	/**
	 * 管理员页面
	 * 
	 * @return
	 */
	@RequestMapping("/admin.html")
	public String admin() {
		return "html/admin/admin";
	}

	/**
	 * 上传视频页面
	 * 
	 * @return
	 */

	@RequestMapping("/uploadUI.html")
	public String uploadUI() {
		return "html/admin/uploadUI";
	}

	/**
	 * 添加课程页面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/addcourseUI.html")
	public String addcourseUI(Map<String, Object> map) {
		map.put("courseTypeTwo", courseTypeTwoDao.findAll());
		return "html/admin/addcourseUI";
	}

	/**
	 * 课程信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/courseUI.html")
	public String courseUI() {
		return "html/admin/courseUI";
	}

	/**
	 * EXCEL文件导入页面
	 * 
	 * @return
	 */
	@RequestMapping("/fileuploadUI.html")
	public String fileuploadUI() {
		return "html/admin/fileuploadUI";
	}

	@RequestMapping("/addJobUI.html")
	public String addJobUI(Map<String, Object> map) {
		List<JobType> jobTypeList = jobTypeDao.findAll();
		map.put("jobTypeList", jobTypeList);
		return "html/admin/addJobUI";
	}
	
	@RequestMapping("/addJobTypeUI.html")
	public String addJobTypeUI() {
		return "html/admin/addJobTypeUI";
	}
	
}
