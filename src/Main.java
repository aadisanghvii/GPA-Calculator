import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
    private static final int NUM_OF_CLASSES = 3;
    public static final int[] NUM_OF_SPACES = {106, 50};
    private static final Spacer spacer = new Spacer();

    public static void main(String[] args) throws IOException {
        Grade userGrades = new Grade();
        Map<Integer, Double> grades = new HashMap<>(); // Grade, GPA equivalent

        titleScreen();

        int[] classNumbers = askClasses();

        instructions();

        // prompt user for grades using Grade class
        for (int i = 0; i < NUM_OF_CLASSES; i++) {
            userGrades.getGrades(grades, i, classNumbers[i]);
        }

        printGPA(grades);
    }

    static void titleScreen() {
        spacer.printSpace(NUM_OF_SPACES[0], false);

        System.out.println("""
                   ______    ____     ___           ______            __                   __           __               \s
                  / ____/   / __ \\   /   |         / ____/  ____ _   / /  _____  __  __   / /  ____ _  / /_  ____    _____
                 / / __    / /_/ /  / /| |        / /      / __ `/  / /  / ___/ / / / /  / /  / __ `/ / __/ / __ \\  / ___/
                / /_/ /   / ____/  / ___ |       / /___   / /_/ /  / /  / /__  / /_/ /  / /  / /_/ / / /_  / /_/ / / /   \s
                \\____/   /_/      /_/  |_|       \\____/   \\__,_/  /_/   \\___/  \\__,_/  /_/   \\__,_/  \\__/  \\____/ /_/    \s
                                                                                                                         \s""");

        spacer.printSpace(NUM_OF_SPACES[0], false);
        System.out.println();
    }

    @Contract(" -> new")
    private static int @NotNull [] askClasses() throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        int[] result = new int[NUM_OF_CLASSES];

        // get types and amounts of classes
        System.out.print("How many on-level (OL) classes have been taken so far? >>> ");
        result[0] = Integer.parseInt(userInput.readLine());

        System.out.print("How many advanced (Adv) classes have been taken so far? >>> ");
        result[1] = Integer.parseInt(userInput.readLine());

        System.out.print("How many advanced placement (AP) classes have been taken so far? >>> ");
        result[2] = Integer.parseInt(userInput.readLine());

        return result;
    }

    private static void instructions() {
        // give user better instructions
        spacer.printSpace(NUM_OF_SPACES[1], true);

        System.out.print("""
                This program will now ask for the grades of each class by semester,\s
                Only enter rounded integers when prompted (otherwise the program will implode)
                """);

        spacer.printSpace(NUM_OF_SPACES[1], true);
    }

    private static void printGPA(Map<Integer, Double> map) {
        Average gradeAverage = new Average();

        System.out.println("The calculation is accurate to about (+/-)0.05. This has been accounted for.\n");

        // Weird, hacky fix to account for inaccuracies in the weighted GPA
        System.out.println("Your weighted GPA is: " + (gradeAverage.hashValuesAverage(map) - 0.05)) ;
        System.out.println("Your average grade is: " + gradeAverage.hashKeysAverage(map));
    }
}