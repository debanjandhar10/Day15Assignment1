package org.manytomany;
import java.util.List;

import javax.persistence.*;

@Entity
public class Emp {
	@Id
	private int id;
	private String name;
	@ManyToMany @JoinTable(name="EMP_PROJECT_REL")
	private List<Project> projects;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
