import java.util.*;

public class SimpleChatbot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Chatbot: Hello! I am your virtual assistant. Ask me a question or type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            String input = in.nextLine().toLowerCase().trim();

            if (input.equals("bye") || input.equals("exit")) {
                System.out.println("Chatbot: Goodbye! Have a great day.");
                break;
            }

            String response = getRuleBasedResponse(input);
            System.out.println("Chatbot: " + response);
        }
        in.close();
    }

    private static String getRuleBasedResponse(String input) {
        if (input.contains("hello") || input.contains("hi")) {
            return "Greetings! How can I assist you today?";
        } else if (input.contains("time")) {
            return "I don't have a clock, but you can check your system time!";
        } else if (input.contains("name")) {
            return "I am a Java-based rule AI Chatbot.";
        } else if (input.contains("help")) {
            return "I can answer FAQs about my name, greetings, and basic info. Try asking me something!";
        } else if (input.contains("weather")) {
            return "I cannot browse the internet yet, so I don't know the current weather.";
        } else {
            return "I'm sorry, I don't quite understand that. Could you rephrase?";
        }
    }
}