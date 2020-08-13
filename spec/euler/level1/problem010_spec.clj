(ns euler.level1.problem010-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem010 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=10
;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.

(describe "Euler Problem #10"

  (it "finds all primes < n using lazy-seq"
      (should= [2] (take 1 (primes)))
      (should= [2 3] (take 2 (primes)))
      (should= [2 3 5] (take 3 (primes)))
      (should= [2 3 5 7] (take 4 (primes)))
      (should= [2 3 5 7 11 13 17 19 23 29] (take 10 (primes))))

  (it "gets the sum of all primes < n"
      (should= 0 (sum-of-primes 1))
      (should= 0 (sum-of-primes 2))
      (should= 2 (sum-of-primes 3))
      (should= 17 (sum-of-primes 4))
      ;(should= 142913828922 (sum-of-primes 2000000))
      ))

(run-specs)

;old code from earlier attempt
          ;(it "gets all prime factors of n"
          ;    (should= [] (prime-factors 1))
          ;    (should= [2] (prime-factors 2))
          ;    (should= [3] (prime-factors 3))
          ;    (should= [2 2] (prime-factors 4))
          ;    (should= [5] (prime-factors 5))
          ;    (should= [2 3] (prime-factors 6))
          ;    (should= [2 2 2] (prime-factors 8))
          ;    (should= [3 3] (prime-factors 9))
          ;    (should= [2 5] (prime-factors 10))
          ;    (should= [2 2 2 2] (prime-factors 16))
          ;    (should= [3 7] (prime-factors 21))
          ;    (should= [11 11] (prime-factors 121))
          ;    (should= [73 137] (prime-factors 10001)))
          ;
          ;(it "tests for primeness"
          ;    (should (is-prime? 1))
          ;    (should (is-prime? 2))
          ;    (should (is-prime? 3))
          ;    (should-not (is-prime? 4))
          ;    (should (is-prime? 5)))
          ;
          ;;(it "gets the primes below n"
          ;;    (should= [] (get-primes 2))
          ;;    (should= [2] (get-primes 3))
          ;;    (should= [2 3] (get-primes 4))
          ;;    (should= [2 3 5 7] (get-primes 10))
          ;;    (should= [10007 10009 10037] (get-primes 10100))
          ;;)
          ;
          ;(it "tests for divisibility"
          ;    (should (divisible? 4 [2 3 5 7 11 13 17 19]))
          ;    (should-not (divisible? 5 [2 3 5 7 11 13 17 19]))
          ;    (should (divisible? 15 [2 3 5 7 11 13 17 19]))
          ;    (should (divisible? 100 [2 3 5 7 11 13 17 19]))
          ;    )
          ;
          ;(it "Solves #10"
          ;    (should= 0 (euler-10 2))
          ;    (should= 2 (euler-10 3))
          ;    (should= 5 (euler-10 4))
          ;    (should= 5 (euler-10 5))
          ;    (should= 10 (euler-10 7))
          ;    (should= 17 (euler-10 10))
          ;    ;(should= 17 (euler-10 200000))
          ;    )