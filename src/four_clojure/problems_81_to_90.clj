(ns four-clojure.problems-81-to-90)

;; Problem 81: Set Intersection
;; Difficulty: Easy
;; Topics: Set Theory
;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
; (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
; (= (__ #{0 1 2} #{3 4 5}) #{})
; (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
(fn [set1 set2]
  (let [s (if (> (count set1) (count set2))
            set1
            set2)]
    (loop [biggest-set s
           result #{}]
      (if (empty? biggest-set)
        result
        (if (contains? set1 (first biggest-set))
          (recur (rest biggest-set) (conj result (first biggest-set)))
          (recur (rest biggest-set) result))))))

;; Problem 83: A Half-Truth
;; Difficulty: Easy
;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true,
;; but not all of the parameters are true. Otherwise your function should return false.
; (= false (__ false false))
; (= true (__ true false))
; (= false (__ true))
; (= true (__ false true false))
; (= false (__ true true true))
; (= true (__ true true true false))
(fn [a & r]
  (let [all (conj r a)]
    (true? (and (some true? all) (some false? all)))))