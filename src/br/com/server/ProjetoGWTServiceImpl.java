package br.com.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import br.com.client.ProjetoGWTService;

public class ProjetoGWTServiceImpl extends RemoteServiceServlet implements ProjetoGWTService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}