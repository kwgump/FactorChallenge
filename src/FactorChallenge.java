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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer, and I will tell you its factors!");
        int userInt = scanner.nextInt();
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
    }
}