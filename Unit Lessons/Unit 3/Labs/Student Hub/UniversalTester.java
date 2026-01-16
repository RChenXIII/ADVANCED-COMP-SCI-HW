public class UniversalTester {
    public static void main(String[] args) {
        System.out.println("=== TESTING HUB CLASS ===\n");
        testHubExceptions();
        
        System.out.println("\n=== TESTING STUDENT CLASS ===\n");
        testStudentExceptions();
        
        System.out.println("\n=== TESTING ASSIGNMENT CLASS ===\n");
        testAssignmentExceptions();
    }

    public static void testHubExceptions() {
        Hub hub = new Hub();
        
        // Test 1: Null name in registerStudent
        System.out.println("Test 1: Registering student with null name");
        try {
            hub.registerStudent(null, "password123", "test@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null name detected\n");
        }
        
        // Test 2: Blank password in registerStudent
        System.out.println("Test 2: Registering student with blank password");
        try {
            hub.registerStudent("JohnDoe", "   ", "john@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank password detected\n");
        }
        
        // Test 3: Invalid email (missing @)
        System.out.println("Test 3: Registering student with invalid email");
        try {
            hub.registerStudent("JaneDoe", "password123", "invalidemail.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - invalid email detected\n");
        }
        
        // Test 4: Name contains @ symbol
        System.out.println("Test 4: Registering student with @ in name");
        try {
            hub.registerStudent("John@Doe", "password123", "john@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - @ symbol in name detected\n");
        }
        
        // Register a valid student for next tests
        hub.registerStudent("ValidStudent", "password123", "valid@email.com");
        
        // Test 5: Duplicate student name
        System.out.println("Test 5: Registering student with duplicate name");
        try {
            hub.registerStudent("ValidStudent", "password456", "another@email.com");
        } catch (IllegalStateException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - duplicate name detected\n");
        }
        
        // Test 6: Login with non-existent student
        System.out.println("Test 6: Logging in with non-existent username");
        try {
            hub.loginStudent("NonExistent", "password123");
        } catch (IllegalStateException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - student not found\n");
        }
        
        // Test 7: Login with wrong password
        System.out.println("Test 7: Logging in with wrong password");
        try {
            hub.loginStudent("ValidStudent", "wrongpassword");
        } catch (SecurityException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - wrong password detected\n");
        }
        
        // Test 8: Blank username in login
        System.out.println("Test 8: Logging in with blank username");
        try {
            hub.loginStudent("", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank username detected\n");
        }
    }

    public static void testStudentExceptions() {
        // Test 1: Null name in Student constructor
        System.out.println("Test 1: Creating student with null name");
        try {
            Student student = new Student(null, "password123", "test@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null name detected\n");
        }
        
        // Test 2: Blank password in Student constructor
        System.out.println("Test 2: Creating student with blank password");
        try {
            Student student = new Student("TestUser", "   ", "test@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank password detected\n");
        }
        
        // Test 3: Invalid email in Student constructor
        System.out.println("Test 3: Creating student with invalid email");
        try {
            Student student = new Student("TestUser2", "password123", "notanemail");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - invalid email detected\n");
        }
        
        // Test 4: Name contains @ in Student constructor
        System.out.println("Test 4: Creating student with @ in name");
        try {
            Student student = new Student("Test@User", "password123", "test@email.com");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - @ in name detected\n");
        }
        
        // Create valid student for next tests
        Student validStudent = new Student("ValidUser", "password123", "valid@email.com");
        
        // Test 5: Duplicate student name
        System.out.println("Test 5: Creating student with duplicate name");
        try {
            Student duplicate = new Student("ValidUser", "password456", "another@email.com");
        } catch (IllegalStateException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - duplicate name detected\n");
        }
        
        // Test 6: Change name with @ symbol
        System.out.println("Test 6: Changing name to include @");
        try {
            validStudent.changeName("New@Name");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - @ in new name detected\n");
        }
        
        // Test 7: Submit assignment with null title
        System.out.println("Test 7: Submitting assignment with null title");
        try {
            validStudent.submitAssignment(null, "This is a description");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null title detected\n");
        }
        
        // Test 8: Submit assignment with blank description
        System.out.println("Test 8: Submitting assignment with blank description");
        try {
            validStudent.submitAssignment("Assignment Title", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank description detected\n");
        }
        
        // Test 9: Fill up assignments and try to add more (exceeding capacity)
        System.out.println("Test 9: Exceeding assignment capacity");
        try {
            validStudent.submitAssignment("Assignment 1", "Description 1");
            validStudent.submitAssignment("Assignment 2", "Description 2");
            validStudent.submitAssignment("Assignment 3", "Description 3");
            validStudent.submitAssignment("Assignment 4", "Description 4");
            validStudent.submitAssignment("Assignment 5", "Description 5");
            validStudent.submitAssignment("Assignment 6", "Description 6"); // This should fail
        } catch (IllegalStateException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - assignment limit reached\n");
        }
    }

    public static void testAssignmentExceptions() {
        // Test 1: Null title
        System.out.println("Test 1: Creating assignment with null title");
        try {
            Assignment assignment = new Assignment(null, "Valid description");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null title detected\n");
        }
        
        // Test 2: Null description
        System.out.println("Test 2: Creating assignment with null description");
        try {
            Assignment assignment = new Assignment("Valid Title", null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null description detected\n");
        }
        
        // Test 3: Blank title
        System.out.println("Test 3: Creating assignment with blank title");
        try {
            Assignment assignment = new Assignment("   ", "Valid description");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank title detected\n");
        }
        
        // Test 4: Blank description
        System.out.println("Test 4: Creating assignment with blank description");
        try {
            Assignment assignment = new Assignment("Valid Title", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - blank description detected\n");
        }
        
        // Test 5: Title too long (over 200 characters)
        System.out.println("Test 5: Creating assignment with title over 200 characters");
        try {
            String longTitle = "a".repeat(201);
            Assignment assignment = new Assignment(longTitle, "Valid description");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - title too long detected\n");
        }
        
        // Test 6: Title contains profanity
        System.out.println("Test 6: Creating assignment with profanity in title");
        try {
            Assignment assignment = new Assignment("This is a damn title", "Valid description");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - profanity detected\n");
        }
        
        // Test 7: Description contains .exe
        System.out.println("Test 7: Creating assignment with .exe in description");
        try {
            Assignment assignment = new Assignment("Valid Title", "Please download virus.exe");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - .exe detected\n");
        }
        
        // Test 8: Setting null title via setter
        System.out.println("Test 8: Setting null title via setter");
        try {
            Assignment assignment = new Assignment("Initial Title", "Description");
            assignment.setTitle(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null title via setter detected\n");
        }
        
        // Test 9: Setting null description via setter
        System.out.println("Test 9: Setting null description via setter");
        try {
            Assignment assignment = new Assignment("Title", "Initial Description");
            assignment.setDescription(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("Exception triggered intentionally - null description via setter detected\n");
        }
    }
}