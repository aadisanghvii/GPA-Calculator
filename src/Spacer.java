public class Spacer {
    void printSpace(int count, boolean newline) {
        System.out.println(newline ? "\n" + "─".repeat(count) + "\n" : "─".repeat(count));
    }
}
