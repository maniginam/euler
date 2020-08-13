(ns euler.level1.problem011)

(defn find-columns [grid col]
  (for [row (range (count grid))]
    (nth (nth grid row) col)))

(defn find-diagonals [grid]
  (let [grid-size (count grid)]
    (loop [x 1
         y 0
         diagonal []
         diagonals []
         count 0]
    (if (and (= x grid-size) (= y grid-size))
      diagonals)

(defn multiply [vector]
  (apply max
         (for [i (range (- (count vector) 3))]
           (apply * (take 4 (drop i vector))))))

(defn euler-11 [grid]
  (let [cols (for [col (range (count grid))] (find-columns grid col))
        ;diagonals (find-diagonals grid)
        max-row-product (apply max (for [row grid] (multiply row)))
        max-col-product (apply max (for [col cols] (multiply col)))]
    diagonals))
;(max max-row-product max-col-product)))

