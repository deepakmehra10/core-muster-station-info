package com.rccl.middleware.core;

import com.rccl.middleware.commons.models.reqres.ResponseBody;
import com.rccl.middleware.core.controller.HealthController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class HealthControllerTest {
    
    private static HealthController healthController;
    
    @BeforeClass
    public static void setUp() {
        healthController = new HealthController();
    }
    
    
    @AfterClass
    public static void destroy() {
        if (healthController != null) {
            healthController = null;
        }
    }
    
    @Test
    public void shouldReturnHealth() {
        ResponseBody<String> responseBody = healthController.health().block();
        assertThat(responseBody, instanceOf(ResponseBody.class));
        assertThat(responseBody.getStatus(), is(equalTo(200)));
        assertThat(responseBody.getPayload(), is(equalTo("Health is up!")));
        assertThat(responseBody.getWarnings(), hasSize(0));
        assertThat(responseBody.getError(), is(nullValue()));
    }
}

