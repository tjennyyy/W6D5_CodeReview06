
// create a SQL statement that reports all the student:
	a specific class when you know a specific class ID 
(aka something like “show all students of the class 1b, which has the ID=2”)

	SELECT class.studentID, class.className
	FROM class
	WHERE studentID = "5";

// Output className: 2a

// --------------------------------------------------------------------------------------------


// create a SQL statement that reports all the student:
	 a specific class when you know a specific class name 
(aka something like “show all students of the class ‘1b’; I do not know the class ID”) 

	SELECT studentID, className 
	FROM class 
	WHERE className = "1a";

// Output studentID: 10,9,2