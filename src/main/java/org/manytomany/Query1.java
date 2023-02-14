package org.manytomany;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Given empid, it returns the list of projects of the employee
public class Query1 {
	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session session = sf.openSession();
        System.out.println("Enter employee id:");
        Scanner sc = new Scanner(System.in);
        int eid = sc.nextInt();
        Emp e = (Emp) session.get(Emp.class, eid);
        if (e == null) {
        	System.out.println("The given employee id does not exists");
        	sc.close();
        	return;
        }
        System.out.println("Projects of employee "+e.getId()+":");
        for(Project p: e.getProjects()) {
        	System.out.println(p.getProjectname());
        }
        session.close();
        sc.close();
	}

}
