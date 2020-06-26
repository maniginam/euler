(ns euler.level1.problem005
    (:require
      [euler.level1.problem003 :refer :all]))

(defn get-smallest-root [multiplier]
    (loop [root 2
           exp 2]
          (let [test-value (Math/pow root exp)]
               (cond (= test-value (double multiplier)) root
                     (< test-value multiplier) (recur root (inc exp))
                     (> test-value multiplier) (if (= exp 2) nil (recur (inc root) 2))))))

(defn is-perfect-root? [multiplier]
      (not (nil? (get-smallest-root multiplier))))

(defn euler-5 [n]
      (if (= n 1)
        n
        (loop [multiple 1
               multiplier 2]
              (if (> multiplier n)
                multiple
                (cond (is-prime? multiplier) (recur (* multiple multiplier) (inc multiplier))
                      (is-perfect-root? multiplier) (recur (* multiple (get-smallest-root multiplier)) (inc multiplier))
                      :else (recur multiple (inc multiplier)))))))



;(defn get-lowest-prime-root [root root-type]
;  (loop [root root]
;    (if (is-prime? root)
;      root
;      (if (< root 2)
;        nil
;        (recur (/ root root-type))))))

;(defn get-smallest-root [n]
; (loop [root-type 2
;       root (Math/pow multiplier (/ 1 root-type))]
;      (if (> (* root-type root-type) multiplier)
;        nil
;        (if (= (Math/ceil root) (Math/floor root))
;          (if (is-prime? root)
;            root
;            (recur root-type))
;          (recur (inc root-type)))))) )

;(defn find-multiples [n]
;      (if (= n 1)
;        n
;        (loop [multiple 1
;               next-multiple 2]
;              (cond (> next-multiple n) multiple
;                    (is-prime? next-multiple) (recur (* multiple next-multiple) (inc next-multiple))
;                    (is-perfect-root? next-multiple) (recur (* multiple next-multiple) (inc next-multiple))))))

;(defn is-perfect-root? [multiplier]
;   (loop [root-type 2]
;      (let [root (Math/pow n (/ 1 root-type))]
;           (cond (< root 2) false
;                 (= (Math/ceil root) (Math/floor root)) true
;                 :else (recur (inc root-type))))))