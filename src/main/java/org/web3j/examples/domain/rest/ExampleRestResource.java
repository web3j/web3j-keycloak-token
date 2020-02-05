package org.web3j.examples.domain.rest;

import javax.ws.rs.*;
import org.keycloak.models.*;
import org.keycloak.services.managers.*;

public class ExampleRestResource {

    private final KeycloakSession session;
    private final AuthenticationManager.AuthResult auth;

    public ExampleRestResource(KeycloakSession session) {
        this.session = session;
        this.auth = new AppAuthManager().authenticateBearerToken(session, session.getContext().getRealm());
    }

    @Path("companies")
    public CompanyResource getCompanyResource() {
        return new CompanyResource(session);
    }

    // Same like "companies" endpoint, but REST endpoint is authenticated with Bearer token and user must be in realm role "admin"
    // Just for illustration purposes
    @Path("companies-auth")
    public CompanyResource getCompanyResourceAuthenticated() {
        checkRealmAdmin();
        return new CompanyResource(session);
    }

    private void checkRealmAdmin() {
        if (auth == null) {
            throw new NotAuthorizedException("Bearer");
        } else if (auth.getToken().getRealmAccess() == null || !auth.getToken().getRealmAccess().isUserInRole("admin")) {
            throw new ForbiddenException("Does not have realm admin role");
        }
    }
}
