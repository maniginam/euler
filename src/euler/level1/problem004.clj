(ns euler.level1.problem004)
(require '[clojure.string :as string])

;palindrome
(defn finds-nums-w-n-digits [digits]
      (let [start (int (Math/pow 10 (dec digits)))
            stop (int (Math/pow 10 digits))]
           (range start stop)))

(defn calc-products [nums]
      (let [products (map #(map (partial * %) nums) nums)]
           (sequence cat products)))


(defn palindrome? [num]
      (let [num-reversed (reverse num)]
           (= num-reversed num)))

(defn int-to-seq [n]
      (loop [n n
             int-elements []]
            (if (> 10 n)
              (reverse (conj int-elements (mod n 10)))
              (recur (/ (- n (mod n 10)) 10) (conj int-elements (mod n 10))))))

(defn seq-to-int [seq]
      (if (empty? seq)
        nil
        (Integer/parseInt (string/join seq))))

(defn euler-4 [n]
      (let [n-digit-nums (finds-nums-w-n-digits n)
            products (calc-products n-digit-nums)
            products-as-seqs (map int-to-seq products)
            palindromes-as-seqs (filter palindrome? products-as-seqs)
            palindromes (map seq-to-int palindromes-as-seqs)]
           (apply max palindromes)))







;********************************END****************************************
;(defn find-palindrome [n]
;      (let [n-digit-nums (finds-nums-w-n-digits n)
;            products (calc-products n-digit-nums)
;            products-as-seqs (map int-to-seq products)
;            palindromes-as-seqs (filter palindrome? products-as-seqs)
;            palindromes (map seq-to-int palindromes-as-seqs)]
;           (apply max palindromes)))

;Micah
;(let [3-digit-nums (find-3-digit-nums)
;      products (calc-products 3-digit-nums)
;      palindromes (filter palindrome? products)]
;     (max palindromes))


;(defn get-test-values [multiple multiples]
;      (map #(* % multiple) multiples))
;
;(defn find-palindromes [start stop multiples]
;      (loop [multiple (dec stop)
;             test-values (get-test-values multiple multiples)
;             palindromes []]
;            (if (<= start multiple)
;              (let [next-multiple (dec multiple)
;                    test-values-seqs (map int-to-seq test-values)
;                    current-palindrome-seqs (filter palindrome? test-values-seqs)
;                    current-palindromes (map seq-to-int current-palindrome-seqs)]
;                   (recur next-multiple
;                          (get-test-values next-multiple multiples)
;                          (apply (partial conj palindromes) current-palindromes)))
;              palindromes)))
;
;(defn find-max-palindrome [palindromes]
;      (apply max palindromes))

;(defn euler-4 [digits]
;  (let [start (int (Math/pow 10 (dec digits)))
;        stop (int (Math/pow 10 digits))
;        multiples (reverse (range start stop))]
;       (find-max-palindrome (find-palindromes start stop multiples))))

;(defn reverse-num [n]
;      (let [ones (rem n 10)
;            tens (/ (rem (- n ones) 100) 10)
;            hundreds (/ (rem (- n tens ones) 1000) 100)]
;           hundreds))
;(+ (* ones 10) tens)))
