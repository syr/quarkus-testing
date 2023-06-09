package org.acme;

import io.quarkus.arc.Arc;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ServiceTest {

    @InjectSpy
    Service serviceSpy;

    @Inject
    Service service;

    @Test //PASSES
    public void testSpyCreatedByInjection() {
        assertNotNull(serviceSpy.getSubService());
    }

    /*
    as in
        https://github.com/quarkusio/quarkus/issues/20906
        https://quarkus.io/blog/mocking/
     */
    @Test //FAILS -> service.subService is null
    public void testSpyCreatedByCode() {
        Service serviceSpy = Mockito.spy(Service.class);

//        serviceSpy.subService = Arc.container().select(SubService.class).get(); // expected installMockForType does setting subService like this line does

        Mockito.when(serviceSpy.hello()).thenReturn("mocked Hello");
        QuarkusMock.installMockForType(serviceSpy, Service.class); //replace injected Service by Spy

        assertEquals("mocked Hello", service.hello()); //installMockForType worked
        assertNotNull(service.getSubService());
    }
}