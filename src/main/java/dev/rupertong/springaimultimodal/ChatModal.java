package dev.rupertong.springaimultimodal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatModal {
  private final ChatClient chatClient;

  public ChatModal(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
  }

  @GetMapping("/dad-jokes")
  public String jokes(@RequestParam(value = "topic", defaultValue = "dogs") String topic) {
    PromptTemplate promptTemplate = new PromptTemplate("Tell me a dad joke about {topic}");
    return chatClient.prompt(promptTemplate.create(Map.of("topic", topic))).call().content();
  }
}
