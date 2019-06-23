(ns four-clojure.problems-1-to-10)

;; Problem 1: Nothing but the truth
;; Difficulty: Elementary
;; Topics: -
; This is a clojure form. Enter a value which will make the form evaluate to true.
; Don't over think it! If you are confused, see the getting started page. Hint: true is equal to true.
;(= __ true)
(= true true)

;; Problem 2: Simple Math
;; Difficulty: Elementary
;; Topics: PN
;; Note: Enter only enough to fill in the blank (in this case, a single number) - do not retype the whole problem.
; (= (- 10 (* 2 3)) __)
(= (- 10 (* 2 3)) 4)

;; Problem 3: Intro to Strings
;; Difficulty: Elementary
;; Topics: Strings
;; Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))

;; Problem 4: Intro to Lists
;; Difficulty: Elementary
;; Topics: Lists
;; Lists can be constructed with either a function or a quoted form.
; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))

;; Problem 5: Lists: conj
;; Difficulty: Elementary
;; Topics: Lists
;; When operating on a list, the conj function will return a new list with one or more items
;; "added" to the front.
; (= __ (conj '(2 3 4) 1))
; (= __ (conj '(3 4) 2 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))
(= '(1 2 3 4) (conj '(2 3 4) 1))

;; Problem 6: Into to Vectors
;; Difficulty: Elementary
;; Topics: Vectors
;; Vectors can be constructed several ways. You can compare them with lists.
; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

;; Problem 7: Vectors: conj
;; Difficulty: Elementary
;; Topics: Vectors, conj
;; When operating on a Vector, the conj function will return a new vector with one or more items
;; "added" to the end.
; (= __ (conj [1 2 3] 4))
; (= __ (conj [1 2] 3 4))
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

;; Problem 8: Into to Sets
;; Difficulty: Elementary
;; Topics: Sets
;; Sets are collections of unique values.
; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

;; Problem 9: Sets: conj
;; Difficulty: Elementary
;; Topics: Sets
;; When operating on a set, the conj function returns a new set with one or more keys "added".
; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))

;; Problem 10: Intro to Maps
;; Difficulty: Elementary
;; Topics: Maps
;; Maps store key-value pairs. Both maps and keywords can be used as lookup functions.
;; Commas can be used to make maps more readable, but they are not required.
; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
; (= __ (:b {:a 10, :b 20, :c 30}))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))