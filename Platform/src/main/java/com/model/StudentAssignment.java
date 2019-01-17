package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

@Entity
public class StudentAssignment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "assignment_id", nullable = false)
	private Assignment assignment;

	@ManyToOne
	@JoinColumn(name = "student_cnp", nullable = false)
	private Student student;

	private Date lastUpdate;
	private Double grade;

	@Lob
	private byte[] fileContent;
	
	private String fileExtension;
	
	private String fileName;

	public byte[] getFile() {
		return fileContent;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Date getDeadline() {
		return assignment.getDeadline();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFile(File selectedUploadFile) {
		fileName = selectedUploadFile.getName();
		fileExtension = FilenameUtils.getExtension(selectedUploadFile.getName());
		try {
			InputStream inputSteam = new FileInputStream(selectedUploadFile);
			fileContent = IOUtils.toByteArray(inputSteam);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}