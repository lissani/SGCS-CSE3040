import java.io.*;
import java.net.*;
import java.util.Random;

public class TicketClient {
    public static void main(String[] args) {
        // TODO: create 5 clients
        for (int i=1; i<= 5; i++){
            String clientName = "Client"+i;
            Thread clientThread = new Thread(new ClientTask(clientName));
            clientThread.start();
        }
    }

    static class ClientTask implements Runnable {
        private final String clientName;

        public ClientTask(String clientName) {
            this.clientName = clientName;
        }

        @Override
        public void run() {
            // TODO: make a connection with the server as localhost and print “client_name* connected to the server.”
            try (Socket socket = new Socket("localhost", 8080);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println(clientName + " connected to the server");

                boolean seatBooked = false;

                while (!seatBooked) {
                    // TODO:
                    // Step 1: Receive and display available seats from the server
                    String availableSeats = in.readLine();
                    if (availableSeats == null || availableSeats.isEmpty()) {
                        System.out.println(clientName + ": No seats available");
                        break;
                    }
                    System.out.println(clientName + " received available seats, " + availableSeats);
                    // Step 2: Choose a random seat from the available seats
                    sleepRandomTime();
                    String[] seats = availableSeats.replace("Available seats: ", "").replace("[", "").replace("]", "").split(", ");
                    String chosenSeat = seats[new Random().nextInt(seats.length)];
                    System.out.println(clientName + " chosen seat: " + chosenSeat);
                    // Step 3: Send the chosen seat to the server
                    out.println(chosenSeat);
                    // Step 4: Receive booking confirmation or error
                    String response = in.readLine();
                    if (response != null && response.startsWith("Seat " + chosenSeat + " booked successfully")) {
                        System.out.println("["+clientName + "] " + response);
                        seatBooked = true;
                    } else if (response != null) {
                        System.out.println("["+clientName + "] " + response);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void sleepRandomTime() {
            try {
                // TODO: the client will wait for 5 to 10 seconds (use Random())
                int sleepTime = 5000 + new Random().nextInt(5000);
                Thread.sleep(sleepTime);
                System.out.println("["+clientName + "] " + "waiting for "+sleepTime/1000+" seconds");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
