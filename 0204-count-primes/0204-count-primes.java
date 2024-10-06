class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        // Initialize a boolean array to track prime numbers.
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes algorithm.
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Marking multiples of i as non-prime.
                }
            }
        }

        // Counting the prime numbers.
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
