(ns euler.level1.problem009)

(defn sqrt [n]
  (if (< n 4) nil (int (Math/pow n (/ 1 2)))))

(defn is-perfect-square? [num]
  (zero? (- (Math/pow num (/ 1 2)) (int (Math/pow num (/ 1 2))))))

(defn get-squares [n]
  (map #(* % %) (range 2 (inc n))))

(defn get-triples [n]
  (let [squares (get-squares n)]
    (for [a2 squares b2 squares
          :when (and (is-perfect-square? (+ a2 b2)) (< a2 b2))]
      [(sqrt a2) (sqrt b2) (sqrt (+ a2 b2))])))

(defn euler-9 [n]
  (let [triples (get-triples n)]
    (for [triple triples
          :when (= n (apply + triple))]
      (apply * triple))))



; old bad code
;(defn flatten-adder-sets [adder-sets]
;  (for [adder-set adder-sets adder adder-set] adder))
;
;(defn get-adders [square n]
;  (let [squares (get-squares n)
;        square-minus-squares (map #(- square %) squares)
;        perfect-square-adders (filter #(is-perfect-square? % squares) square-minus-squares)]
;    (loop [adder-sets []
;           perfect-square-adders perfect-square-adders]
;      (if (empty? perfect-square-adders)
;        adder-sets
;        (let [current-adders [(first perfect-square-adders) (last perfect-square-adders)]]
;          (recur
;            (conj adder-sets current-adders)
;            (drop 1 (drop-last perfect-square-adders))))))))
;
;(defn get-squared-triples [n]
;  (let [squares (get-squares n)
;        adder-sets (flatten-adder-sets (remove empty? (map #(get-adders % n) squares)))]
;    (for [adder-set adder-sets
;          :let [a2 (second adder-set)
;                b2 (first adder-set)
;                c2 (+ a2 b2)]]
;      [a2 b2 c2])))
;
;(defn get-triples-old [n]
;  (for [squared-triple (get-squared-triples n)
;        :let [a (Math/pow (first squared-triple) (/ 1 2))
;              b (Math/pow (second squared-triple) (/ 1 2))
;              c (Math/pow (last squared-triple) (/ 1 2))]]
;    [a b c]))
;
;(defn set-n [n]
;  (if (< n 25)
;    n
;    (/ n 2)))

