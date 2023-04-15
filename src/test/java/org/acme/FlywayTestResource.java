package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.Map;

public class FlywayTestResource implements QuarkusTestResourceLifecycleManager {
    @Override
    public Map<String, String> start() {
        Log.info("DB INIT");
        return null;
    }

    @Override
    public void stop() {

    }
}
