(ns euler.level1.problem004)
(require '[clojure.string :as string])

(defn int-to-seq [n]
  (loop [n n
         int-elements []]
    (if (> 10 n)
      (conj int-elements (mod n 10))
      (recur (/ (- n (mod n 10)) 10) (conj int-elements (mod n 10))))))

(defn palindrome? [num]
  (let [num-reversed (reverse num)]
    (= num-reversed num)))

(defn seq-to-int [seq]
  (if (empty? seq)
    nil
    (Integer/parseInt (string/join seq))))

(defn get-test-values [multiple multiples]
  (map #(* % multiple) multiples))

(defn find-palindromes [start stop multiples]
  (loop [multiple (dec stop)
         test-values (get-test-values multiple multiples)
         palindromes []]
    (if (<= start multiple)
      (let [next-multiple (dec multiple)
            test-values-seqs (map int-to-seq test-values)
            current-palindrome-seqs (filter palindrome? test-values-seqs)
            current-palindromes (map seq-to-int current-palindrome-seqs)]
        (recur next-multiple
               (get-test-values next-multiple multiples)
               (apply (partial conj palindromes) current-palindromes)))
        palindromes)))

(defn find-max-palindrome [palindromes]
  (apply max palindromes)
  )

(defn euler-4 [digits]
  (let [start (int (Math/pow 10 (dec digits)))
        stop (int (Math/pow 10 digits))
        multiples (reverse (range start stop))]
    (find-max-palindrome (find-palindromes start stop multiples))))



;(let [multiples (reverse (range 1 (Math/pow 10 digits)))
;      test-values (map #(* % multiples) multiples)]
;  (first (filter palindrome? (map #(int-to-seq %) test-values)))
;  )

;(defn find-first-palindrome [seq]
;  (let [palindromes (filter palindrome? (map #(int-to-seq %) seq))
;        palindrome-string (string/join (first palindromes))]
;    (if (string/blank? palindrome-string)
;      nil
;      (Integer/parseInt palindrome-string))))


;(loop [max-multiple (- (Math/pow 10 digits) 1)
;       mult-1 max-multiple
;       mult-2 max-multiple
;       test-value (* mult-1 mult-2)]
;  (if (palindrome? test-value)
;    test-value
;    (cond (= test-value (* (Math/pow 10 (- digits 1)) 2)) max-multiple
;          (> (- mult-1 mult-2) 10) (do (- mult-1 1) (+ mult-2 10))
;          ))
;  )