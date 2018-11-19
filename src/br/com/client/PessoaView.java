package br.com.client;

import br.com.client.application.PersonApplication;
import br.com.client.application.PersonApplicationAsync;
import br.com.client.domain.PersonG;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;

public class PessoaView extends FormPanel {

    private PersonApplicationAsync app = GWT.create(PersonApplication.class);

    private TextBox fieldName = new TextBox();
    private TextBox fieldEmail = new TextBox();
    private TextBox fieldPhone = new TextBox();
    private TextBox fieldCell = new TextBox();

    private PersonG person;

    private Button btSave = new Button("Salvar");

    public PessoaView() {
        configure();
        configureBtSave();
    }

    private void configure(){
        fieldName.setText("Nome");
        add(fieldName);

        fieldEmail.setText("Email");
        add(fieldEmail);

        fieldPhone.setText("Fixo");
        add(fieldPhone);

        fieldCell.setText("Celular");
        add(fieldCell);

        add(btSave);
    }

    private PersonG getPerson(){
        person = new PersonG();

        person.setName(fieldName.getValue());
        person.setEmail(fieldEmail.getValue());
        person.setPhone(fieldPhone.getValue());
        person.setCell(fieldCell.getValue());
        return person;
    }

    private void configureBtSave(){
        btSave.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                app.save(getPerson(), new AsyncCallback<Void>() {

                    @Override
                    public void onSuccess(Void result) {
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                    }
                });
            }
        });
    }

}
