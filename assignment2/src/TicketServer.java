import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class TicketServer {
    // List to maintain available seats
    private static final List<Integer> availableSeats = new ArrayList<>();
    // Lock object for synchronization
    private static final Object lock = new Object();

    static {
        // TODO: initialize 20 unique seats
        for (int i = 1; i <= 10; i++) {
            availableSeats.add(i);
        }
    }

    public static void main (String[]args){
        // TODO: create new socket with port 8080 and limit thread count to 5
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Ticket Server is running on port 8080...");

            ExecutorService threadPool = Executors.newFixedThreadPool(5);

            while (true) {
                // Client connected. should be printed if client access the server.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                threadPool.execute(new TicketHandler((clientSocket)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class TicketHandler implements Runnable {
        private final Socket clientSocket;

        public TicketHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                boolean seatBooked = false;
                 while (!seatBooked) {
                     // TODO:
                     // Step 1: Show available seats to the client
                     synchronized (lock) {
                         if (availableSeats.isEmpty()) {
                             out.println("No seats available. Disconnecting...");
                             return;
                         }
                         out.println("Available seats: " + availableSeats);
                     }
                     // Step 2: Receive the chosen seat number from the client
                     String chosenSeatStr = in.readLine();
                     if (chosenSeatStr == null) break;
                     int chosenSeat;
                     try {
                         chosenSeat = Integer.parseInt(chosenSeatStr.trim());
                     } catch (NumberFormatException e) {
                         out.println("Invalid seat number. Please try againe.");
                         continue;
                     }
                     // Step 3: Attempt to book the chosen seat
                     synchronized (lock) {
                         // TODO: Check if the seat is available and book it if possible
                         // Send success or failure messages back to the client
                         if (availableSeats.contains(chosenSeat)) {
                             availableSeats.remove(Integer.valueOf(chosenSeat));
                             seatBooked = true;
                             out.println("Seat " + chosenSeat + " booked successfully! Remaining seats: " + availableSeats);
                         } else {
                             out.println("Seat " + chosenSeat + " is already taken. Please choose another seat.");
                         }
                     }
                 }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // TODO: Client disconnected. should be printed if the client is off the server.
                try {
                    clientSocket.close();
                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}