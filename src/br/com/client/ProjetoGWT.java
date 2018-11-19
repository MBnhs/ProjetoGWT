package br.com.client;

import br.com.client.application.PersonApplication;
import br.com.client.application.PersonApplicationAsync;
import br.com.client.domain.PersonG;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class ProjetoGWT implements EntryPoint {

    private PersonApplicationAsync app = GWT.create(PersonApplication.class);

    private Label labelName = new Label("Nome");
    private TextBox fieldName = new TextBox();

    private Label labelEmail = new Label("Email");
    private TextBox fieldEmail = new TextBox();

    private Label labelPhone = new Label("Telefone");
    private TextBox fieldPhone = new TextBox();

    private Label labelCell = new Label("Celular");
    private TextBox fieldCell = new TextBox();

    private PersonG person;

    private Button btSave = new Button("Salvar");

    private Label labelResultado = new Label("Resultado");

    /**
     * This is the entry point method.
     *//*
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    ProjetoGWTService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }*/

    @Override
    public void onModuleLoad() {
        configure();
        configureBtSave();
    }

    private void configure(){
        RootPanel.get("slot1").add(labelName);
        RootPanel.get("slot2").add(fieldName);

        RootPanel.get("slot3").add(labelEmail);
        RootPanel.get("slot4").add(fieldEmail);

        RootPanel.get("slot5").add(labelPhone);
        RootPanel.get("slot6").add(fieldPhone);

        RootPanel.get("slot7").add(labelCell);
        RootPanel.get("slot8").add(fieldCell);

        RootPanel.get("slot9").add(btSave);
        RootPanel.get("slot10").add(labelResultado);


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
                        labelResultado.setText("Cadastrado com sucesso");
                        RootPanel.get("slot10").add(labelResultado);
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        labelResultado.setText("Ocorreu um erro");
                        RootPanel.get("slot10").add(labelResultado);
                    }
                });
            }
        });
    }
}
