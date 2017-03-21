package cn.edu.xiyou.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.edu.xiyou.base.BaseEntity;

@Entity
@Table(name = "system_file")
public class File extends BaseEntity {
	private String filename;// 文件名
	private String filepath;// 文件路径
	private String filetype;// 文件类型
	private String uploader;// 上传人
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploaddate;// 上传日期
	private Long downloadcount;// 下载次数
	private Long filesize;// 文件大小
	private String flag;// 状态
	private int sum;// 总记录数
	private int count;// 已导入数
	private String displayName;// 页面显示的文件名

	public File() {
	}

	public File(String filename, String displayName, String filepath, String filetype, String uploader, Date uploaddate, Long downloadcount,
			Long filesize, String flag, int sum, int count) {
		this.filename = filename;
		this.displayName = displayName;
		this.filepath = filepath;
		this.filetype = filetype;
		this.uploader = uploader;
		this.uploaddate = uploaddate;
		this.downloadcount = downloadcount;
		this.filesize = filesize;
		this.flag = flag;
		this.count = count;
		this.sum = sum;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public Long getDownloadcount() {
		return downloadcount;
	}

	public void setDownloadcount(Long downloadcount) {
		this.downloadcount = downloadcount;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
