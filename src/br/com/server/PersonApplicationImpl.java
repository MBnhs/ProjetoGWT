package br.com.server;
import br.com.client.application.PersonApplication;
import br.com.client.converter.PersonConverter;
import br.com.client.domain.PersonG;
import br.com.database.impl.PersonRepositoryImpl;
import br.com.domain.Person;
import br.com.domain.PersonRepository;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersonApplicationImpl extends RemoteServiceServlet implements PersonApplication{

    private static final long serialVersionUID = 1L;
    private PersonConverter pConverter;
    private PersonRepository pRep;
    private Person person;

    public PersonApplicationImpl() {
        pConverter = new PersonConverter();
        pRep = new PersonRepositoryImpl();
    }

    @Override
    public void save(PersonG personG) {
        person = pConverter.personConverterG(personG);
        pRep.save(person);
    }

    @Override
    public void update(PersonG person) {
        // TODO Auto-generated method stub
    }

    @Override
    public PersonG findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(PersonG person) {
        // TODO Auto-generated method stub
    }
}