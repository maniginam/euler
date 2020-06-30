(ns euler.level1.problem007-spec
    (:require
      [speclj.core :refer :all]
      [euler.level1.problem007 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=7

(describe "Euler Problem #7"

          (it "gets next prime number"
              (should= 5 (next-prime [2 3]))
              (should= 7 (next-prime [2 3 5]))
              (should= 17 (next-prime [2 3 5 7 11 13]))
              (should= 19 (next-prime [2 3 5 7 11 13 17]))
              (should= 39 (next-prime [37])))

          (it "Solves #7"
              (should= 2 (euler-7 1))
              (should= 3 (euler-7 2))
              (should= 5 (euler-7 3))
              (should= 13 (euler-7 6))
              (should= 13 (euler-7 6))
              (should= 29 (euler-7 10))
              (should= 104743 (euler-7 10001))))

(run-specs)