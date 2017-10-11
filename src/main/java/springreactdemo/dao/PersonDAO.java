package springreactdemo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springreactdemo.model.AliveStatusEnum;
import springreactdemo.model.Person;

@Repository
public class PersonDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Person> findAll() {
        String sql = "SELECT p.id, p.firstName, p.lastName, p.aliveStatus FROM Person p;";
        List<Person> people = jdbcTemplate.query(sql, new PersonRowMapper());
        return people;
    }
    
    public Person findById(Integer id) {
        String sql = "SELECT id, firstName, lastName, aliveStatus FROM Person where id = ?;";
        Person person = (Person)jdbcTemplate.queryForObject(sql, new Object[] { id } , new PersonRowMapper());
        return person;
    }
    
    public void addPerson(Person person) {
        String sql = "INSERT INTO Person (firstName, lastName, aliveStatus) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), person.getAliveStatus().getName());
    }
    
    public class PersonRowMapper implements RowMapper
    {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("firstName"));
            person.setLastName(rs.getString("lastName"));
            person.setAliveStatus(AliveStatusEnum.get(rs.getString("aliveStatus")));
            return person;
        }
    }
}
