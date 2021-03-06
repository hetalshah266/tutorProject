package tutor;

import java.io.Serializable;

public class Student implements Serializable {
    /** Name of the Student. */
    String _name;

    /** How much Student has paid tutor in total. */
    double _paid;

    /** How much Student pays tutor per hour. */
    double _ratePerHour;

    /** Return how many tutoring sessions Student has had. */
    int _sessions;

    /** Is student currently getting tutored **/
    boolean _active = true;

    /** Creates a Student object with given name, grade, and tutoring ratePerHour. */
    public Student(String name, double ratePerHour) {
        _name = name;
        _paid = 0;
        _sessions = 0;
        _ratePerHour = ratePerHour;
    }

    public double getTutored(double hours) {
        if (!_active) {
            // throw error
            System.out.println("ERROR: Student not currently active");
            return 0;
        } else {
            _paid += _ratePerHour * hours;
            _sessions++;
            return _ratePerHour * hours;
        }
    }


}