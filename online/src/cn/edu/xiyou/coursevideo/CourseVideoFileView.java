package cn.edu.xiyou.coursevideo;

import java.util.Date;


public class CourseVideoFileView {

	private String id;
	private String filename;// 文件名
	private String filepath;// 文件路径
	private String filetype;// 文件类型
	private String uploader;// 上传人
	private String uploaddate;// 上传日期
	private Long downloadcount;// 下载次数
	private String filesize;// 文件大小
	private String flag;// 状态
	private String cz;// 操作

	private String sum;// 总记录数
	private String count;// 已导入数

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public Long getDownloadcount() {
		return downloadcount;
	}

	public void setDownloadcount(Long downloadcount) {
		this.downloadcount = downloadcount;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCz() {
		return cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
