package cn.edu.xiyou.sectionvideo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xiyou.dao.SectionVideoDao;
import cn.edu.xiyou.entity.SectionVideo;

/**
 * 单个视频控制器
 * 
 * @author zhangpan
 */

@Controller
@RequestMapping("/sectionvideo")
public class SectionVideoController {
	@Resource
	private SectionVideoDao sectionVideoDao;

	@RequestMapping("/index.html")
	public String index(String id) {
		return "index";
	}

	/**
	 * 根据单个视频是否能加载出来，修改数据库，用于记录该视频是否能播放
	 * 
	 * @param sectionvideoId
	 * @param state
	 * @return
	 */
	@RequestMapping("changestate.html")
	@ResponseBody
	public String changeState(String sectionvideoId, boolean state) {
		System.out.println("SectionVideoController.changeState()");
		System.out.println(sectionvideoId);
		SectionVideo sv = sectionVideoDao.findOne(sectionvideoId);
		if (sv.isSectionVideoState() != state) { // 当状态不同的时候才去修改，减少数据库交互
			sv.setSectionVideoState(state);
			sectionVideoDao.saveAndFlush(sv);
		}
		return "ok";
	}

	@RequestMapping("getonevideo.html")
	@ResponseBody
	public void getonevideo(String fileName, boolean state,
			HttpServletResponse response) throws IOException {
		String fileName2 = "c:\\sectionvideo" + fileName;
		System.out.println(fileName2);
		File file = new File(fileName2);
		// 如果文件存在
		if (file.exists()) {
			// 设置响应类型及响应头
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");
			// 读取文件
			InputStream inputStream = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			byte[] bytes = new byte[1024];
			ServletOutputStream outStream = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(outStream);
			int readLength = 0;
			while ((readLength = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, readLength);
			}
			// 释放资源
			inputStream.close();
			bis.close();
			bos.flush();
			outStream.close();
			bos.close();
		}
	}

}
