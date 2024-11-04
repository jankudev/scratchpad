package dev.janku.learn.springaicourse;

import dev.janku.learn.springaicourse.entities.ActorFilms;
import groovy.transform.ASTTest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class OpenAiService {

    @Value("classpath:/default_system_prompt_with_voice.st")
    private Resource defaultSystemPrompt;

    private final ChatClient chatClient;

    @Autowired
    public OpenAiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
//                .defaultSystem(sp -> sp
//                        .text(defaultSystemPrompt)
//                        .param("voice", "Robert De Niro"))
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory()),
                        new SimpleLoggerAdvisor())
                .build();
    }

    /**
     * Return just the text content
     *
     * @param userInput
     * @return
     */
    String generateResponse(String userInput) {

        return this.chatClient.prompt()
                .system(sp -> sp
                        .text(defaultSystemPrompt)
                        .param("voice", "Shakespeare"))
                .user(userInput)
                .call()
                .content();
    }

    String generateResponseInVoice(String userInput, String voice) {

        return this.chatClient.prompt()
                .system(sp -> sp.param("voice", voice))
                .user(userInput)
                .call()
                .content();
    }

    /**
     * Streamed
     *
     * @param userInput
     * @return
     */
    Flux<String> generateResponseStreamed(String userInput) {

        return this.chatClient.prompt()
                .user(userInput)
                .stream()
                .content();
    }

    /**
     * Return a response object
     *
     * @param userInput
     * @return
     */
    ChatResponse generateChatResponse(String userInput) {

        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .chatResponse();
    }

    /**
     * Generate a structured response
     *
     * @param actor
     * @return
     */
    ActorFilms generateStructuredResponse(String actor) {

        return this.chatClient.prompt()
                .user("Generate the filmography for the actor " + actor)
                .call()
                .entity(ActorFilms.class);
    }

    /**
     * Generate filmography for actos
     *
     * @param actors
     * @return
     */
    public List<ActorFilms> getFilmsForActors(String... actors) {
        return this.chatClient.prompt()
                .user("""
                        Generate the filmographies of 5 movies for the following actors:
                        %s
                        """.formatted(String.join(", ", actors)))
                .call()
                .entity(new ParameterizedTypeReference<List<ActorFilms>>() {
                });
    }
}
