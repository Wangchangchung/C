package cn.edu.xiyou.course;
/**
 * 
 * 为了方便datatables建的一个view类
 * @author 郭磊
 *
 */
public class CourseView {

	private String id;
	/**
	 * 课程名称
	 */
	private String name;
	/**
	 * 短描述
	 */
	private String shortDesc;
	/**
	 * 长描述
	 */
	private String longDesc;
	/**
	 * 适用人群
	 */
	private String people;
	/**
	 * 图片路径
	 */
	private String imageUrl;
	/**
	 * 操作
	 */
	private String cz;
	/**
	 * 二级课程
	 */
	private String courseTypeTwoName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getCourseTypeTwoName() {
		return courseTypeTwoName;
	}
	public void setCourseTypeTwoName(String courseTypeTwoName) {
		this.courseTypeTwoName = courseTypeTwoName;
	}
	
}
