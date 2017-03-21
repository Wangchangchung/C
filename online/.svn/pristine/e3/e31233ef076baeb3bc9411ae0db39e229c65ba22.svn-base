package cn.edu.xiyou.share;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.xiyou.dao.ShareDao;
import cn.edu.xiyou.entity.PageBean;
import cn.edu.xiyou.entity.Share;
import cn.edu.xiyou.entity.User;
import cn.edu.xiyou.user.UserController;
import cn.edu.xiyou.util.DateUtil;


@Controller
@RequestMapping("share/")
public class ShareController {

	@Resource
	private ShareDao shareDao;
	
	@RequestMapping("share.html")
	public String index(HttpSession session, Map<String, Object> map, Integer page){
		UserController.loginValidate(session, map); // 进行用户登陆的判断
		Sort s=new Sort(Direction.DESC, "Modified");
		List<Share> shares = shareDao.findAll(new PageRequest(page != null && page != 0 ? page - 1 : 0, 10, s)).getContent();
		map.put("shares", shares);
		map.put("pages", new PageBean(page == null ? 1 : page, 10, shareDao.findAll().size()));
		map.put("page", page == null ? 1 : page);
		return "html/share/share";
	}
	
	@RequestMapping("publish.html")
	public String publish(HttpSession session,Map<String, Object> map){
		UserController.loginValidate(session, map); 
		return "html/share/publish";
	}
	
	@RequestMapping("add.do")
	public String add(String content, HttpSession session){
		User user = (User) session.getAttribute("user");
		if(!content.equals("")){
			Share share = new Share();
			share.setContent(content);
			share.setModified(new Date());
			share.setUser(user);
			share.setTime(DateUtil.dateConvertToString(new Date()));
			shareDao.saveAndFlush(share);
		}
		return "redirect: share.html "; 
	}
	
	@RequestMapping("upload.do")
	public String upload(@RequestParam("file")  
    MultipartFile image, HttpServletRequest request){
		String ctxPath = request.getSession().getServletContext().getRealPath(  
                "/")  
                + "\\" + "images\\";  
        System.out.println("路径：" + ctxPath);  
        //File file = new File(ctxPath + "/" + image.getOriginalFilename());  
        // FileCopyUtils.copy(image.getBytes(),new  
        // File(ctxPath+"/"+image.getOriginalFilename()));  
        try {  
            //image.transferTo(file); // 保存上传的文件  
        } catch (IllegalStateException e) {  
            e.printStackTrace();  
        } //catch (IOException e) {  
//            e.printStackTrace();  
//        }  
		return "redirect: share.html"; 
	}
	
}
