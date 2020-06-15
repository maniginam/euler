(ns euler.level1.problem003-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem003 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=3

(describe "Euler Problem #3"

(it "finds max prime factor"

	(should= 5 (next-factor 5))
	(should= 7 (next-factor 7))
	(should= 11 (next-factor 11))
	(should= 17 (next-factor 17))
	(should= 181 (next-factor 181))
	
	(should= 2 (next-factor 4))
	(should= 3 (next-factor 6))
	(should= 3 (next-factor 9))
	(should= 5 (next-factor 25))
	(should= 7 (next-factor 49))
	(should= 50 (next-factor 100))
	(should= 500 (next-factor 1000))
	(should= 2639 (next-factor 13195))
	(should= 8462696833 (next-factor 600851475143)))

(it "tests number for prime-ness"
	(should= true (is-prime? 3))
	(should= true (is-prime? 5))
	(should= true (is-prime? 7))
	(should= true (is-prime? 11))
	(should= true (is-prime? 17))
	(should= true (is-prime? 181))
	
	(should= false (is-prime? 4))
	(should= false (is-prime? 6))
	(should= false (is-prime? 9))
	(should= false (is-prime? 49))
	(should= false (is-prime? 100)))

(it "Solves #3"
	(should= 3 (euler-3 3))
	(should= 5 (euler-3 5))
	(should= 7 (euler-3 7))
	(should= 11 (euler-3 11))
	(should= 17 (euler-3 17))
	(should= 181 (euler-3 181))
	
	(should= 2 (euler-3 4))
	(should= 3 (euler-3 6))
	(should= 3 (euler-3 9))
	(should= 5 (euler-3 20))
	(should= 7 (euler-3 49))
	(should= 5 (euler-3 100))
	(should= 5 (euler-3 1000))
	(should= 29 (euler-3 13195))
	(should= 6857 (euler-3 600851475143))))

(run-specs)
