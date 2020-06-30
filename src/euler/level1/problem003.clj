(ns euler.level1.problem003)

;first function [prime-factors] is my take on the prime factor kata; probably can still be improved some, but it's a start
(defn prime-factors [n]
			(loop [factors []
						 factor 2
						 n n]
						(if (> n 1)
							(if (= 0 (rem n factor))
								(recur (conj factors factor) factor (/ n factor))
								(recur factors (inc factor) n))
							factors)))

(defn next-factor [n]
	(loop [factor 2]
		(cond (= n factor) n
			(integer? (/ n factor)) (/ n factor)
			:else (recur (inc factor)))))

(defn is-prime? [n]
	(or (<= n 3) (= n (next-factor n))))

(defn euler-3 [n]
	(loop [n n]
		(if (is-prime? n)
			n
			(recur (next-factor n)))))
