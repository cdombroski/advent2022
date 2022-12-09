(ns day3
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(defn parse-input [input]
  (map #(map set (split-at (/ (count (seq %)) 2) (seq %))) (line-seq input)))

(defn problem1 []
  (with-open [input (io/reader "resource/day3.txt")]
    (->> input
         parse-input
         (map #(apply set/intersection %))
         (map #(reduce identity %))
         (map int)
         (map #(if (>= % 97)
                 (- % 96)
                 (- % 38)))
         (reduce +))))

(defn problem2 []
  (with-open [input (io/reader "resource/day3.txt")]
    (->> input
         line-seq
         (map seq)
         (map set)
         (partition 3)
         (map #(apply set/intersection %))
         (map #(reduce identity %))
         (map int)
         (map #(if (>= % 97)
                 (- % 96)
                 (- % 38)))
         (reduce +))))

(println (problem1))
(println (problem2))