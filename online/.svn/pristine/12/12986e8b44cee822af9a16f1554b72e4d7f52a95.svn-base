package cn.edu.xiyou.job;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.xiyou.dao.JobDao;
import cn.edu.xiyou.dao.JobTypeDao;
import cn.edu.xiyou.entity.Job;
import cn.edu.xiyou.entity.JobType;
import cn.edu.xiyou.entity.PageBean;
import cn.edu.xiyou.json.CodeEnum;
import cn.edu.xiyou.json.JsonObject;
import cn.edu.xiyou.json.PageJson;
import cn.edu.xiyou.user.UserController;
import cn.edu.xiyou.util.DateUtil;

@Controller
@RequestMapping("/job")
public class JobController {

	@Resource
	private JobTypeDao jobTypeDao;

	@Resource
	private JobDao jobDao;

	@RequestMapping("/detail.html")
	public String detail(String id, Map<String, Object> map) {
		Job job = jobDao.findById(id);
		if (job != null) {
			map.put("job", job);
			map.put("date", DateUtil.dateConvertToString(job.getModified()));
		}
		return "html/job/detail";
	}

	@RequestMapping("/list.html")
	public String list(HttpSession session, String name, Map<String, Object> map, Integer page,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		UserController.loginValidate(session, map); // 进行用户登陆的判断
		Sort s = new Sort(Direction.DESC, "Modified");
		List<Job> jobs = jobDao.findByJobNameContaining(name == null ? "" : name,
				new PageRequest(page != null && page != 0 ? page - 1 : 0, 10, s));
		map.put("jobs", jobs);
		map.put("pages", new PageBean(page == null ? 1 : page, 10,
				jobDao.findByJobNameContaining(name == null ? "" : name).size()));
		map.put("page", page == null ? 1 : page);
		map.put("jobTypeList", jobTypeDao.findAll());
		map.put("name", name);
		return "html/job/list";
	}

	/**
	 * 添加职位
	 * 
	 */
	@RequestMapping(value = "/addJob.do")
	public void addCourse(String jobName, String jobType, String phone, String workType, String salary, String place,
			String longDesc, Writer writer) throws IOException {
		String s = "ok";
		Job job = new Job();
		job.setId();
		job.setModified(new Date());
		job.setJobName(jobName);
		JobType jt = jobTypeDao.findById(jobType);
		if (jt != null) {
			job.setJobType(jt);
		}
		job.setPhone(phone);
		if (workType != null && !workType.equals("")) {
			job.setWorkType(Integer.valueOf(workType));
		}
		job.setLongDesc(longDesc);
		job.setSalary(salary);
		job.setPlace(place);
		jobDao.saveAndFlush(job);
		writer.append(s);
		writer.flush();
		writer.close();
	}

	/**
	 * 添加行业
	 * 
	 */
	@RequestMapping(value = "/addJobType.do")
	public void addCourse(String name, Writer writer) throws IOException {
		String s = "ok";
		JobType jobType = new JobType();
		jobType.setId();
		jobType.setName(name);
		jobTypeDao.saveAndFlush(jobType);
		writer.append(s);
		writer.flush();
		writer.close();
	}

	/**
	 * 
	 * 根据职业名称查找职位
	 * 
	 * @param name
	 * @param page
	 *            查找页数
	 * @param writer
	 * @throws IOException
	 */
	@RequestMapping(value = "/findJob.do")
	public void findJob(String name, Integer page, Writer writer) throws IOException {
		Sort s = new Sort(Direction.DESC, "Modified");
		List<Job> list = jobDao.findByJobNameContaining(name,
				new PageRequest(page != null && page != 0 ? page - 1 : 0, 10, s));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobList", list);
		writer.append(JSON.toJSONString(map));
		writer.flush();
		writer.close();
	}

	@RequestMapping(value = "/list.do")
	@ResponseBody
	public void listforApp(int apptype, String userid, int size, Integer page, String name,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		Writer writer = response.getWriter();
		Sort s = new Sort(Direction.DESC, "Modified");
		List<Job> jobs = jobDao.findByJobNameContaining(name == null ? "" : name,
				new PageRequest(page != null && page != 0 ? page - 1 : 0, size, s));
		PageJson json = new PageJson();
		json.setCode(CodeEnum.SUCCESS.getCode());
		int count = jobDao.countByJobNameContaining(name);
		json.setCount(count);
		json.setPage((count % size == 0) ? count / size : count / size + 1);
		json.setMessage(CodeEnum.SUCCESS.getMessage());
		json.setData(jobs);
		writer.write(JSON.toJSONString(json));
		writer.flush();
		writer.close();
	}

	@RequestMapping(value = "/detail.do")
	@ResponseBody
	public void detail(int apptype, String userid, String id, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		Writer writer = response.getWriter();
		Job job = jobDao.findById(id);
		JsonObject json = new JsonObject();
		if (job != null) {
			json.setCode(CodeEnum.SUCCESS.getCode());
			json.setMessage(CodeEnum.SUCCESS.getMessage());
			json.setData(job);
		} else {
			json.setCode(CodeEnum.SERVERERROR.getCode());
			json.setMessage(CodeEnum.SERVERERROR.getMessage());
		}
		writer.write(JSON.toJSONString(json));
		writer.flush();
		writer.close();
	}
}
