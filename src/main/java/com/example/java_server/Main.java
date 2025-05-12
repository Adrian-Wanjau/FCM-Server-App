package com.example.java_server;

public class Main {
    public static void main(String[] args) {
        FirebaseInitializer.init();

        // Replace with a real device token from the React Native app
        String deviceToken = "f-92l5rlRQigqhaU9lW-q4:APA91bGvkIBOOOGQe82VgL6xE4EEIgD5Qw9hi67X2UR9i-XG3TKskMHKhjsAQup6cMoY7bxfdGSVd6gZLQSuSoeshezptYreIJI-IUOO_lZzCzVhlPHFDWY";

        new PushService().sendNotification(deviceToken);
    }
}
