# tutorProject
Insert commands into a text file with each command on a new line.

Commands

-init <String tutorName> <Double defaultRate> <optional: Double initialMoney> : creates a tutor object with the name tutorName and the default rate for tutoring per hours. Optional: the initial amount of money that the tutor has. Can only initialize one tutor per execution of the program

-add <String studentName> <optional: Double rate>: adds a new student to the tutor's list of students. Every student must have a unique name If not specified, the rate is the tutor's default rate

-tutor <String studentName> <optional: Double hours>: tutors the student provided. Default tutoring session is 1 hour.

-remove <String studentName>: makes the given student an inactive

-students <optional: active or inactive>: prints out the tutor's students. Providing either the subcommand active or inactive will print only the active or inactive students.

-earnings <total or student>: prints out the tutor's students. Prints out either the tutor's total earnings or the amount of money earned from each student depending on the provided subcommand.

-sessions: prints out the number of sessions that each of the tutor's students (both active and inactive) have had

To run the program:
1. Go into tutorProject/src
2. run javac -sourcepath . tutor/Main.java
3. run java -cp . tutor/Main path/to/input/file.txt

