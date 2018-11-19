package br.com.client.application;

import br.com.client.domain.PersonG;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath ("personController")
public interface PersonApplication extends RemoteService{

    public void save(PersonG person);
    public void update(PersonG person);
    public PersonG findById(int id);
    public void delete(PersonG person);
}