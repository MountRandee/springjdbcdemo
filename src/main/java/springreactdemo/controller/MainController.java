package springreactdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springreactdemo.dao.PersonDAO;
import springreactdemo.model.AliveStatusEnum;
import springreactdemo.model.Person;


@RestController
public class MainController {
    
    @Autowired 
    private PersonDAO personDAO;

    @RequestMapping(value="/add", method=RequestMethod.GET)
    @ResponseBody
    public String addNewPerson (
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String aliveStatus) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAliveStatus(AliveStatusEnum.get(aliveStatus));
        personDAO.addPerson(p);
        return "saved";
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ResponseBody
    public Person getPersonById(@RequestParam Integer id) {
        return personDAO.findById(id);
    }

    @RequestMapping(value="/all", method=RequestMethod.GET)
    @ResponseBody 
    public List<Person> getAll(){
        return personDAO.findAll();
    }
}