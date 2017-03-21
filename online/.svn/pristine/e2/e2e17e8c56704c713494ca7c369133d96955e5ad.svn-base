package cn.edu.xiyou.coursevideo;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.edu.xiyou.dao.CourseDao;
import cn.edu.xiyou.dao.CourseVideoDao;
import cn.edu.xiyou.dao.FileDao;
import cn.edu.xiyou.dao.SectionDao;
import cn.edu.xiyou.dao.SectionVideoDao;
import cn.edu.xiyou.entity.CourseVideo;
import cn.edu.xiyou.entity.Section;
import cn.edu.xiyou.entity.SectionVideo;
import cn.edu.xiyou.entity.User;
import cn.edu.xiyou.user.UserController;

import com.alibaba.fastjson.JSON;

import freemarker.template.TemplateException;

/**
 * 示例程序
 * 
 * @author lzp
 */

@Controller
@RequestMapping("/coursevideo")
public class CourseVideoController {


	private String uploader;// 上传人
	private Date uploadDate;// 上传日期
	private Long downloadcount = 0L;// 下载次数
	private Long fileSize;// 文件大小

	@Resource
	FileDao fileDao;
	
	@Resource
	private CourseDao courseDao;
	@Resource
	private CourseVideoDao courseVideoDao;
	@Resource
	private SectionDao sectionDao;
	@Resource
	private SectionVideoDao sectionVideoDao;

	@RequestMapping("/index.html")
	public String index(String id) {
		return "index";
	}
	/**
	 * 张盼测试视频流页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/video_play1.html")
	public String video_play1(String id) {
		return "html/course/video_play1";
	}
	/**
	 * 郑祥瑞测试视频流页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/video_play2.html")
	public String video_play2(String id) {
		return "html/course/video_play2";
	}
	/**
	 * 郑就开发视频播放页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/video_play3.html")
	public String video_play3(String id) {
		return "html/course/video_play3";
	}
	
	/**
	 * 根据CouseVideoId取得详细信息
	 * 
	 * @param id
	 * @return
	 */
	public CourseVideo getCourseVideoById( String id){
		CourseVideo courseVideo=courseVideoDao.findOne(id);
		
		return courseVideo;
	}

	/**
	 * 根据CouseVideoId取得目录
	 * 
	 * @param courseVideoId
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public List<List<SectionVideo>> showSectionListByCourseVideoId(
			String courseVideoId) throws IOException, TemplateException {

		// 该大List中所存的每一个小List都对应一个章节，每一个小List中存着该章节所包含的所有视频SectionVideo
		List<List<SectionVideo>> allSectionVideos = new ArrayList<List<SectionVideo>>();

		// 先根据courseVideo查到所有的章节
		List<Section> sections = sectionDao
				.findByCourseVideoOrderBySectionNumAsc(courseVideoDao
						.findOne(courseVideoId));

		// 遍历每一个章节
		for (Section section : sections) {
			List<SectionVideo> sectionVideos = sectionVideoDao
					.findBySectionOrderBySvNumAsc(section); // 把章节所对应的SectionVideo拿出来，放到一个小的List里面
			allSectionVideos.add(sectionVideos); // 再把小List方法大List里面
		}
		return allSectionVideos;
	}
	/**
	 * 播放器正式执行页面
	 * @param id
	 * @param sectionVideoId
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping("/video_play.html")
	public String showVideo_Play(String id, String sectionVideoId, HttpSession session, Map<String, Object> map
			, HttpServletResponse response)
			throws IOException, TemplateException {
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		User user = (User) session.getAttribute("user");
		if(user == null){
			return "html/user/user_login";
		}
		//根据CourseVideoId拿到所有Section和SectionVideo然后扔进freemarker
		List<List<SectionVideo>> sectionVideos = showSectionListByCourseVideoId(id);
		map.put("sectionVideos", sectionVideos);
		
		//如果传进sectionVideoId就将对应的sectionVideo扔进freemarker
		if( sectionVideoId != null && sectionVideoId != "" ){
			map.put("sectionVideo", sectionVideoDao.findOne(sectionVideoId));
		}
		System.out.println("sectionVideoId-----------------"+sectionVideoId);
		
		return "html/course/video_play";
	}
	/**
	 * 目录页面
	 * @param id
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@RequestMapping("/catalog_display.html")
	public String showCatalog_Display(String id, HttpSession session, Map<String, Object> map)
			throws IOException, TemplateException {
		UserController.loginValidate(session, map);		//进行用户登陆的判断
		
		List<List<SectionVideo>> sectionVideos = showSectionListByCourseVideoId(id);
		CourseVideo courseVideo=getCourseVideoById(id);
		map.put("sectionVideos", sectionVideos);
		map.put("courseVideo", courseVideo);

		return "html/course/coursevideo";
	}

	/**
	 * 添加视频
	 */
	/**
	 * 删除视频
	 */
	/**
	 * 修改视频
	 */
	/**
	 * 显示视频
	 */
	
	
	
	
	
