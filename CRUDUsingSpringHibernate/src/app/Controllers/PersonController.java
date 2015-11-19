package app.Controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import app.Entities.Person;
import app.Learning.PersonService.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String formSetup(Map<String,Object> model) {
		Person person = new Person();
		model.put("person", person);
		model.put("personList", personService.getAllPersons());
		return "person";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public String doActions(@ModelAttribute("person") Person person, BindingResult result, @RequestParam String action,Map<String,Object> model) {
		Person personResult = new Person();

		switch (action.toLowerCase()) {
		case "add":
			personService.add(person);
			personResult = person;
			break;

		case "edit":
			personService.edit(person);
			personResult = person;
			break;
		case "delete":
			personService.delete(person.getPersonId());
			personResult=new Person();
			break;
		case "search":
				Person searchedPerson=personService.getPerson(person.getUserName());
				personResult=searchedPerson != null ? searchedPerson : new Person();
			break;

		}

		model.put("person",personResult);
		model.put("personList", personService.getAllPersons());
		return "person";
	}
}
