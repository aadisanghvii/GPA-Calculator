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
    }
}
