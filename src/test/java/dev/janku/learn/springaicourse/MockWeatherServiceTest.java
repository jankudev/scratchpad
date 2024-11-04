package dev.janku.learn.springaicourse;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MockWeatherServiceTest {

    @Autowired
    private MockWeatherService mockWeatherService;

    @Autowired
    private ChatClient.Builder chatClientBuilder;

    @Test
    void testGetWeather() {
        var chatClient = chatClientBuilder.build();

        String answer = chatClient.prompt()
                .functions("mockWeatherService")
                .user("What's the weather in Ostrava?")
                .call()
                .content();

        System.out.println(answer);
    }
}