import java.util.*;

public class FactorChallenge {

    public static void factorList (int num, List list) {
    for (int i = 1; i < num + 1; i++) {
            if (num % i == 0) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int userInt;
        boolean again = true;
        Scanner scanner = new Scanner(System.in);
        while (again) {
            // Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter an integer, and I will tell you its factors!");
                userInt = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter an integer.\nEnter an " +
                        "integer, and I will tell you" +
                        " its factors!");
                scanner.nextLine();
                userInt = scanner.nextInt();
            }
            List<Integer> posFactorList = new ArrayList<>();
            switch (userInt) {
                case 0:
                    System.out.println("Every integer, except 0, is a factor of your integer.");
                    break;
                case 1:
                    System.out.println("Your integer's factor is [" + userInt +
                            "].");
                    break;
                default:
                    if (userInt > 1) {
                        FactorChallenge pos = new FactorChallenge();
                        pos.factorList(userInt, posFactorList);
                        if (posFactorList.size() == 2) {
                            System.out.println("Your integer's factors are " + posFactorList + ", and it's a prime number.");
                        } else {
                            System.out.println("Your integer's factors are " + posFactorList + ".");
                        }
                    } else if (userInt < 0) {
                        int userIntPos = userInt * -1;
                        FactorChallenge neg = new FactorChallenge();
                        neg.factorList(userIntPos, posFactorList);
                        List<Integer> negFactorList = new ArrayList<>();
                        for (int i = 0; i < posFactorList.size(); i++) {
                            int negFactor = posFactorList.get(i) * -1;
                            negFactorList.add(negFactor);
                        }
                        List<Integer> allFactorList = new ArrayList<>();
                        for (int i = 0; i < posFactorList.size(); i++) {
                            allFactorList.add(negFactorList.get(i));
                            allFactorList.add(posFactorList.get(i));
                        }
                        System.out.println("Your integer's factors are " + allFactorList + ".");
                    }
            }
            do {
                try {
                    System.out.println("Do you want to enter another integer? Enter " +
                            "'y' or 'n'.");
                    char response = scanner.next().charAt(0);
                    if (response == 'y') {
                        again = true;
                    } else if (response == 'n') {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    } else {
                        System.out.println("You didn't enter 'y' or 'n'.");
                        again = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You didn't enter 'y' or 'n'.");
                    again = false;
                }
            }
            while (!again);
        }
    }
}