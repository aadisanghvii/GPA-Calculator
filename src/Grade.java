import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Grade {
    private final Conversion gradeConvert = new Conversion();
    private final Spacer spacer = new Spacer();

    public void getGrades(Map<Integer, Double> grades, int gradeType, int classNumber)
            throws IOException {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String abbreviated = switch (gradeType) {
            case 2 -> "AP";
            case 1 -> "Adv";
            case 0 -> "OL";
            default -> null;
        };

        for (int i = 0; i < classNumber; i++) {
            System.out.print("(" + abbreviated + ", FIRST SEMESTER) What was the first semester grade for class #" + (i + 1) + "? >>> ");
            int firstSemesterGrade = Integer.parseInt(userInput.readLine());

            // add to hashmap
            grades.put(firstSemesterGrade, gradeConvert.convert(firstSemesterGrade, gradeType));

            System.out.print("Have you taken a second semester of this class? (y/n) >>> ");
            String secondSemester = userInput.readLine().toLowerCase();

            // new line is cleaner
            System.out.println();

            if (secondSemester.startsWith("y")) {
                System.out.print("(" + abbreviated + ", SECOND SEMESTER) What was the second semester grade for class #" + (i + 1) + "? >>> ");

                int secondSemesterGrade = Integer.parseInt(userInput.readLine());

                // add to hashmap
                grades.put(secondSemesterGrade, gradeConvert.convert(secondSemesterGrade, gradeType));
            }
            spacer.printSpace(Main.NUM_OF_SPACES[1], true);
        }
    }
}