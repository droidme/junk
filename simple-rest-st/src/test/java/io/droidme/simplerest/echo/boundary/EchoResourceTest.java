/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.simplerest.echo.boundary;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Test;

/**
 *
 * @author droidme
 */
public class EchoResourceTest {

    @Test
    public void testEcho() {
        get("http://localhost:8080/simple-rest/resources/echo")
                .then()
                .body(containsString("Hello"));
    }

}
