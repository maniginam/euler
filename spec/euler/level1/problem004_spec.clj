(ns euler.level1.problem004-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem004 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=4

(describe "Euler Problem #4"
          (it "turns digits into sequence"
              (should= [9 0 0 9] (int-to-seq 9009))
              (should= [8 0 9] (int-to-seq 908))
              (should= [3 2 1 9] (int-to-seq 9123))
              (should= [0 0 0 1] (int-to-seq 1000)))

          (it "checks for palindrome"
              (should (palindrome? []))
              (should (palindrome? [1]))
              (should-not (palindrome? [0 0 0 1]))
              (should (palindrome? [9 0 0 9]))
              (should-not (palindrome? [9 0 8]))
              (should-not (palindrome? [9 1 2 3])))

          (it "converts seqs to ints"
              (should-be-nil (seq-to-int []))
              (should= 1 (seq-to-int [1]))
              (should= 99 (seq-to-int [9 9]))
              (should= 1000 (seq-to-int [1 0 0 0])))

          (it "finds test-values"
              (should= [9 6 3] (get-test-values 3 [3 2 1]))
              (should= [5 4 3 2 1] (get-test-values 1 [5 4 3 2 1]))
              (should= [10 8 6 4 2] (get-test-values 2 [5 4 3 2 1])))

          (it "finds all palindromes"
              (should= [4 2 2 1] (find-palindromes 1 3 [2 1]))
              (should= [9 6 3 6 4 2 3 2 1] (find-palindromes 1 4 [3 2 1])))

          (it "finds max palindrome"
              (should= 9 (find-max-palindrome [5 6 7 8 9]))
              (should= 9009 (find-max-palindrome [5 9009 999 11 2 6])))

          (it "Solves #4"
              (should= 9 (euler-4 1))
              (should= 9009 (euler-4 2))
              (should= 906609 (euler-4 3))))
              ;(should= 906609 (euler-4 4))))

(run-specs)
