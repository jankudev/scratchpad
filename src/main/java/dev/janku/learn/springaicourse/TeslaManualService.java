package dev.janku.learn.springaicourse;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class TeslaManualService {

    private final ChatClient chatClient;

    //FIXME: Create vectorStore - https://github.com/kousen/springaiexamples/blob/main/src/main/java/com/kousenit/springaiexamples/rag/TeslaManualService.java
    public TeslaManualService(ChatModel model, VectorStore vectorStore) {
        chatClient = ChatClient.builder(model)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults()))
                .build();
    }

    public String ask(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}
