(ns euler.level1.problem009-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem009 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=9

(describe "Euler Problem #9"

          (it "finds square root of a number"
              (should-be-nil (sqrt 1))
              (should-be-nil (sqrt 2))
              (should-be-nil (sqrt 3))
              (should= 2 (sqrt 4))
              (should= 3 (sqrt 9))
              (should= 5 (sqrt 25)))

          (it "gets all squares in range"
              (should= [4 9 16 25 36 49 64 81 100] (get-squares 10))
              (should= [4 9 16 25 36 49 64 81 100 121 144 169 196 225
                        256 289 324 361 400 441 484 529 576 625] (get-squares 25)))

          (it "tests for perfect square"
              (should (is-perfect-square? 4))
              (should-not (is-perfect-square? 3))
              (should (is-perfect-square? 25))
              (should-not (is-perfect-square? 21)))

          (it "gets all triples with numbers in range n"
              (should= [] (get-triples 3))
              (should= [[3 4 5]] (get-triples 6))
              (should= [[3 4 5] [6 8 10]] (get-triples 10)))

          (it "Solves #9"
              (should= [] (euler-9 1))
              (should= [] (euler-9 6))
              (should= [60] (euler-9 12))
              (should= [480] (euler-9 24))
              (should= [31875000] (euler-9 1000))))

(run-specs)


; old bad code
;(it "gets all square adders of each square"
;    (should= [[16 9]] (get-adders 25 10))
;    (should= [[576 49] [400 225]] (get-adders 625 26))
;    ;(should= [16 9] (get-adders 25 1000))
;    )
;(it "flattens the adder-sets"
;    (should= [16 9] (flatten-adder-sets [[16 9]]))
;    (should= [[16 9] [64 36] [144 25] [144 81] [225 64] [256 144] [576 49] [400 225]] (flatten-adder-sets [[[16 9]] [[64 36]] [[144 25]] [[144 81]] [[225 64]] [[256 144]] [[576 49] [400 225]]])))

;(it "gets all squared triples"
;    (should= [[9 16 25]] (get-squared-triples 6))
;    (should= [[9 16 25] [36 64 100]] (get-squared-triples 12))
;    (should= [[9 16 25] [36 64 100] [25 144 169] [81 144 225] [64 225 289]] (get-squared-triples 20)))

;(it "takes square root of each squared triple to find all triples"
;    (should= [[3.0 4.0 5.0]] (get-triples-old 6))
;    (should= [[3.0 4.0 5.0] [6.0 8.0 10.0]] (get-triples-old 12))
;    (should= [[3.0 4.0 5.0] [6.0 8.0 10.0] [5.0 12.0 13.0]
;              [9.0 12.0 15.0] [8.0 15.0 17.0]] (get-triples-old 20)))

;(it "gets sums of triples"
;    (should= [12.0] (gets-sums-of-triples 6))
;    (should= [12.0 24.0] (gets-sums-of-triples 12))
;    (should= [12.0 24.0 30.0 36.0 40.0] (gets-sums-of-triples 20))
;    (should= [12.0 24.0] (gets-sums-of-triples 500)))

;(it "sets big n's"
;    (should= 1 (set-n 1))
;    (should= 10 (set-n 10))
;    (should= 15 (set-n 30)))
