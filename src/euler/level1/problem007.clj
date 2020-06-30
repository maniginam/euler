(ns euler.level1.problem007)

(defn next-prime [primes]
      (loop [next-prime (+ (last primes) 2)]
            (let [factors (filter int? (map #(/ next-prime %) primes))]
                 (if (= () factors)
                   next-prime
                   (recur (+ 2 next-prime))))))

(defn euler-7 [n]
      (if (< n 3)
        (inc n)
        (loop [primes [2 3]]
              (if (= (count primes) n)
                (last primes)
                (recur (conj primes (next-prime primes)))))))

