package by.paul.idftesttask.configuration;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

@Configuration
@EnableScheduling
public class UpdateClientConfiguration {

  @Value("${data.updateReq.baseUrl}")
  private String baseUrl;
  @Value("${data.updateReq.nextUrl}")
  private String nextUrl;

  @Bean
  public WebClient getWebClient() {
    return WebClient.builder()
        .baseUrl(baseUrl)
        .defaultCookie("cookieKey", "cookieValue")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .defaultUriVariables(Collections.singletonMap("url", baseUrl))
        .build();
  }

  @Bean
  @Autowired
  public ResponseSpec getInitializedRequest(WebClient webClient) {
    return webClient.get()
        .uri(baseUrl+nextUrl)
        .retrieve();
  }
}
