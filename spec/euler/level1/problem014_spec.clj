(ns euler.level1.problem014-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem014 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=14
;n → n/2 (n is even)
;n → 3n + 1 (n is odd)
;Which starting number, under one million, produces the longest chain?
;1
;2	1
;3	10	5	16	8	4	2	1
;4	2	1
;5	16	8	4	2	1
;6	3	10	5	16	8	4	2	1
;7	22	11	34	17	52	26	13	40	20	10	5	16	8	4	2	1
;8	4	2	1
;9	28	14	7	22	11	34	17	52	26	13	40	20	10	5	16	8	4	2	1
;10	5	16	8	4	2	1
;11	34	17	52	26	13	40	20	10	5	16	8	4	2	1
;12	6	3	10	5	16	8	4	2	1
;13	40	20	10	5	16	8	4	2	1

(describe "Euler Problem #14"

  (it "counts elements of collatz seq of n"
    (should= 1 (count-collatz 1))
    (should= 2 (count-collatz 2))
    (should= 8 (count-collatz 3))
    (should= 3 (count-collatz 4))
    (should= 10 (count-collatz 13)))

  (it "Solves #14"
    (should= 1 (euler-14 2))
    (should= 2 (euler-14 3))
    (should= 3 (euler-14 4))
    (should= 3 (euler-14 5))
    (should= 3 (euler-14 6))
    (should= 6 (euler-14 7))
    (should= 9 (euler-14 10))
    (should= 837799 (euler-14 1000000)))
  )

(run-specs)
