package Companies.Mandark;

import java.util.*;

public class EmployeeListing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        List<String> list = new ArrayList<>();

        while (!input.equals("Exit")) {
            input = sc.nextLine();
            String[] command = input.split(",");

            switch (command[0]) {
                case "Print_Summary":
                    printSummary(list);
                default:
                    list.add(input);
            }
        }

    }

    private static void printSummary(List<String> list) {

        List<String> checkManager = new ArrayList<>();
        List<String> singleNameEmployees = new ArrayList<>();

        for (String details : list) {
            checkManager(details, checkManager);
            singleNameEmployees(details, singleNameEmployees);
        }

        System.out.println("Entries in manager.csv file -");
        for (String manager : checkManager)
            System.out.println(manager);

        System.out.println();

        System.out.println("Entries in single_name_employees.csv file -");
        for (String singleName : singleNameEmployees)
            System.out.println(singleName);
    }

    private static List<String> checkManager(String details, List<String> checkManager) {

        String[] str = details.split(",");

        if (str[1].equals("Manager") && str[2].equals("R&D")) {
            checkManager.add(details);
        }

        return checkManager;
    }

    private static List<String> singleNameEmployees(String details, List<String> singleNameEmployees) {

        String[] str = details.split(",");
        boolean isLastName = false;

        for (int i = 0; i < str[0].length(); i++) {
            if (str[0].charAt(i) == ' ') {
                isLastName = true;
                break;
            }
        }

        if (isLastName == false) {
            singleNameEmployees.add(details);
        }

        return singleNameEmployees;
    }
}
