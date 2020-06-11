(ns euler.level1.problem001
	(:require [clojure.set]))



(defn multiple-of-3-or-5? [n]
	(or (integer? (/ n 3)) (integer? (/ n 5))))
	
	

(defn euler-1 [n]
	(let [multiples-of-3-or-5 (filter multiple-of-3-or-5? (range n))]
		(apply + multiples-of-3-or-5)))
