package br.com.cielo.desafio.surveycommons;

import org.junit.Before;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import static org.mockito.MockitoAnnotations.initMocks;

@PowerMockIgnore({"com.sun.org.apache.xerces.*", "javax.xml.*", "org.xml.*"})
public class BaseTest {

    @Before
    public void init() {
        initMocks(this);
    }
}