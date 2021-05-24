package studentassingment.dto;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ClassDTO
 *
 */
@Entity
@Table(name = "class")
public class ClassDTO implements Serializable {

	
	

	
	@Id
	@Column(name="class_id")
	private String classId;
	@Column(name="class_name")
	private String className;
	
	public ClassDTO() {
		super();
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
   
}
