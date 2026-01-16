/*
 * ASSIGNMENT CLASS - VALIDATION GUIDE ===================================
 * 
 * This class was given to you WITHOUT validation. Your job: Add validation to prevent bad data.
 * 
 * THINK LIKE A HACKER: - What if someone puts null? - What if someone puts empty string? - What if
 * someone puts profanity? - What if someone tries to upload malware (.exe)? - What if someone makes
 * title 10,000 characters long?
 * 
 * VALIDATION PATTERNS TO ADD: 1. Null checks - throw IllegalArgumentException 2. Blank checks -
 * throw IllegalArgumentException 3. Length checks - throw IllegalArgumentException 4. Content
 * checks - throw IllegalArgumentException
 * 
 * WHERE TO ADD VALIDATION: - In setTitle() - validates all title rules - In setDescription() -
 * validates all description rules - Constructor calls these setters, so validation applies
 * automatically!
 */

public class Assignment {
    private String title;
    private String description;
    private int descriptionLength;

    // List of common profanity to block (simplified for example)
    private static final String[] PROFANITY = {"damn", "hell", "crap", "fuck", "shit", "ass"};

    public Assignment(String title, String description) {
        // Students: add your own validation and exceptions as you see fit
        // REMINDER: Constructor calls setters, which do the validation
        setTitle(title);
        setDescription(description);
    }

    /*
     * VALIDATION PATTERN: Check in this order 1. Is it null? (most severe) 2. Is it blank/empty?
     * (second most severe) 3. Does it meet format requirements? (specific rules) 4. Does it meet
     * content requirements? (what's inside)
     */
    public void setTitle(String title) {
        // VALIDATION 1: Null check
        // WHY: Can't do anything with null - will cause NullPointerException
        if (title == null) {
            throw new IllegalArgumentException("title is null.");
        }

        // VALIDATION 2: Blank check
        // WHY: Empty or whitespace-only titles are not useful
        // TIP: .trim() removes spaces, then check if .isEmpty()
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("title is blank.");
        }

        // VALIDATION 3: Length check (max 200 characters)
        // WHY: Prevents database issues, display issues, abuse
        if (title.length() > 200) {
            throw new IllegalArgumentException("title exceeds 200 characters.");
        }

        // VALIDATION 4: Profanity check
        // WHY: Keep content appropriate for educational setting
        // TIP: Convert to lowercase to catch "DAMN", "Damn", "damn"
        String lowerTitle = title.toLowerCase();
        for (String word : PROFANITY) {
            if (lowerTitle.contains(word)) {
                throw new IllegalArgumentException("title contains profanity.");
            }
        }

        // If we made it here, title is valid!
        this.title = title;
    }

    /*
     * Same validation pattern for description Notice: Similar checks but different requirements -
     * Description can be longer than title - Description also checks for .exe files
     */
    public void setDescription(String description) {
        // VALIDATION 1: Null check
        if (description == null) {
            throw new IllegalArgumentException("description is null.");
        }

        // VALIDATION 2: Blank check
        if (description.trim().isEmpty()) {
            throw new IllegalArgumentException("description is blank.");
        }

        // VALIDATION 3: Security check - .exe files
        // WHY: Prevent malware distribution through assignments
        // TIP: .toLowerCase() catches ".exe", ".EXE", ".Exe"
        if (description.toLowerCase().contains(".exe")) {
            throw new IllegalArgumentException("description contains .exe file reference.");
        }

        // VALIDATION 4: Profanity check (same as title)
        String lowerDesc = description.toLowerCase();
        for (String word : PROFANITY) {
            if (lowerDesc.contains(word)) {
                throw new IllegalArgumentException("description contains profanity.");
            }
        }

        // If we made it here, description is valid!
        this.description = description;
        this.descriptionLength = description.length();
    }

    /*
     * GETTERS - No validation needed WHY: We only validate when SETTING data, not GETTING it The
     * data is already validated when it was set
     */
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionLength() {
        return descriptionLength;
    }
}

/*
 * ============================================ HOW TO DO THIS ON A TEST:
 * ============================================
 * 
 * 1. READ the given code first - What fields does it have? - What methods does it have? - What
 * validation already exists?
 * 
 * 2. THINK about what could go wrong - Write down each potential problem - null, blank, too long,
 * bad content, etc.
 * 
 * 3. ADD validation checks in order: - Null first (most severe) - Blank second - Format/length
 * third - Content last
 * 
 * 4. USE appropriate exception types: - IllegalArgumentException for bad parameters -
 * IllegalStateException for bad object state - SecurityException for authentication issues
 * 
 * 5. WRITE descriptive error messages: - "title is null" (clear and specific) - NOT "bad input"
 * (too vague)
 * 
 * 6. TEST each validation: - Create tests in UniversalTester - Make sure each exception can be
 * triggered - Use try-catch to catch gracefully
 * 
 * ============================================ COMMON VALIDATION SCENARIOS:
 * ============================================
 * 
 * Strings: - null check - blank check (.trim().isEmpty()) - length check (.length()) - format check
 * (.contains("@"), etc.) - content check (profanity, file extensions)
 * 
 * Numbers: - negative check (< 0) - zero check (== 0 or <= 0) - range check (< min || > max)
 * 
 * Arrays: - null check - empty check (.length == 0) - capacity check (index < length)
 * 
 * Objects: - null check - required fields check - duplicate check (uniqueness)
 * 
 * ============================================
 */
