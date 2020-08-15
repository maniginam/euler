(ns euler.level1.problem011)

(defn get-values [grid row col]
  (nth (nth grid row) col))

(defn find-columns [grid col]
  (for [row (range (count grid))]
    (get-values grid row col)))

(defn lt-diag [grid column]
    (loop [row 0
         col column
         diagonal []]
    (if (>= col 0)
      (recur (inc row) (dec col) (conj diagonal (get-values grid row col)))
      diagonal)))

(defn rt-diag [grid column]
  (let [grid-size (count grid)]
    (loop [row 0
           col column
           diagonal []]
      (if (< col grid-size)
        (recur (inc row) (inc col) (conj diagonal (get-values grid row col)))
        diagonal))))

(defn find-diagonals [grid]
  (let [grid-size (count grid)
        columns (range grid-size)
        first-row-rt-diags (map #(rt-diag grid %) columns)
        first-row-lt-diags (map #(lt-diag grid %) columns)
        last-row-rt-diags (map #(rt-diag (reverse grid) %) columns)
        last-row-lt-diags (map #(lt-diag (reverse grid) %) columns)
        diagonals (mapcat #(conj [] %1 %2 %3 %4)
                          first-row-lt-diags first-row-rt-diags
                          last-row-lt-diags last-row-rt-diags)]
    (remove #(< (count %) 4) diagonals)))

(defn multiply [vector]
  (apply max
         (for [i (range (- (count vector) 3))]
           (apply * (take 4 (drop i vector))))))

(defn euler-11 [grid]
  (let [cols (for [col (range (count grid))] (find-columns grid col))
        diagonals (find-diagonals grid)
        max-row-product (apply max (for [row grid] (multiply row)))
        max-col-product (apply max (for [col cols] (multiply col)))
        max-diag-product (apply max (for [diag diagonals] (multiply diag)))]
(max max-row-product max-col-product max-diag-product)))

