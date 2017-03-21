package cn.edu.xiyou.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class FileUpload {

	  
    //文件上传  
    public static String uploadFile(MultipartFile file, String path, HttpServletRequest request) throws IOException {  
        String fileName = file.getOriginalFilename();  
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));  
        if (!tempFile.getParentFile().exists()) {  
            tempFile.getParentFile().mkdir();  
        }  
        if (!tempFile.exists()) {  
            tempFile.createNewFile();  
        }  
        file.transferTo(tempFile);  
        return "/download?fileName=" + tempFile.getName();  
    }  
    
    public static String upload(HttpServletRequest request){
    	
    	String path = "image/head";
    	
    	String realPath = request.getSession().getServletContext().getRealPath("/" + path);
    	
    	// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			 //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                	
                	realPath = realPath + "/" + new Date().getTime() + file.getOriginalFilename();
                	path = path + "/" + new Date().getTime() + file.getOriginalFilename();
                	File tempFile = new File(realPath);
                	if (!tempFile.getParentFile().exists()) {  
                        tempFile.getParentFile().mkdir();  
                    }  
                    if (!tempFile.exists()) {  
                        try {
							tempFile.createNewFile();
						} catch (IOException e) {
							return null;
						}  
                    } 
                	//上传
                    try {
						file.transferTo(tempFile);
					} catch (IllegalStateException e) {
						return null;
					} catch (IOException e) {
						return null;
					}
                }
                 
            }
		}
    	
    	return path;
    }
  
}
