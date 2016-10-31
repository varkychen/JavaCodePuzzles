package java8.lambda;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface LearningCollectors {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Varghese", 35));
        persons.add(new Person("Tintu", 32));
        persons.add(new Person("Paul", 3));
        persons.add(new Person("Zach", 3));
        persons.add(new Person("Arjun", 33));
        persons.add(new Person("Poornima", 33));
        persons.add(new Person("Adwaith", 6));
        System.out.println("Persons : " +  
                persons.stream()
                .map(p -> String.format("%s[%d]", p.getName(), p.getAge()))
                .collect(joining(", ", "(", ")")));
        
        Map<Integer, List<String>> output = persons
                                            .stream()
                                            .collect(groupingBy(
                                                    Person::getAge, 
                                                    mapping(Person::getName, 
                                                            toList())));
        System.out.println(output);
    }
}