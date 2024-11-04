package dev.janku.learn.springaicourse;

import dev.janku.learn.springaicourse.entities.ActorFilms;
import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAiServiceTest {

    @Autowired
    private OpenAiService openAiService;

    @Test
    void generateResponse() {
        String answer = openAiService.generateResponse("Why is the sky blue?");
        System.out.println(answer);
        assertNotNull(answer);
        assertTrue(answer.contains("scattering"));
    }

    @Test
    void generateResponseInVoice() {
        String answer = openAiService.generateResponseInVoice("Why is the sky blue?", "Shakespeare");
        System.out.println(answer);
        assertNotNull(answer);
    }

    @Test
    void generateResponseStreamed() {
        openAiService.generateResponseStreamed("Why is the sky blue?")
                .doOnNext(System.out::println).blockLast();
    }

    @Test
    void generateChatResponse() {
        ChatResponse response = openAiService.generateChatResponse("Why is the sky blue?");
        assertNotNull(response);
        System.out.println(response);

        String answer = response.getResults().get(0).getOutput().getContent();
        assertTrue(answer.contains("scattering"));
    }

    @Test
    void generateStructuredResponse() {
        ActorFilms response = openAiService.generateStructuredResponse("John Travolta");
        assertNotNull(response);

        assertEquals("John Travolta", response.actor());
        assertFalse(response.movies().isEmpty());
        System.out.println("Films for " + response.actor() + ": ");
        response.movies().forEach(System.out::println);
    }

    @Test
    void generateFilmography() {
        List<ActorFilms> filmographies = openAiService.getFilmsForActors("John Travolta", "Samuel L. Jackson");
        assertNotNull(filmographies);
        assertFalse(filmographies.isEmpty());

        filmographies.forEach(actorFilms -> {
            System.out.println(actorFilms.actor());
            actorFilms.movies().forEach(System.out::println);
            System.out.println("--------------------------");
        });
    }

    @Test
    void conversation() {
        String response1 = openAiService.generateResponse("My name is Bob");
        System.out.println(response1);
        String response2 = openAiService.generateResponse("What is my name?");
        System.out.println(response2);
        assertTrue(response2.contains("Bob"));
    }
}