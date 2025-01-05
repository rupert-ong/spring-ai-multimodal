# Spring AI Multimodal

Multimodality refers to a model’s ability to simultaneously understand and process information from various sources,
including text, images, audio, and other data formats.

This project demonstrates the use of Spring Boot with OpenAI's API to handle multimodal inputs, specifically focusing on
text-to-text, image description, image to text generation, and audio transcription.

## Prerequisites

- Java 17
- Maven 3.3.9 or later
- [OpenAI API Key](https://platform.openai.com/docs/overview)

## Getting Started

### Set Up Environment Variables

Ensure you have the OpenAI API key set up as an environment variable:

```sh
export OPENAI_API_KEY=your_openai_api_key
```

### Build the Project

Use Maven to build the project:

```sh
mvn clean install
```

### Run the Application

Start the Spring Boot application:

```sh
mvn spring-boot:run
```

## Dependencies

The project uses the following dependencies:

- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.ai:spring-ai-openai-spring-boot-starter`
- `org.springframework.boot:spring-boot-starter-test` (for testing)

These dependencies are managed in the `pom.xml` file.

## Configuration

The application configuration is managed in the `application.properties` file:

```ini
spring.application.name=spring-ai-multimodal
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4o-mini
```

## API Endpoints

### Audio Transcription

Transcribe audio files using the OpenAI API:

- **URL:** `/audio-transcribe`
- **Method:** `GET`
- **Response:** Transcribed text from the audio file

### Chat

Interact with the chat model using the OpenAI API:

- **URL:** `/chat`
- **Method:** `POST`
- **Request Body:** JSON object with the chat prompt
- **Response:** Chat response from the model

### Image Description

Generate descriptions for images using the OpenAI API:

- **URL:** `/image-describe`
- **Method:** `POST`
- **Request Body:** JSON object with the image URL
- **Response:** Description of the image

### Image to Text

Convert images to text using the OpenAI API:

- **URL:** `/image-to-text`
- **Method:** `POST`
- **Request Body:** JSON object with the image URL
- **Response:** Text extracted from the image

## Additional Resources

For further reference, please consider the following sections:

- [Spring AI Multimodality](https://docs.spring.io/spring-ai/reference/api/multimodality.html#_spring_ai_multimodality)
- [Spring AI OpenAPI Multimodality](https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html#_multimodal)
- [Spring AI OpenAPI Audio Transcription](https://docs.spring.io/spring-ai/reference/api/audio/transcriptions/openai-transcriptions.html)]
- [OpenAI API Documentation](https://docs.spring.io/spring-ai/reference/api/chat/openai-chat.html)

## License

This project is licensed under the MIT License.