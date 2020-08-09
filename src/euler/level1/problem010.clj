(ns euler.level1.problem010)

(defn test-candidate [candidate primes]
  (loop [primes-to-test primes
         test-prime (first primes)
         prime 0]
    (if (empty? primes-to-test)
      (if (not (zero? prime))
        candidate
        prime)
      (if (zero? (rem candidate test-prime))
        (recur [] test-prime 0)
        (recur (rest primes-to-test) (first (rest primes-to-test)) test-prime)))))

(defn primes-less-than-n [n]
  (cond (<= n 2) []
        (= n 3) [2]
        :else
        (let [nums (range 3 n)]
          (loop [primes [2 3]
                 candidates (filter odd? nums)]
            (if (empty? candidates)
              primes
              (let [candidate (first candidates)]
                (if (zero? (test-candidate candidate primes))
                  (recur primes (rest candidates))
                  (recur (conj primes candidate) (rest candidates)))))))))

(defn sum-of-primes [n]
  (cond (<= n 2) 0
        (= n 3) 2
        :else (apply + (primes-less-than-n n))))




;Old Code from first attempt
;(defn prime-factors [n]
;  (loop [n n
;         divisor 2
;         primes []]
;    (cond (<= n 1) primes
;          (zero? (rem n divisor)) (recur (/ n divisor) divisor (conj primes divisor))
;          :else (recur n (inc divisor) primes))))
;
;(defn is-prime? [num]
;  (>= 1 (count (prime-factors num))))
;
;;(defn get-primes [n]
;;  (if (< n 10001)
;;    (let [nums (range 2 n)
;;          odds-and-2 (filter #(or (= 2 %) (odd? %)) nums)]
;;      (filter #(is-prime? %) odds-and-2))
;;    (let [primes-under-10k1 (get-primes 10000)
;;          nums (filter odd? (range 10001 n))
;;          primes-tested-with-first-10k-primes
;;          (remove nil? (for [num nums
;;                             prime primes-under-10k1
;;                             :while (not (zero? (rem num prime)))]
;;                         (if (= prime (last primes-under-10k1))
;;                           num)))]
;;      primes-tested-with-first-10k-primes)))
;
;(defn divisible? [n divisors]
;  (if (<= n 3) false
;               (or (even? n)
;                   (>= 1 (count (for [divisor divisors
;                                      :while (not (zero? (rem n divisor)))] divisor))))))
;
;(defn euler-10 [n]
;  (let [nums (range 2 n)
;        odds-and-2 (filter #(or (= 2 %) (odd? %)) nums)
;        primes (remove #(divisible? % odds-and-2) odds-and-2)]
;    (apply + primes)))

;(cond (<= n 2) []
;      (= n 3) [2]
;      :else
;      (let [nums (range 3 n)]
;        (loop [primes [2 3]
;               candidates (filter odd? nums)]
;          (if (empty? candidates)
;            primes
;            (let [candidate (first candidates)
;                  remainders (filter #(zero? (rem candidate %)) primes)]
;              (if (empty? remainders)
;                (recur (conj primes candidate) (rest candidates))
;                (recur primes (rest candidates)))))))))