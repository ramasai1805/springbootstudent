package com.sai.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sai.dao.StudentDao;
import com.sai.model.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		List<Student> list = session.createQuery("from Student").list();
		return list;
	}

}
