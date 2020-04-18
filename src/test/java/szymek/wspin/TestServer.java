package szymek.wspin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import szymek.wspin.controller.MainController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestServer {

    @LocalServerPort
    private int port;

    @Autowired
    private MainController mainController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void serverWorks() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("Welcome to world of climbing.");
    }

}
