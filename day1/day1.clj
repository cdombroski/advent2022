(ns day1
  (:require [clojure.java.io :as io]))

(defn problem1 []
  (with-open [input (io/reader "./day1/input.txt")]
    (loop [max 0
           lst (line-seq input)
           acc 0]
      (if (seq lst)
        (if (= (first lst) "")
          (if (> acc max)
            (recur acc (next lst) 0)
            (recur max (next lst) 0))
          (recur max (next lst) (+ acc (Integer/parseInt (first lst)))))
        max))))

(problem1)