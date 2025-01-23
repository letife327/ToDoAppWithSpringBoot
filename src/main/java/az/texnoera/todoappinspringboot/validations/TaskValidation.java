package az.texnoera.todoappinspringboot.validations;

import org.springframework.stereotype.Component;

@Component
public class TaskValidation {
    public static boolean isValidPriority(String priority) {
        String newPriority = priority.toUpperCase();
        return newPriority.equals("MEDIUM")
                || newPriority.equals("HIGH")
                || newPriority.equals("LOW");
    }
    public static boolean isValidStatus(String status) {
        String newStatus = status.toUpperCase();
        return newStatus.equals("IN_PROGRESS")
                ||newStatus.equals("COMPLETED")
                ||newStatus.equals("PENDING");
    }
    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }
}
