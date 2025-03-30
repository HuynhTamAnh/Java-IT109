package bt2;

public class StudentGradeCalculator {
        public static double calculateAverage(double[] scores) {
            if (scores == null || scores.length == 0) {
                return 0;
            }

            double total = 0;
            for (double score : scores) {
                total += score;
            }

            return total / scores.length;
        }

        public static void main(String[] args) {
            double[] marks = {7.5, 8.0, 6.5};
            double avg = calculateAverage(marks);

            if (avg >= 5.0) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }

}