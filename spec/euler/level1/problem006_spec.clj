(ns euler.level1.problem006-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem006 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=6

(describe "Euler Problem #6"

  (it "finds sum of squares"
      (should= 1 (sum-of-squares 1))
      (should= 5 (sum-of-squares 2))
      (should= 14 (sum-of-squares 3))
      (should= 30 (sum-of-squares 4))
      (should= 55 (sum-of-squares 5))
      (should= 338350 (sum-of-squares 100)))

  (it "finds square of sum"
      (should= 1 (square-of-sum 1))
      (should= 9 (square-of-sum 2))
      (should= 36 (square-of-sum 3))
      (should= 100 (square-of-sum 4))
      (should= 225 (square-of-sum 5))
      (should= 25502500 (square-of-sum 100)))

  (it "Solves #6"
    (should= 0 (euler-6 1))
    (should= 4 (euler-6 2))
    (should= 22 (euler-6 3))
    (should= 70 (euler-6 4))
    (should= 170 (euler-6 5))
    (should= 25164150 (euler-6 100))))

(run-specs)
