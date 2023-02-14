package org.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateManyManyObjs {

	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setId(101);
		e1.setName("Deba");
		
		e2.setId(102);
		e2.setName("Mayukh");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(501);
		p1.setProjectname("HR Mgmt System");
		
		p2.setPid(502);
		p2.setProjectname("Automation System");

		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(e1);list1.add(e2);
		list2.add(p1);list2.add(p2);
		e1.setProjects(list2);e2.setProjects(list2);
		p1.setEmps(list1);
		p2.setEmps(list1);
		
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tx.commit();
        System.out.println("Creation Done");
	}

}
