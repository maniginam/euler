(ns euler.level1.problem012)

(defn factor-count [n]
  (loop [divisor 2.0 factor-count 2]
    (cond (= divisor (Math/sqrt n)) (inc factor-count)
          (> divisor (Math/sqrt n)) factor-count
          :else (recur (inc divisor) (if (zero? (rem n divisor)) (+ 2 factor-count) factor-count)))))

(defn euler-12 [desired-factors]
  (loop [tri-num 6 next-adder 4]
    (if (>= (factor-count tri-num) desired-factors)
      [(dec next-adder) tri-num (factor-count tri-num)]
      (recur (+ tri-num next-adder) (inc next-adder)))))
