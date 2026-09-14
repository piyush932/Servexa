package com.example.servicerequest;

import java.util.Scanner;

public class Main {

    static String[] requests = new String[20];
    static int requestCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SERVEXA =====");
            System.out.println("1. Create Request");
            System.out.println("2. View All Requests");
            System.out.println("3. Search Request by ID");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    createRequest(scanner);
                    break;

                case "2":
                    viewAllRequests();
                    break;

                case "3":
                    System.out.print("Enter Request ID: ");

                    String idInput = scanner.nextLine();
                    int requestId = Integer.parseInt(idInput);

                    searchById(requestId);
                    break;

                case "4":
                    System.out.println("Exiting SERVEXA...");
                    System.out.println("Requests: " + requestCount);
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }

    static void createRequest(Scanner scanner) {

        System.out.print("Enter request title: ");

        String title = scanner.nextLine();

        if (title.trim().isEmpty()) {

            System.out.println("Request title cannot be empty.");

        } else {

            requests[requestCount] = title;
            requestCount++;

            System.out.println("Request created successfully!");
            System.out.println("Request ID: " + formatId(requestCount));
        }
    }

    static void viewAllRequests() {

        if (requestCount == 0) {

            System.out.println("No requests found.");

        } else {

            System.out.println("Requests :-");

            for (int i = 0; i < requestCount; i++) {

                System.out.println(
                        "ID: " + formatId(i + 1)
                                + " | " + requests[i]
                );
            }
        }
    }

    static void searchById(int requestId) {

        if (requestId < 1 || requestId > requestCount) {

            System.out.println("Request not found.");

        } else {

            System.out.println("Request found:");
            System.out.println(requests[requestId - 1]);
        }
    }

    static String formatId(int id) {

        return String.format("REQ-%03d", id);
    }
}