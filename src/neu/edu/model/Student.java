package neu.edu.model;

// Generated Apr 26, 2011 6:48:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name = "STUDENT")
public class Student implements java.io.Serializable {

	private int studentId;
	private String studentName;
	private String email;
	private String password;
	private String gender;
	private String birthday;
	private Major major;
	private String aboutMe;
	private byte[] photo;
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {
	}

	public Student(String studentName, String email, String password,
			String gender, String birthday, Major major, String aboutMe,
			byte[] photo, Set<Course> courses) {
		this.studentName = studentName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.aboutMe = aboutMe;
		this.photo = photo;
		this.courses = courses;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENTID", unique = true, nullable = false)
	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENTNAME")
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "GENDER")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "BIRTHDAY")
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "MAJORID")
	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@Column(name = "ABOUTME")
	public String getAboutMe() {
		return this.aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	@Column(name = "PHOTO", length = 100000)
	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENTID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "COURSEID", nullable = false, updatable = false) })
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}