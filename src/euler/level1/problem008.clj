(ns euler.level1.problem008
    (:require [euler.level1.problem004 :refer :all]))

(defn get-seq [coll]
      (let [num (map int-to-seq coll)]
           (sequence cat num)))

(defn euler-8 [n digits]
      (let [seq (get-seq n)]
           (loop [drops 1
                 greatest-product (first seq)
                 multipliers (take digits seq)]
                (if (< (count multipliers) digits)
                  greatest-product
                  (cond (> (apply * multipliers) greatest-product) (recur (inc drops) (apply * multipliers) (take digits (drop drops seq)))
                        :else (recur (inc drops) greatest-product (take digits (drop drops seq))))))))