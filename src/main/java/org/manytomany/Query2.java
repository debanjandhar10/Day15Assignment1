package org.manytomany;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Given projectid, it returns the list of employees in the project
public class Query2 {

	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session session = sf.openSession();
        System.out.println("Enter project id:");
        Scanner sc = new Scanner(System.in);
        int pid = sc.nextInt();
        Project p = (Project) session.get(Project.class, pid);
        if (p == null) {
        	System.out.println("The given Project id does not exists");
        	sc.close();
        	return;
        }
        System.out.println("Employees working on project "+p.getPid()+":");
        for(Emp e: p.getEmps()) {
        	System.out.println(e.getName());
        }
        session.close();
        sc.close();
	}

}
