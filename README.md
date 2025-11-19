# Dress Inventory Notification System

This Java application implements a notification system for an online fashion store using the Observer design pattern. The system notifies customers when dresses they are interested in become available in stock.

## Overview

The application consists of:
- **Subject Interface**: Defines methods for registering, removing, and notifying observers
- **Concrete Subject**: `DressInventory` class that manages dress stock and observer notifications
- **Observer Interface**: Defines the update method for observers
- **Concrete Observer**: `Customer` class that receives notifications when requested dresses are back in stock

## Class Structure

### Interfaces
- `Subject`: Manages observer registration and notification
- `Observer`: Defines update method for receiving notifications

### Classes
- `DressInventory`: Concrete implementation of Subject that tracks dress inventory and notifies observers
- `Customer`: Concrete implementation of Observer that represents a customer waiting for a specific dress
- `Notification`: Main class that demonstrates the system functionality

## Features

- Tracks dress inventory status and details
- Automatically notifies customers when their requested dress becomes available
- Provides detailed dress information including:
  - Dress code
  - Color
  - Price
  - Size
  - Available sizes and colors
- Sends confirmation of successful notifications

## Usage Example

The system demonstrates notifying a customer (lizza@gmail.com) when a red dress (RD001) becomes available in stock, showing:
- Customer notification email
- Detailed dress information
- Confirmation of successful delivery

## How to Run

1. Compile the Java files:
   ```bash
   javac Notification.java
    ```

2. Run the application:
   ```bash
   java Notification
    ```

## Output Example
Notification sent to lizza@gmail.com: Dear Customer, We are from Fashion World Online Shopping Platform, pleased to inform you that the dress you requested is back in stock!

<img width="1888" height="646" alt="7 - Code Output" src="https://github.com/user-attachments/assets/45ff4ed3-c213-47dc-bcf1-4a7f86b2dcaa" />

Confirmation: Notification was successfully sent to lizza@gmail.com

