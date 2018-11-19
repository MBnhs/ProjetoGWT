package br.com.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ProjetoGWTService")
public interface ProjetoGWTService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use ProjetoGWTService.App.getInstance() to access static instance of ProjetoGWTServiceAsync
     */
    public static class App {
        private static ProjetoGWTServiceAsync ourInstance = GWT.create(ProjetoGWTService.class);

        public static synchronized ProjetoGWTServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
