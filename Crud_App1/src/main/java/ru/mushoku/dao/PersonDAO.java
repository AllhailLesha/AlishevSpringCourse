package ru.mushoku.dao;

import org.springframework.stereotype.Component;
import ru.mushoku.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "Lesha"));
        people.add(new Person(2, "Kirill"));
        people.add(new Person(3, "Nikita"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
