(ns four-clojure.problems-161-to-170)

;; Problem 161: Subset and Superset
;; Difficulty: Elementary
;; Topics: set theory
;; Set A is a subset of set B, or equivalently B is a superset of A, if A is "contained" inside B. A and B may coincide.
; (clojure.set/superset? __ #{2})
; (clojure.set/subset? #{1} __)
; (clojure.set/superset? __ #{1 2})
; (clojure.set/subset? #{1 2} __)
(clojure.set/superset? #{1 2} #{2})
(clojure.set/subset? #{1} #{1 2})
(clojure.set/superset? #{1 2} #{1 2})
(clojure.set/subset? #{1 2} #{1 2})

;; Problem 162: Logical falsity and truth
;; Difficulty: Elementary
;; Topics: logic
;; In Clojure, only nil and false represent the values of logical falsity in conditional tests - anything else is logical truth.
; (= __ (if-not false 1 0))
; (= __ (if-not nil 1 0))
; (= __ (if true 1 0))
; (= __ (if [] 1 0))
; (= __ (if [0] 1 0))
; (= __ (if 0 1 0))
; (= __ (if 1 1 0))
(= 1 (if-not false 1 0))
(= 1 (if-not nil 1 0))
(= 1 (if true 1 0))
(= 1 (if [] 1 0))
(= 1 (if [0] 1 0))
(= 1 (if 0 1 0))
(= 1 (if 1 1 0))

;; Problem 166
;; Difficulty: Easy
;; Topics
;; For any orderable data type it's possible to derive all of the basic comparison operations
;; (<, ≤, =, ≠, ≥, and >) from a single operation (any operator but = or ≠ will work).
;; Write a function that takes three arguments, a less than operator for the data and two items
;; to compare.
;; The function should return a keyword describing the relationship between the two items.
;; The keywords for the relationship between x and y are as follows:
;; x = y -> :eq
;; x > y -> :gt
;; x < y -> :lt
; (= :gt (__ < 5 1))
; (= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum"))
; (= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))
; (= :gt (__ > 0 2))
#(cond (% %2 %3) :lt (% %3 %2) :gt :else :eq)