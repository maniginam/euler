(ns euler.level1.problem005-spec
    (:require
      [speclj.core :refer :all]
      [euler.level1.problem005 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=5

(describe "Euler Problem #5"

  (it "finds smallest root"
      (should-be-nil (get-smallest-root 2))
      (should-be-nil (get-smallest-root 3))
      (should-be-nil (get-smallest-root 5))
      (should-be-nil (get-smallest-root 10))
      (should-be-nil (get-smallest-root 21))
      (should-be-nil (get-smallest-root 99))
      (should= 2 (get-smallest-root 4))
      (should= 2 (get-smallest-root 8))
      (should= 3 (get-smallest-root 9))
      (should= 2 (get-smallest-root 16))
      (should= 3 (get-smallest-root 81))
      (should= 2 (get-smallest-root 32))
      (should= 10 (get-smallest-root 1000))
      (should= 11 (get-smallest-root 14641)))

  (it "tests for perfect root"
      (should-not (is-perfect-root? 0))
      (should-not (is-perfect-root? 1))
      (should-not (is-perfect-root? 2))
      (should-not (is-perfect-root? 3))
      (should (is-perfect-root? 4))
      (should-not (is-perfect-root? 5))
      (should (is-perfect-root? 8))
      (should (is-perfect-root? 9))
      (should (is-perfect-root? 49))
      (should-not (is-perfect-root? 50)))

  (it "Solves #5"
      (should= 1 (euler-5 1))
      (should= 2 (euler-5 2))
      (should= 6 (euler-5 3))
      (should= 12 (euler-5 4))
      (should= 60 (euler-5 5))
      (should= 60 (euler-5 6))
      (should= 420 (euler-5 7))
      (should= 840 (euler-5 8))
      (should= 232792560 (euler-5 20))
      (should= 1314361138437547200 (euler-5 42))))
      ;n > 42; integer overflow! out of bits!

(run-specs)
