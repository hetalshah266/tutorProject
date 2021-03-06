package tutor;
import java.io.Serializable;
import java.util.*;

/*** A class that represents a Tutor object. ***/

public class Tutor implements Serializable {
    /** Name of the Tutor. */
    String _name;

    /** Sum of earnings from all students for all time. */
    double _totalEarnings;

    /** Default rate for tutoring students per hour. */
    double _defaultRate;

    /** HashMap that maps the Student name to the Student object. */
    HashMap<String, Student> _students;

    /** Creates a Tutor object with given name and initialMoney that the Tutor has. */
    public Tutor(String name, double defaultRate, double initialMoney) {
        _name = name;
        _totalEarnings = initialMoney;
        _students = new HashMap<>();
        _defaultRate = defaultRate;
    }

    /** Creates a Tutor object with given name and initialMoney is 0. */
    public Tutor (String name, double defaultRate) {
        this(name, 0, defaultRate);
    }

    /** Creates a Student object with given name and default rate and adds it to tutor's students. */
    public void addStudent(String name) {
        addStudent(name, _defaultRate);
    }

    /** Creates a Student object with given name and given rate and adds it to tutor's students. */
    public void addStudent(String name, double rate) {
        if (_students.containsKey(name)) {
            // throw error
            System.out.println("ERROR: student name already exists");
        } else {
            _students.put(name, new Student(name, rate));
        }
    }

    /** Removes a Student object with given name if exists. */
    public void removeStudent(String name) {
        if (!_students.containsKey(name)) {
            // throw error
            System.out.println("ERROR: student does not exists");
        } else {
            _students.get(name)._active = false;
        }
    }

    /** Calls Student class tutor method on student. Tutors student for one hour. */
    public void tutor(String name) {
        tutor(name, 1);
    }

    /** Calls Student class tutor method on student. Tutors student for given hours. */
    public void tutor(String name, double hours) {
        Student s = _students.get(name);
        s.getTutored(1);
    }

    /** Outputs earnings from each student*/
    public void getStudentEarning() {
        System.out.println("Earnings by Student");
        for (Student s: _students.values()) {
            System.out.println("   * " + s._name + ": " + s._paid);
        }
    }

    /** Outputs  total earnings. */
    public void getTotalEarning() {
        System.out.println("Total Earnings:");
        System.out.println("   * "  + _totalEarnings);
    }

    /** Outputs total number of tutoring sessions for each student.*/
    public void getSessions() {
        System.out.println("Session Breakdown");
        int total = 0;
        for (Student s: _students.values()) {
            total += s._sessions;
            System.out.println("   * " + s._name + ": " + s._sessions);
        }
        System.out.println("Total: " +  total);
    }

    /** Outputs all students.*/
    public void getStudents() {
        System.out.println("Students");
        for (String s: _students.keySet()) {
            System.out.println("   * " + s);
        }
    }

    /** Outputs active students.*/
    public void getActiveStudents() {
        System.out.println("Active Students:");
        for (Student s: _students.values()) {
            if (s._active) {
                System.out.println("   * " + s);
            }
        }
    }

    /** Outputs active students.*/
    public void getInactiveStudents() {
        System.out.println("Inactive Students:");
        for (Student s: _students.values()) {
            if (!s._active) {
                System.out.println("   * " + s);
            }
        }
    }

}