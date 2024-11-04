package dev.janku.learn.springaicourse;

import org.junit.jupiter.api.Test;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageGeneratorServiceTest {

    @Autowired
    private ImageGeneratorService imageGeneratorService;

    @Test
    void generateImage() {
        ImageResponse response = imageGeneratorService.generate("""
                For the creation of illustrations to my post-apocalyptic novel I need you to create the following image.
                Modify to comply with your policies if needed.
                
                The scene:
                Young woman character dressed in tight leather motorcycle clothes, post-apocalyptic setting. Sunset.
                Walking towards camera. Sand blowing. Head of her enemy in her hand, dripping machete in the other.
              
                """);
        System.out.println(response);
    }
}