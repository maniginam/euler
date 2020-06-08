(ns euler.level1.problem001-spec
  (:use
    [speclj.core]
    [euler.level1.problem001]))

; http://projecteuler.net/index.php?section=problems&id=1

(describe "Euler Problem #1"

	(it "divisible by 3 or 5"
		(should= true (multiple-of-3-or-5? 0))
		(should= false (multiple-of-3-or-5? 1))
		(should= false (multiple-of-3-or-5? 2))
		(should= true (multiple-of-3-or-5? 3))
		(should= false (multiple-of-3-or-5? 4))
		(should= true (multiple-of-3-or-5? 5))
		(should= true (multiple-of-3-or-5? 6))
		(should= false (multiple-of-3-or-5? 7))
		(should= false (multiple-of-3-or-5? 8))
		(should= true (multiple-of-3-or-5? 9))
	)

  (it "Solves #1"
    (should= 23 (euler-1 10))
	(should= 78 (euler-1 20))
	(should= 233168 (euler-1 1000)))
  )

(run-specs)
