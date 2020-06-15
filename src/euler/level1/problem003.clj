(ns euler.level1.problem003)

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
