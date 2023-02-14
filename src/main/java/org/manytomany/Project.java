package org.manytomany;

import java.util.List;

import javax.persistence.*;

@Entity
public class Project {
	@Id
	private int pid;
	private String projectname;
	@ManyToMany(mappedBy="projects")
	private List<Emp> emps;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
