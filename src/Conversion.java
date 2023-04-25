public class Conversion {
    /**
     * Function to convert numerical grade -> GPA equivalent
     * @param grade numerical value of a grade
     * @param gradeType (respectively) 2, 1, 0 = AP, advanced, on level
     * @return GPA equivalent (0-6)
     */

    public double convert(int grade, int gradeType) {
        /*
         gradeType 0 = AP
         gradeType 1 = advanced
         gradeType 2 = on level
        */

        // failing grade
        if (grade < 70) {
            return 0;
        }

        return switch (gradeType) {
            case 2 -> (6 - (100 - grade) * 0.1);
            case 1 -> (5.5 - (100 - grade) * 0.1);
            case 0 -> (5 - (100 - grade) * 0.1);
            default -> -1;
        };

        /*
        5.0530
How many on-level (OL) classes have been taken so far? >>> 10
How many advanced (Adv) classes have been taken so far? >>> 9
How many advanced placement (AP) classes have been taken so far? >>> 2

──────────────────────────────────────────────────

This program will now ask for the grades of each class by semester,
Only enter rounded integers when prompted (otherwise the program will implode)

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #1? >>> 98
Have you taken a second semester of this class? (y/n) >>> n


──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #2? >>> 97
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #2? >>> 98

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #3? >>> 95
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #3? >>> 97

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #4? >>> 99
Have you taken a second semester of this class? (y/n) >>> n


──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #5? >>> 96
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #5? >>> 99

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #6? >>> 100
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #6? >>> 100

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #7? >>> 90
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #7? >>> 100

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #8? >>> 99
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #8? >>> 98

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #9? >>> 100
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #9? >>> 100

──────────────────────────────────────────────────

(OL, FIRST SEMESTER) What was the first semester grade for class #10? >>> 96
Have you taken a second semester of this class? (y/n) >>> y

(OL, SECOND SEMESTER) What was the second semester grade for class #10? >>> 99

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #1? >>> 96
Have you taken a second semester of this class? (y/n) >>> yesasdfasdfjk

(ADV, SECOND SEMESTER) What was the second semester grade for class #1? >>> 98

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #2? >>> 98
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #2? >>> 100

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #3? >>> 87
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #3? >>> 92

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #4? >>> 99
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #4? >>> 100

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #5? >>> 100
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #5? >>> 99

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #6? >>> 100
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #6? >>> 100

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #7? >>> 98
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #7? >>> 98

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #8? >>> 93
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #8? >>> 94

──────────────────────────────────────────────────

(ADV, FIRST SEMESTER) What was the first semester grade for class #9? >>> 95
Have you taken a second semester of this class? (y/n) >>> y

(ADV, SECOND SEMESTER) What was the second semester grade for class #9? >>> 96

──────────────────────────────────────────────────

(AP, FIRST SEMESTER) What was the first semester grade for class #1? >>> 99
Have you taken a second semester of this class? (y/n) >>> y

(AP, SECOND SEMESTER) What was the second semester grade for class #1? >>> 99

──────────────────────────────────────────────────

(AP, FIRST SEMESTER) What was the first semester grade for class #2? >>> 95
Have you taken a second semester of this class? (y/n) >>> y

(AP, SECOND SEMESTER) What was the second semester grade for class #2? >>> 94

──────────────────────────────────────────────────
        5.0530 vs 5.0091
Your weighted GPA is: 5.009090909090909
Your average grade is: 94.63636363636364

Would you like to calculate GPA again? (y/n) >>>
         */
    }
}
