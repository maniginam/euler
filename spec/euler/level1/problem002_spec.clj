(ns euler.level1.problem002-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem002 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=2
;first solved: 6/10/20

(describe "Euler Problem #2"

(it "checks that element is not > 4MM"
	(should= true (another-element? 2 4000005))
	(should= true (another-element? 2 3))
	(should= true (another-element? 9 4000005))
	(should= false (another-element? 1 1)))

(it "gets the next element"
	(should= 3 (get-next-element [1 2]))
	(should= 5 (get-next-element [1 2 3]))
	(should= 8 (get-next-element [1 2 3 5]))
	(should= 89 (get-next-element [1 2 3 5 8 13 21 34 55])))

(it "gets fibonacci sequence"
	(should= [1 2] (fib 2))
	(should= [1 2 3] (fib 3))
	(should= [1 2 3 5] (fib 4))
	(should= [1 2 3 5 8 13 21 34 55 89] (fib 10))
	(should= 3524578 (last(fib 32)))
	(should= 3524578 (last(fib 40))))

(it "Solves #2"
	(should= 0 (euler-2 0))
	(should= 0 (euler-2 1))
	(should= 2 (euler-2 2))
	(should= 2 (euler-2 4))
	(should= 10 (euler-2 5))
	(should= 44 (euler-2 8))
	(should= 44 (euler-2 10))
	(should= 4613732 (euler-2 32))
	(should= 4613732 (euler-2 40))))
  
(run-specs)
