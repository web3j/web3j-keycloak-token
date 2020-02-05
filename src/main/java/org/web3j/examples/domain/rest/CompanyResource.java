package org.web3j.examples.domain.rest;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.jboss.resteasy.annotations.cache.*;
import org.keycloak.models.*;
import org.web3j.examples.domain.*;
import org.web3j.examples.domain.spi.*;

public class CompanyResource {
    private final KeycloakSession session;

    public CompanyResource(KeycloakSession session) {
        this.session = session;
    }

    @GET
    @Path("")
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompanyRepresentation> getCompanies() {
        return session.getProvider(ExampleService.class).listCompanies();
    }

    @POST
    @Path("")
    @NoCache
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(CompanyRepresentation rep) {
        session.getProvider(ExampleService.class).addCompany(rep);
        return Response.created(session.getContext().getUri().getAbsolutePathBuilder().path(rep.getId()).build()).build();
    }

    @GET
    @NoCache
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompanyRepresentation getCompany(@PathParam("id") final String id) {
        return session.getProvider(ExampleService.class).findCompany(id);
    }

}
