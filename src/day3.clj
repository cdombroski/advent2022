(ns day3
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(defn problem1 []
  (with-open [input (io/reader "resource/day3.txt")]
    (->> input
         line-seq
         (map seq)
         (map #(split-at (/ (count %) 2) %))
         (map #(map set %))
         (map #(apply set/intersection %))
         (map first)
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
         (map first)
         (map int)
         (map #(if (>= % 97)
                 (- % 96)
                 (- % 38)))
         (reduce +))))

(println (problem1))
(println (problem2))