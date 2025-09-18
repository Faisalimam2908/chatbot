package com.example.chatbot.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public String askQuestion(String question) throws Exception {
        OkHttpClient client = new OkHttpClient();

        String jsonRequest = "{ \"model\": \"gpt-3.5-turbo\", " +
                "\"messages\": [{\"role\": \"user\", \"content\": \"" + question + "\"}]}";

        RequestBody body = RequestBody.create(
                jsonRequest, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(OPENAI_URL)
                .header("Authorization", "Bearer " + openAiApiKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new RuntimeException("Unexpected code " + response);

            return response.body().string();
        }
    }
}
