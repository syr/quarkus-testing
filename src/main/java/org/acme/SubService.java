package org.acme;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SubService {
    public String hello() {
        return "hello from A";
    }
}
