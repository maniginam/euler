(ns euler.level1.problem013
  (:require [euler.level1.problem004 :refer :all]))

(defn euler-13 [n]
  (take 10 (int-to-seq (apply + n))))




; To get to int form instead of leaving in seq swap out one-liner with this:
;  (let [seq-of-sum (reverse (take 10 (int-to-seq (apply + n))))]
;    (loop [sum (first seq-of-sum)
;           seq-of-sum (rest seq-of-sum)
;           power 10]
;      (if (empty? seq-of-sum)
;        sum
;        (recur (+ sum (* (first seq-of-sum) power)) (rest seq-of-sum) (* 10 power))))))
