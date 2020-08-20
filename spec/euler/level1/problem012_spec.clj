(ns euler.level1.problem012-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem012 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=12
;What is the value of the first triangle number to have over five hundred divisors?

(describe "Euler Problem #12"
  (it "counts factors of each tri num"
    (should= 4 (factor-count 6))
    (should= 4 (factor-count 10))
    (should= 6 (factor-count 28))
    (should= 9 (factor-count 36)))

  (it "Solves #12"
    (should= [3 6 4] (euler-12 2))
    (should= [3 6 4] (euler-12 3))
    (should= [7 28 6] (euler-12 5))
    (should= [15 120 16] (euler-12 10))
    ;(should= [12375 76576500 576] (euler-12 500))
    ))
(run-specs)
