package app.Learning.PersonServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.CRUDDao.PersonDao;
import app.Entities.Person;
import app.Learning.PersonService.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDao;
	
	@Transactional
	public void add(Person person) {
		personDao.add(person);
	}

	@Transactional
	public void edit(Person person) {
		personDao.edit(person);
	}

	@Transactional
	public void delete(int personId) {
		personDao.delete(personId);
	}

	@Transactional
	public Person getPerson(String userName) {
		return personDao.getPerson(userName);
	}

	@Transactional
	public List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}
	
}	
