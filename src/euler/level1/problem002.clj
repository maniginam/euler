(ns euler.level1.problem002)

;first solved: 6/10/20


(defn another-element? [n element]
	(or (= n 2) (> element 4000000)))

(defn get-next-element [fib]
	(let [last-element (last fib)
		second-to-last (last (butlast fib))
		next-element (+ last-element second-to-last)]
		next-element))
		

(defn fib [n]
	(loop [n n
		fib [1 2]]
			(if (another-element? n (get-next-element fib))
				fib
				(recur (dec n) (conj fib (get-next-element fib))))))


(defn euler-2 [n]
	(cond (= n 0) 0
		(= n 1) 0
		:else
			(let [evens (filter even? (fib n))]
			(apply + evens))))
