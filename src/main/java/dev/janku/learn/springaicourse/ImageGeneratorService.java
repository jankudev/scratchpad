package dev.janku.learn.springaicourse;

import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.stereotype.Service;

@Service
public class ImageGeneratorService {
    private final OpenAiImageModel imageModel;

    public ImageGeneratorService(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageResponse generate(String prompt) {
        var options = ImageOptionsBuilder.builder()
                .withHeight(1024)
                .withWidth(1024)
                .build();

        var imagePrompt = new ImagePrompt(prompt, options);
        return imageModel.call(imagePrompt);
    }
}
