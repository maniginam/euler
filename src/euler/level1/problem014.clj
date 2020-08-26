(ns euler.level1.problem014)

(defn count-collatz [n]
  (loop [collatz-count 1 n n]
    (cond (= n 1) collatz-count
          (even? n) (recur (inc collatz-count) (/ n 2))
          :else (recur (inc collatz-count) (+ (* n 3) 1)))))

(defn euler-14 [n]
  (if (<= n 4)
    (dec n)
    (loop [num 4 longest 3 longest-count 8]
      (cond (= num n) longest
            (and (even? num) (not (= num 6))) (recur (inc num) longest longest-count)
            :else (let [collatz-count (count-collatz num)]
                    (if (>= collatz-count longest-count)
                      (recur (inc num) num collatz-count)
                      (recur (inc num) longest longest-count)))))))
