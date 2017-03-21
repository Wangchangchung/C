package cn.edu.xiyou.comment;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xiyou.dao.CommentDao;
import cn.edu.xiyou.entity.Comment;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentDao commentDao;
	
	@RequestMapping("/submit.html")
	public void submit(String jobid, String text , Writer writer) throws IOException{
		System.out.println("CommentController.submit()");
		Comment con = new Comment();
		
		System.out.println(text + jobid);
		con.setJobid(jobid);
		con.setText(text);
		con.setDate(new Date());
		
		commentDao.saveAndFlush(con);
		writer.write("ok");
		writer.flush();
		writer.close();
	}
	
	
}
