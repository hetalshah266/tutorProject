package tutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static Tutor tutor = null;
    static boolean tutorInitialized = false;
    public static void main(String[] args) throws FileNotFoundException {
        for (String s: args) {
            File f = new File(s);
            if (f.exists()) {
                getCommands(f);
            }

        }
    }
    public static void getCommands(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] args = line.split(" ");
            executeCommand(args);
        }
    }
    public static void executeCommand(String[] s) {
        if (s[0].equals("init")) {
            if (tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor already initialized");
            } else if (s.length == 3) {
                tutor = new Tutor(s[1], Double.parseDouble(s[2]));
            } else if  (s.length == 4) {
                tutor = new Tutor(s[1], Double.parseDouble(s[2]), Double.parseDouble(s[3]));
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for init command");
            }
        } else if (s[0].equals("add")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 2) {
                tutor.addStudent(s[1]);
            } else if  (s.length == 3) {
                tutor.addStudent(s[1], Double.parseDouble(s[2]));
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for addStudent command");
            }
        } else if (s[0].equals("tutor")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 2) {
                tutor.tutor(s[1]);
            } else if  (s.length == 3) {
                tutor.tutor(s[1], Double.parseDouble(s[2]));
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for tutor command");
            }
        } else if (s[0].equals("remove")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 2) {
                tutor.removeStudent(s[1]);
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for remove command");
            }
        } else if (s[0].equals("students")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 1) {
                tutor.getStudents();
            } else if (s.length == 2) {
                if (s[1].equals("active")) {
                    tutor.getActiveStudents();
                } else if (s[1].equals("inactive") ){
                    tutor.getInactiveStudents();
                } else {
                    System.out.println("ERROR: invalid subcommand for students command");
                }
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for students command");
            }
        } else if (s[0].equals("earnings")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 1) {
                tutor.getStudents();
            } else if (s.length == 2) {
                if (s[1].equals("student")) {
                    tutor.getStudentEarning();
                } else if (s[1].equals("total") ){
                    tutor.getTotalEarning();
                } else {
                    System.out.println("ERROR: invalid subcommand for earnings command");
                }
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for earnings command");
            }
        } else if (s[0].equals("sessions")) {
            if (!tutorInitialized) {
                // throw error
                System.out.println("ERROR: tutor is not initialized");
            } else if (s.length == 1) {
                tutor.getSessions();
            } else {
                // throw error
                System.out.println("ERROR: wrong number of arguments for sessions command");
            }
        } else {
            // throw error
            System.out.println("ERROR: invalid command");
        }
    }
}
