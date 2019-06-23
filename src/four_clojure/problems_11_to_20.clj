(ns four-clojure.problems-11-to-20)

;; Problem 11: Maps: conj
;; Difficulty: Elementary
;; Topics: Maps
;; When operating on a map, the conj function returns a new map with one or more key-value pairs "added".
; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))

;; Problem 12: Intro to Sequences
;; Difficulty: Elementary
;; Topics: Sequences
;; All Clojure collections support sequencing. You can operate on sequences with functions like first, second, and last.
; (= __ (first '(3 2 1)))
; (= __ (second [2 3 4]))
; (= __ (last (list 1 2 3)))
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

;; Problem 12: Sequences: rest
;; Difficulty: Elementary
;; Topics: Sequences, Rest
;; The rest function will return all the items of a sequence except the first.
; (= __ (rest [10 20 30 40]))
(= 20 (rest [10 20 30 40]))

;; Problem 14: Into to Functions
;; Difficulty: Elementary
;; Topics: Functions
;; Clojure has many different ways to create functions.
; (= __ ((fn add-five [x] (+ x 5)) 3))
; (= __ ((fn [x] (+ x 5)) 3))
; (= __ (#(+ % 5) 3))
; (= __ ((partial + 5) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

;; Problem 15: Double Down
;; Difficulty: Elementary
;; Topics: Functions
;; Write a function that doubles a number.
; (= (__ 2) 4)
; (= (__ 3) 6)
; (= (__ 11) 22)
; (= (__ 7) 14)
(= (* 2 2) 4)
(= (* 2 3) 6)
(= (* 2 11) 22)
(= (* 2 7) 14)

;; Problem 16: Hello World
;; Difficulty:	Elementary
;; Topics:
;; Write a function which returns a personalized greeting.
; (= (__ "Dave") "Hello, Dave!")
; (= (__ "Jenn") "Hello, Jenn!")
; = (__ "Rhea") "Hello, Rhea!")
#(str "Hello, " % "!")

;; Problem 17: Sequences: map
;; Difficulty: Elementary
;; Topics: map
;; The map function takes two arguments: a function (f) and a sequence (s).
;; Map returns a new sequence consisting of the result of applying f to each item of s.
;; Do not confuse the map function with the map data structure.
; (= __ (map #(+ % 5) '(1 2 3)))
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;; Problem 18: Sequences: filter
;; Difficulty: Elementary
;; Topics: filter, sequences
;; The filter function takes two arguments: a predicate function (f) and a sequence (s).
;; Filter returns a new sequence consisting of all the items of s for which (f item) return
; (= __ (filter #(> % 5) '(3 4 5 6 7)))
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

;; Problem 19: Last Element
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns the last element in a sequence. DO NOT USE (last)
; (= (__ [1 2 3 4 5]) 5)
; (= (__ '(5 4 3)) 3)
; (= (__ ["b" "c" "d"]) "d")
#(first (reverse %))

;; Problem 20: Penultimate Element
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns the second to last element from a sequence.
; (= (__ (list 1 2 3 4 5)) 4)
; (= (__ ["a" "b" "c"]) "b")
; (= (__ [[1 2] [3 4]]) [1 2])
#(nth (reverse %) 1)
