package avajlauncher;

public class CustomException extends Exception {
    
    public CustomException(String errorMessage) {
        System.out.println(errorMessage);
    } 
}