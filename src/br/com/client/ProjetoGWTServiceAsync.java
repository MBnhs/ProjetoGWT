package br.com.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProjetoGWTServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
