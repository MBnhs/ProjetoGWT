package br.com.client.application;

import br.com.client.domain.PersonG;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersonApplicationAsync {

    void save(PersonG person, AsyncCallback<Void> callback);

    void update(PersonG person, AsyncCallback<Void> callback);

    void delete(PersonG person, AsyncCallback<Void> callback);

    void findById(int id, AsyncCallback<PersonG> callback);

}