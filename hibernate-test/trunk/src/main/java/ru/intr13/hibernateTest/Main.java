package ru.intr13.hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = (new AnnotationConfiguration()).configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Parent parent = new Parent();
		session.saveOrUpdate(parent);
		System.out.println(parent.getId());
		Child child1 = new Child();
		child1.setParent(parent);
		session.saveOrUpdate(child1);
		Child child2 = new Child();
		child2.setParent(parent);
		session.saveOrUpdate(child2);
		Child child3 = new Child();
		child3.setParent(parent);
		session.saveOrUpdate(child3);
		System.out.println(child3.getId());
		System.out.println(child3.getParent());
		System.out.println(((Parent) session.get(Parent.class, parent.getId())).getChilds());
		transaction.commit();

		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		System.out.println(((Parent) session.get(Parent.class, parent.getId())).getChilds().size());
		transaction.rollback();

		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		// ((Parent) session.get(Parent.class, parent.getId())).getChilds().remove(child);
		session.delete((Child) session.get(Child.class, child3.getId()));
		// session.flush();
		// System.out.println(((Parent) session.get(Parent.class, parent.getId())).getChilds().size());
		transaction.commit();

		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		System.out.println(((Parent) session.get(Parent.class, parent.getId())).getChilds().size());
		transaction.rollback();

		// session = sessionFactory.getCurrentSession();
		// transaction = session.beginTransaction();
		// session.delete((Child) session.get(Child.class, child1.getId()));
		// session.delete((Child) session.get(Child.class, child2.getId()));
		// transaction.commit();

		// session = sessionFactory.getCurrentSession();
		// transaction = session.beginTransaction();
		// System.out.println(((Parent) session.get(Parent.class, parent.getId())).getChilds().size());
		// transaction.rollback();


		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		session.delete((Parent) session.get(Parent.class, parent.getId()));
		transaction.commit();
	}

}
