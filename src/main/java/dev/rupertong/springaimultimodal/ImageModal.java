package dev.rupertong.springaimultimodal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.model.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageModal {
  private final ChatClient chatClient;

  @Value("classpath:/images/sincerely-media-2UlZpdNzn2w-unsplash.jpg")
  private Resource pictureImage;

  @Value("classpath:/images/java-open-ai.png")
  private Resource codeImage;

  public ImageModal(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  @GetMapping("/image-describe")
  public String describeImage() {
    UserMessage userMessage = new UserMessage("Can you please explain what you see in the following image",
        new Media(MimeTypeUtils.IMAGE_JPEG, pictureImage));

    return chatClient.prompt(new Prompt(userMessage)).call().content();
  }

  @GetMapping("/code-describe")
  public String describeCodeImage() {
    UserMessage userMessage = new UserMessage(
        "The following is a screenshot of some code. Can you do your best to provide a description of what the code is doing",
        new Media(MimeTypeUtils.IMAGE_PNG, codeImage));

    return chatClient.prompt(new Prompt(userMessage)).call().content();
  }

  @GetMapping("/image-to-code")
  public String imageToCode() {
    UserMessage userMessage = new UserMessage(
        "The following is a screenshot of some code. Can you translate this from the image into text?",
        new Media(MimeTypeUtils.IMAGE_PNG, codeImage));

    return chatClient.prompt(new Prompt(userMessage)).call().content();
  }
}
