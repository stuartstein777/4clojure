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
