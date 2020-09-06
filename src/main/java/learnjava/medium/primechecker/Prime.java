package learnjava.medium.primechecker;

public class Prime {

    /*public void checkPrime(int... n) {
        for (int num : n) {
            BigInteger bi = BigInteger.valueOf(num);
            if (bi.isProbablePrime(5)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }*/

    /*public void checkPrime(int... n) {
        Arrays.stream(n)
                .mapToObj(BigInteger::valueOf)
                .filter(bigInt -> bigInt.isProbablePrime(5))
                .forEach(prime -> System.out.print(prime + " "));
        System.out.println();
    }*/

    public void checkPrime(int... n) {
        for (int num : n) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    /*private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }*/

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
