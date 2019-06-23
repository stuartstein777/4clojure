(ns four-clojure.problems-31-to-40)

;; Problem 31: Pack a sequence
;; Topics: seqs
;; Write a function which packs consecutive duplicates into sub-lists.
; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
#(partition-by identity %)

;; Problem 32: Duplicate a sequence
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which duplicates each element of a sequence.
; (= (__ [1 2 3]) '(1 1 2 2 3 3))
; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
(fn duplicate
  ([col] (duplicate col []))
  ([col dup]
   (if (empty? col)
     dup
     (duplicate (rest col) (conj dup (first col) (first col))))))

;; Problem 33: Replicate a Sequence
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which replicates each element of a sequence a variable number of times.
; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
; (= (__ [4 5 6] 1) '(4 5 6))
; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
; (= (__ [44 33] 2) [44 44 33 33])
(fn [col n]
  (reduce into [] (map #(take n (repeat %)) col)))

;; Problem 34: Implement range
;; Difficulty: Easy
;; Topics: seqs core-functions
; (= (__ 1 4) '(1 2 3))
; (= (__ -2 2) '(-2 -1 0 1))    FALSE
; (= (__ 5 8) '(5 6 7))
(fn [start end]
  (take-while
    (fn [n]
      (not= 0 (- end n)))
    (iterate inc start)))

;; Problem 35: Sequences: filter
;; Difficulty: Elementary
;; Topics: syntax, let
;; Clojure lets you give local names to values using the special let-form.
; (= __ (let [x 5] (+ 2 x)))
; (= __ (let [x 3, y 10] (- y x)))
; (= __ (let [x 21] (let [y 3] (/ x y))))
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

;; Problem 36: Let it Be
;; Difficulty: Elementary
;; Topics: math, syntax, let
;; Can you bind x, y, and z so that these are all true?
; (= 10 (let __ (+ x y)))
; (= 4 (let __ (+ y z)))
; (= 1 (let __ z))
(= 10 (let [x 7 y 3 z 1] (+ x y)))
(= 4 (let [x 7 y 3 z 1] (+ y z)))
(= 1 (let [x 7 y 3 z 1] z))

;; Problem 37: Regular Expressions
;; Difficulty: Elementary
;; Topics: regex, syntax
;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; Problem 38: Maximum Value
;; Difficulty: Easy
;; Topics: core-functions
;; Write a function which takes a variable number of parameters and returns the maximum value.
; (= (__ 1 8 3 4) 8)
; (= (__ 30 20) 30)
; (= (__ 45 67 11) 67)
(fn [a & r] (last (sort (conj r a))))

;; Problem 39: Interleave Two Seqs
;; Difficulty: Easy
;; Topics: seqs, core-functions
;; Write a function which takes two sequences and returns the first item from each,
;; then the second item from each, then the third, etc.
; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
; (= (__ [1 2 3 4] [5]) [1 5])
; (= (__ [30 20] [25 15]) [30 25 20 15])
#(flatten (map vector %1 %2))

;; Problem 40: Interpose a seq
;; Difficulty: Easy
;; Topics: seq, core-functions
;; Write a function which separates the items of a sequence by an arbitrary value.
; (= (__ 0 [1 2 3]) [1 0 2 0 3])
; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
(fn interpose' ([v col] (interpose' v col []))
  ([v col itp]
   (if (= 1 (count col))
     (conj itp (first col))
     (interpose' v (rest col) (conj itp (first col) v)))))