import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculates a Grade Point average
 * <p>
 * Using the methods described by my school district,
 * methods may differ between high schools and this calculator
 * is not universal (currently)
 * </p>
 * @author charon
 */

public class Main {
    static void spacer(int count, boolean newline) {
        System.out.println(newline ? "\n" + "─".repeat(count) + "\n" : "─".repeat(count));
    }

    static void titleScreen() {
        spacer(106, false);

        System.out.println("""
                   ______    ____     ___           ______            __                   __           __               \s
                  / ____/   / __ \\   /   |         / ____/  ____ _   / /  _____  __  __   / /  ____ _  / /_  ____    _____
                 / / __    / /_/ /  / /| |        / /      / __ `/  / /  / ___/ / / / /  / /  / __ `/ / __/ / __ \\  / ___/
                / /_/ /   / ____/  / ___ |       / /___   / /_/ /  / /  / /__  / /_/ /  / /  / /_/ / / /_  / /_/ / / /   \s
                \\____/   /_/      /_/  |_|       \\____/   \\__,_/  /_/   \\___/  \\__,_/  /_/   \\__,_/  \\__/  \\____/ /_/    \s
                                                                                                                         \s""");

        spacer(106, false);
        System.out.println();
    }

    static int[] askClasses() throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        // get types and amounts of classes
        System.out.print("How many on-level (OL) classes have been taken so far? >>> ");
        int onlevelClassNumber = Integer.parseInt(userInput.readLine());

        System.out.print("How many advanced (Adv) classes have been taken so far? >>> ");
        int advancedClassNumber = Integer.parseInt(userInput.readLine());

        System.out.print("How many advanced placement (AP) classes have been taken so far? >>> ");
        int apClassNumber = Integer.parseInt(userInput.readLine());

        return new int[] {
                onlevelClassNumber,
                advancedClassNumber,
                apClassNumber
        };
    }

    static void instructions() {

        // give user better instructions
        spacer(50, true);

        System.out.print("""
                This program will now ask for the grades of each class by semester,\s
                Only enter rounded integers when prompted (otherwise the program will implode)
                """);

        spacer(50, true);
    }

    static void printGPA(Map<Integer, Double> map) {
        Average gradeAverage = new Average();

        System.out.println("Your weighted GPA is: " + gradeAverage.hashValuesAverage((map)));
        System.out.println("Your average grade is: " + gradeAverage.hashKeysAverage(map));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        titleScreen();
        Grade userGrades = new Grade();

        // Grade, GPA equivalent
        Map<Integer, Double> grades = new HashMap<>();

        // infinite loop
        for (;;) {
            int[] classNumbers = askClasses();
            instructions();

            // prompt user for grades using Grade class
            for (int i = 0; i < 3; i++) {
                userGrades.getGrades(grades, i, classNumbers[i]);
            }

            printGPA(grades);

            System.out.print("\nWould you like to calculate GPA again? (y/n) >>> ");
            String choice = userInput.readLine();

            if (choice.toLowerCase().startsWith("n")) {
                break;
            }

            spacer(50, true);
        }
    }
}