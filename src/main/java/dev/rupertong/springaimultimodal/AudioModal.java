package dev.rupertong.springaimultimodal;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class AudioModal {

  private final OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;
  @Value("classpath:/audio/src_main_resources_audio_jfk.flac")
  private Resource audio;

  public AudioModal(OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel) {
    this.openAiAudioTranscriptionModel = openAiAudioTranscriptionModel;
  }

  @GetMapping("/audio-transcribe")
  public String transcribe() {
    OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
        .withLanguage("en")
        .withTemperature(0f)
        .withResponseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT)
        .build();

    AudioTranscriptionPrompt transcriptionPrompt = new AudioTranscriptionPrompt(audio, transcriptionOptions);
    AudioTranscriptionResponse response = openAiAudioTranscriptionModel.call(transcriptionPrompt);
    return new String(response.getResult().getOutput().getBytes(), StandardCharsets.UTF_8);
  }
}
