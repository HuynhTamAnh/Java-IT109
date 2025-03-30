package bt4;

public class Report {
    public static void generateReport(String name, int age, double[] scores) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        double total = 0;
        for (double score : scores) {
            total += score;
        }

        double avg = total / scores.length;
        System.out.println("Average Score: " + avg);

        // Grade evaluation
        if (avg >= 8) {
            System.out.println("Grade: Excellent");
        } else if (avg >= 5) {
            System.out.println("Grade: Good");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
