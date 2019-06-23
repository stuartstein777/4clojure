(ns four-clojure.problems-131-to-140)

;; Problem 134: A nil key
;; Difficulty: Elementary
;; Topics: maps
;; Write a function which, given a key and map, returns true iff the map contains an entry with that key and its value is nil.
; (true?  (__ :a {:a nil :b 2}))
; (false? (__ :b {:a nil :b 2}))
; (false? (__ :c {:a nil :b 2}))
(fn [key map]
  (if (contains? map key)
    (nil? (get map key))
    false))