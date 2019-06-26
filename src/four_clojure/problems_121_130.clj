(ns four-clojure.problems-121-130)

;; Problem 122: Read a binary number
;; Difficulty: Easy
;; Topics
;; Convert a binary number, provided in the form of a string, to its numerical value
; (= 0     (__ "0"))
; (= 7     (__ "111"))
; (= 8     (__ "1000"))
; (= 9     (__ "1001"))
; (= 255   (__ "11111111"))
; (= 1365  (__ "10101010101"))
; (= 65535 (__ "1111111111111111"))
#(loop [bin (reverse (vec %))
        total 0
        digit-value 1]
   (if (empty? bin)
     total
     (recur (rest bin)
            (if (= (first bin) \1)
              (+ total digit-value)
              total)
            (* 2 digit-value))))

;; or using core parse functionality.
#(Integer/parseInt % 2)