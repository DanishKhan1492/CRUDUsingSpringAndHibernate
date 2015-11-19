package app.CRUDDao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.CRUDDao.PersonDao;
import app.Entities.Person;

@Repository
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Person person) {
		sessionFactory.getCurrentSession().save(person);
	}

	@Override
	public void edit(Person person) {
		sessionFactory.getCurrentSession().update(person);
	}

	@Override
	public void delete(int personId) {
		sessionFactory.getCurrentSession().delete(getPerson(personId));;		
	}

	@Override
	public Person getPerson(String userName) {
		return (Person)sessionFactory.getCurrentSession().createQuery("from Person Where userName=:name").setString("name", userName).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		return sessionFactory.getCurrentSession().createQuery("from Person").list();
	}

	@Override
	public Person getPerson(int personId) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class, personId);
	}


}
