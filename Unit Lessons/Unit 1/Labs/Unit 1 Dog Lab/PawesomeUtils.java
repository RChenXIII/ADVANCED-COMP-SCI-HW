public class PawesomeUtils {
    public static String generateDogTag(int dogId, char dogChar) {
        return ("" + dogId + dogChar);
    }
    
    
    public static char generateDogChar(int dogId) {
        return (char) ('F' + dogId % 10 + (dogId / 10) % 10 + dogId / 100 % 10);
    }
    
   
    public static int validateDogId(int dogId) {
        if (dogId >= 100 && dogId <= 999) {
            return dogId;
        } else {
            
            return (int) (Math.random() * 900) + 100;
        }
    }
    
    
    public static boolean validateDogTag(Dog dog) {
        
        int dogId = dog.getDogId();
        
       
        int validatedDogId = validateDogId(dogId);
        
        
        char generatedDogChar = generateDogChar(validatedDogId);
        
       
        String newDogTag = generateDogTag(validatedDogId, generatedDogChar);
        
        
        String currentDogTag = dog.getDogTag();
        
      
        return newDogTag.equals(currentDogTag);
    }
    

    public static String pickup(Dog dog, String personName) {
        if (dog.getOwnerName().equals(personName)) {
            return "Dog has been picked up successfully.";
        } else {
            return "Dog cannot leave. This is not their owner.";
        }
    }
    

    public static void checkIn(Dog dog, String personName) {
        
        if (validateDogTag(dog)) {
            dog.setStillInFacility(true);
            dog.setOwnerName(personName);
            System.out.println(dog.getName() + " has been successfully checked in.");
        } else {
            System.out.println("Entry denied. " + dog.getName() + " has an invalid dog tag.");
        }
    }
    

    public static int convertAgeToHumanAge(Dog dog) {
        int dogAge = dog.getAge();
        
        if (dogAge == 1) {
            return 15;
        } else if (dogAge == 2) {
            return 24;
        } else {

            return 24 + ((dogAge - 2) * 5);
        }
    }
    

    public static int convertAgeToDogYears(int humanYears) {
        if (humanYears <= 15) {
            return 1;
        } else if (humanYears <= 24) {
            return 2;
        } else {

            return 2 + ((humanYears - 24) / 5);
        }
    }
}