package br.com.client.converter;
import br.com.client.domain.PersonG;
import br.com.domain.Person;

public class PersonConverter {

    private Person person;
    private PersonG personG;

    public Person personConverterG(PersonG personG){
        person = new Person();
        person.setCode(personG.getCode());
        person.setName(personG.getName());
        person.setEmail(personG.getEmail());
        person.setPhone(personG.getPhone());
        person.setCell(personG.getCell());
        return person;
    }

    public PersonG personConverter(Person person){
        personG = new PersonG();

        personG.setCode(person.getCode());
        personG.setName(person.getName());
        personG.setPhone(person.getPhone());
        personG.setCell(person.getCell());
        personG.setEmail(person.getEmail());
        return personG;
    }
}