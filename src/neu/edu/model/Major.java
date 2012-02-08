package neu.edu.model;

// Generated Apr 26, 2011 6:48:21 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Major generated by hbm2java
 */
@Entity
@Table(name = "MAJOR")
public class Major implements java.io.Serializable {

	private int majorId;
	private String majorName;
	private String advisor;

	public Major() {
	}

	public Major(String majorName, String advisor) {
		this.majorName = majorName;
		this.advisor = advisor;
	}

	@Id
	@GeneratedValue
	@Column(name = "MAJORID", nullable = false)
	public int getMajorId() {
		return this.majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	@Column(name = "MAJORNAME")
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Column(name = "ADVISOR")
	public String getAdvisor() {
		return this.advisor;
	}

	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}

}