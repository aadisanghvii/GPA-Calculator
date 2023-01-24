import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Grade {
    public void getGrades(Map<Integer, Double> grades, int gradeType, int classNumber)
            throws IOException
    {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Conversion gradeConvert = new Conversion();

        StringBuilder abbreviated = switch (gradeType) {
            case 2 -> new StringBuilder("AP");
            case 1 -> new StringBuilder("Adv");
            case 0 -> new StringBuilder("OL");
            default -> null;
        };

        for (int i = 0; i < classNumber; i++) {
            System.out.print("(" + abbreviated + ", FIRST SEMESTER) What was the first semester grade for class #" + (i + 1) + "? >>> ");

            int firstSemesterGrade = Integer.parseInt(userInput.readLine());

            // add to hashmap
            grades.put(firstSemesterGrade, gradeConvert.convert(firstSemesterGrade, gradeType));

            System.out.print("Have you taken a second semester of this class? (y/n) >>> ");
            String secondSemester = userInput.readLine();

            // new line is cleaner
            System.out.println();

            if ((secondSemester.toLowerCase()).startsWith("y")) {
                System.out.print("(" + abbreviated + ", SECOND SEMESTER) What was the second semester grade for class #" + (i + 1) + "? >>> ");

                int secondSemesterGrade = Integer.parseInt(userInput.readLine());

                // add to hashmap
                grades.put(secondSemesterGrade, gradeConvert.convert(secondSemesterGrade, gradeType));
            }
        }
        Main.spacer(50, true);
    }
}
