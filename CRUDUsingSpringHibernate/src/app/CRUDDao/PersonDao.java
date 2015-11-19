package app.CRUDDao;

import java.util.List;

import app.Entities.Person;

public interface PersonDao {
	public void add(Person person);
	public void edit(Person person);
	public void delete(int personId);
	public Person getPerson(String userName);
	public List<Person> getAllPersons();
	public Person getPerson(int personId);
}
