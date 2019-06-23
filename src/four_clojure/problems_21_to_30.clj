(ns four-clojure.problems-21-to-30)

;; Problem 21: Nth Element
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Write a function which returns the Nth element from a sequence.
;; Restriction: Do NOT use nth
; (= (__ '(4 5 6 7) 2) 6)
; (= (__ [:a :b :c] 0) :a)
; (= (__ [1 2 3 4] 1) 2)
; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])
#(first (drop %2 %1))

;; Problem 22: Count a Sequence
;; Difficulty: Easy
;; Topics: seq
;; Write a function which returns the total number of elements in a sequence.
;; Restriction: Do NOT use count
; (= (__ '(1 2 3 3 1)) 5)
; (= (__ "Hello World") 11)
; (= (__ [[1 2] [3 4] [5 6]]) 3)
; (= (__ '(13)) 1)
; (= (__ '(:a :b :c))
(fn count'
  ([x cnt]
   (if (empty? x)
     cnt
     (count' (rest x) (inc cnt))))
  ([x]
   (count' (vec x) 0)))

;; Problem 23: Reverse a sequence
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which reverses a sequence.
;; Restrictions: Do NOT use reverse or rseq
; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
; (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
(fn reverse'
  ([col]
   (reverse' (rest col) (cons (first col) [])))
  ([col rev-col]
   (if (empty? col)
     rev-col
     (reverse' (rest col) (cons (first col) rev-col)))))

;; Problem 24: Sum It All Up
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns the sum of a sequence of numbers.
; (= (__ [1 2 3]) 6)
; (= (__ (list 0 -2 5 5)) 8)
; (= (__ #{4 2 1}) 7)
; (= (__ '(0 0 -1)) -1)
; (= (__ '(1 10 3)) 14)
(= (reduce + [1 2 3]) 6)
(= (reduce + (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)
(= (reduce + '(0 0 -1)) -1)
(= (reduce + '(1 10 3)) 14)

;; Problem 25: Find the odd numbers
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns only the odd numbers from a sequence.
; (= (__ #{1 2 3 4 5}) '(1 3 5))
; (= (__ [4 2 1 6]) '(1))
; (= (__ [2 2 4 6]) '())
; (= (__ [1 1 1 3]) '(1 1 1 3))
(= (filter odd? #{1 2 3 4 5}) '(1 3 5))
(= (filter odd? [4 2 1 6]) '(1))
(= (filter odd? [2 2 4 6]) '())
(= (filter odd? [1 1 1 3]) '(1 1 1 3))

;; Problem 26: Fibonnaci Sequence
;; Difficulty: Easy
;; Topics: seqs, fibonacci
;; Write a function which returns the first X fibonacci numbers.
; (= (__ 3) '(1 1 2))
; (= (__ 6) '(1 1 2 3 5 8))
; (= (__ 8) '(1 1 2 3 5 8 13 21))
(fn [n]
  (take n ((fn fib []
             ((fn fib-rec [a b]
                (cons a (lazy-seq (fib-rec b (+ a b)))))
               1 1)))))

;; Problem 27: Palindrome Detector
;; Difficulty: Easy
;; Topics: seq
;; Write a function which returns true if the given sequence is a palindrome.
; (false? (__ '(1 2 3 4 5)))
; (true? (__ "racecar"))
; (true? (__ [:foo :bar :foo]))
; (true? (__ '(1 1 3 3 1 1)))
; (false? (__ '(:a :b :c)))
#(= (reverse %) (vec %))

;; Problem 28: Flatten a sequence
;; Difficulty: Easy
;; Write a function which flattens a sequence
; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
; (= (__ '((((:a))))) '(:a))
#(filter (complement sequential?) (rest (tree-seq sequential? seq %)))

;; Problem 29: Get the Caps
;; Difficulty: Easy
;; Topics: strings
;; Write a function which takes a string and returns a new string containing only
;; the capital letters.
; (= (__ "HeLlO, WoRlD!") "HLOWRD")
; (empty? (__ "nothing"))
; (= (__ "$#A(*&987Zf") "AZ")
(fn [s] (apply str (re-seq #"[A-Z]" s)))
; Code Golf:
#(apply str (re-seq #"[A-Z]" %))

;; Problem 30: Compress a sequence
;; Write a function which removes consecutive duplicates from a sequence.
; (= (apply str ((fn [x] (map first (partition-by identity x))) "Leeeeeerrroyyy")) "Leroy")
; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
#(map first (partition-by identity %))