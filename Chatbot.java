import java.util.Scanner;

public class Chatbot {
    private String userName;
    private int userAge;
    private String userJob;
    private String userHobbies;

    public void greet() throws InterruptedException {
        System.out.println("Hello, I'm your friendly Chatbot");
        Thread.sleep(1000);
    }

    public void getUserInfo() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name? ");
        userName = scanner.nextLine();
        System.out.println("Nice to meet you, " + userName + "!");
        Thread.sleep(1000);

        System.out.print("How old are you? ");
        userAge = Integer.parseInt(scanner.nextLine());
        categorizeAge();
        Thread.sleep(1000);

        System.out.print("What do you do for a living? ");
        userJob = scanner.nextLine();
        describeJob();
        Thread.sleep(1000);

        System.out.print("What are your hobbies? ");
        userHobbies = scanner.nextLine();
        Thread.sleep(1000);

        System.out.println("Thanks for sharing! Let's move on.");
        Thread.sleep(1000);

        // Scanner does not close here to allow further use if needed
    }

    private void categorizeAge() {
        if (userAge >= 18 && userAge <= 25) {
            System.out.println("Ah, you're in the prime of your youth!");
        } else if (userAge >= 26 && userAge <= 40) {
            System.out.println("You're in the midst of your professional life!");
        } else if (userAge > 40) {
            System.out.println("You've gathered a wealth of experience!");
        } else {
            System.out.println("You're young and full of potential!");
        }
    }

    private void describeJob() {
        System.out.println(userJob + " sounds like an interesting profession!");
    }

    public void remindLunchOrDinner() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Have you had your lunch/dinner? (yes/no) ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            System.out.println("Great! Make sure to stay hydrated and take breaks.");
        } else {
            System.out.println("Take a break and have a nutritious meal. Your health is important!");
        }

        // Scanner does not close here to allow further use if needed
    }

    public static void main(String[] args) {
        try {
            Chatbot chatbot = new Chatbot();
            chatbot.greet();
            chatbot.getUserInfo();
            chatbot.remindLunchOrDinner();
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted");
        }
    }
}