	/**  导入视频*/
	/**
	 * EXCEL文件上传功能
	 * 
	 * @return
	 */
	@RequestMapping("/upload.do")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String s = "ok";// 前端页面显示的信息
		Map<String, Object> map = new HashMap<String, Object>();
		response.setCharacterEncoding("utf8");// 设置编码
		Writer writer = response.getWriter();
		// 上传地址
		String logoRealPathDir = request.getSession().getServletContext().getRealPath("/upload");
		System.out.println("上传地址为 :" + logoRealPathDir);
		// 创建文件存放目录
		File folder = new File(logoRealPathDir);
		if (!folder.exists())
			folder.mkdirs();
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request) == false) {
			s = "文件不存在请重新上传";
			map.put("data", s);
			writer.append(JSON.toJSONString(map));
		}
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String fileName = file.getOriginalFilename();
					StringBuffer displayName = new StringBuffer(fileName);
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (!(fileName.trim().equals(""))) {
						String type = fileName.substring(fileName.lastIndexOf(".") + 1);
						if (!type.equals("xls")) {
							s = "请使用模板或按照模板的方式上传";
							map.put("data", s);
							writer.append(JSON.toJSONString(map));
						} else {
							Integer sum = fileDao.findHaved(fileName);
							File localFile;
							if (sum != 0) {
								displayName.delete(0, displayName.length());
								String str = fileName.substring(0, fileName.lastIndexOf("."));
								displayName.append(str);
								displayName.append('(');
								displayName.append(sum);
								displayName.append(").");
								displayName.append(type);
								localFile = new File(logoRealPathDir + "/" + displayName);
							} else
								// 定义上传路径
								localFile = new File(logoRealPathDir + "/" + fileName);
							// 上传
							file.transferTo(localFile);
							// 在system中保存文件信息
							User user = (User) request.getSession().getAttribute("user");
							uploader = user.getName();
							Sheet sheet;
							Workbook book;
							int rows = 0;
							book = Workbook.getWorkbook(localFile);
							Sheet[] sheets = book.getSheets();
							for (int j = 0; j < sheets.length; j++) {
								sheet = book.getSheet(j);
								rows += sheet.getRows() - 1;
								if (rows < 0)
									rows = 2;
							}
							fileSize = file.getSize();
							uploadDate = new Date(System.currentTimeMillis());
							cn.edu.xiyou.entity.File excel = new cn.edu.xiyou.entity.File(fileName,
									displayName.toString(), logoRealPathDir, type, uploader, uploadDate, downloadcount,
									fileSize, "未导入", rows, 0);
							try {
								fileDao.save(excel);
							} catch (Exception e) {
								e.printStackTrace();
								s = "请不要同时上传多个同名文件";
								map.put("data", s);
								writer.append(JSON.toJSONString(map));
								return;
							}
							map.put("data", s);
							writer.append(JSON.toJSONString(map));
						}
					}
				}
			}
		}
		writer.flush();
		writer.close();
	}
	
	/**
	 * excel导入数据库
	 * @param id
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/push.do")
	@ResponseBody
	public String push(String id, HttpServletResponse response) throws UnsupportedEncodingException {
		if (id != null && !id.equals("")) {
			cn.edu.xiyou.entity.File system_file = fileDao.findById(id);// system_file
			StringBuffer sb = new StringBuffer();
			sb.append(system_file.getFilepath());
			sb.append("\\");
			sb.append(system_file.getFilename());
			java.io.File file = new File(sb.toString());// java.io.File
			Sheet sheet;
			Workbook book;
			try {
				book = Workbook.getWorkbook(file);
				Sheet[] sheets = book.getSheets();
				int rows = 0;
				for (int j = 0; j < sheets.length; j++) {
					// 获得工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
					sheet = book.getSheet(j);
					// 得到行数
					rows += sheet.getRows() - 1;
					// Student集合
					Set set = new HashSet();
					// 查出所有的学号
					ArrayList<String> snumbers;
					// 判断是否存在这个学生的变量
					boolean result = false;
					// 生成对象
					for (int i = 1; i <= rows; i++) {
						
					}
					if (!set.isEmpty())
						
					system_file.setFlag("已导入");
					system_file.setCount(set.size());
					system_file.setSum(rows);
					fileDao.save(system_file);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		} else {
			return "error";
		}
		return "ok";
	}

	
	/**
	 * 显示视频文件信息页面
	 */
	@RequestMapping("/load.do")
	public void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//创建实体类，和view然后遍历
	}

}
