package org.acme;

import io.quarkus.logging.Log;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Service {
    @Inject
    SubService subService;

    @PostConstruct
    public void init() {
        Log.info("service constructed");
    }

    public String hello(){ return "";}

    public SubService getSubService() {
        return subService;
    }
}
