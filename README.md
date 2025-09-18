Customer Support Chatbot – Spring Boot + GenAI

This project is a Spring Boot backend service that integrates with a Generative AI API (OpenAI) to act as a Customer Support Chatbot.
It provides an API endpoint where users can send their questions and receive AI-powered responses in real time.

🚀 Features

Spring Boot 3.x backend

REST API for customer support queries

Integration with OpenAI API (gpt-3.5-turbo)

Uses OkHttp for HTTP calls

JSON parsing with Jackson

Easily configurable via application.properties

📂 Project Structure
genai-chatbot/
 ├── src/main/java/com/example/chatbot/
 │   ├── ChatbotApplication.java       # Main Spring Boot app
 │   ├── controller/ChatController.java # REST Controller
 │   ├── service/ChatService.java       # Service Layer (OpenAI API call)
 │   └── model/ChatRequest.java         # Request DTO
 ├── src/main/resources/application.properties # Config
 ├── pom.xml                            # Dependencies

⚡ API Endpoint
Method	Endpoint	Description
POST	/api/chat	Send a customer query and get AI response
Example Request
POST http://localhost:8080/api/chat
Content-Type: application/json

{
  "question": "How can I reset my online banking password?"
}

Example Response
{
  "id": "chatcmpl-12345",
  "object": "chat.completion",
  "choices": [
    {
      "message": {
        "role": "assistant",
        "content": "To reset your online banking password, click on 'Forgot Password' on the login page..."
      }
    }
  ]
}

▶️ Running the Project

Clone the repository:

git clone https://github.com/your-username/genai-chatbot.git
cd genai-chatbot


Add your OpenAI API Key in application.properties:

openai.api.key=your_api_key_here


Build & run with Maven:

mvn spring-boot:run


Test with Postman or cURL:

curl -X POST http://localhost:8080/api/chat \
-H "Content-Type: application/json" \
-d "{\"question\":\"How can I track my order?\"}"

🛠️ Tech Stack

Java 17

Spring Boot 3.x

OpenAI GPT-3.5 API

OkHttp (HTTP client)

Jackson (JSON parsing)

Maven

📌 Use Cases

Customer Support Automation

FAQ Answering

Banking / E-commerce Helpdesk

General Query Chatbots
