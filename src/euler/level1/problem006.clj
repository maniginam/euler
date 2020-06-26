(ns euler.level1.problem006)

(defn sum-of-squares [n]
      (let [range (range 1 (inc n))]
           (long (apply + (map #(Math/pow % 2) range)))))

(defn square-of-sum [n]
      (let [range (range 1 (inc n))
            sum (apply + range)]
           (long (Math/pow sum 2))))

(defn euler-6 [n]
      (- (square-of-sum n) (sum-of-squares n)))
