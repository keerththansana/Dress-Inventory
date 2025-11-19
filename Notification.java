import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String dressCode);
}

// Concrete subject
class DressInventory implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Boolean> stockStatus = new HashMap<>();
    private Map<String, String> dressDetails = new HashMap<>();

    public void setDressDetails(String dressCode, String details) {
        dressDetails.put(dressCode, details);
    }

    public void setStockStatus(String dressCode, boolean inStock) {
        stockStatus.put(dressCode, inStock);
        if (inStock) {
            notifyObservers(dressCode);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String dressCode) {
        for (Observer observer : observers) {
            observer.update(stockStatus.get(dressCode), dressCode, dressDetails.get(dressCode));
        }
    }
}

// Observer interface
interface Observer {
    void update(boolean inStock, String dressCode, String details);
}

// Concrete observer
class Customer implements Observer {
    private String email;
    private String requestedDressCode;

    public Customer(String email, String requestedDressCode) {
        this.email = email;
        this.requestedDressCode = requestedDressCode;
    }

    @Override
    public void update(boolean inStock, String dressCode, String details) {
        if (inStock && dressCode.equals(requestedDressCode)) {
            sendNotification(details);
            confirmNotification();
        }
    }

    private void sendNotification(String details) {
        System.out.println("Notification sent to " + email + ": Dear Customer, We are from Fashion World Online Shopping Platform, pleased to inform you that the dress you requested is back in stock!");
        System.out.println("\nDetails: " + details);
        System.out.println("\nFor more details, visit our website: http://www.fashionWorld.com");
        // Implement sending notification email to the customer
    }

    private void confirmNotification() {
        System.out.println("\n\nConfirmation: Notification was successfully sent to " + email);
    }
}

public class Notification {
    public static void main(String[] args) {
        // Create subject
        DressInventory dressInventory = new DressInventory();

        // Set dress details
        String dressCodeRed = "RD001";
        String detailsRed = "\n   Dress Code        : RD001\n   Color             : Red\n   Price             : 1800 LKR\n   Size              : Medium\n   Available Sizes   : S, M, L\n   Available Colors  : Red, Blue, Black, Green, Purple";

        dressInventory.setDressDetails(dressCodeRed, detailsRed);

        // Lizza's email and requested dress code
        String email = "lizza@gmail.com";
        String requestedDressCode = "RD001";

        // Create a customer (observer)
        Customer lizza = new Customer(email, requestedDressCode);

        // Register Lizza as an observer
        dressInventory.registerObserver(lizza);

        // Simulate the dress coming back in stock
        dressInventory.setStockStatus(dressCodeRed, true);
    }
}
