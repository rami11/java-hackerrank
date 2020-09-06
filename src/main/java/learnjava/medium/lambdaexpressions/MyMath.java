package learnjava.medium.lambdaexpressions;

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return num -> num % 2 == 1;
    }

    public PerformOperation isPrime() {
        return num -> {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0)
                    return false;
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return num -> {
            String[] numStrArray = String.valueOf(num).split("");
            int i = 0, j = numStrArray.length - 1;
            while (i != j) {
                if (!numStrArray[i++].equals(numStrArray[j--])) {
                    return false;
                }
            }
            return true;
        };
    }

}
