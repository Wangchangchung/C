package cn.edu.xiyou.base;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @功能 利用UUID生成主键
 * @author lzp
 * 
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 40, nullable = false, updatable = false)
	protected String id;

	public BaseEntity() {
		String s = UUID.randomUUID().toString();
		this.id = s;
	}
   
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setId() {
		String s = UUID.randomUUID().toString();
		this.id = s;
	}
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return getId().equals(other.getId());
	}
}
