(ns clj-sudoku2.validate)
(require '[clj-sudoku2.util :as util])

(defn valid-seq? [row]
  (not (util/doublicates? (filter #(not= % 0) row))))

(defn column [grid x]
  (map #(nth % x) grid))

(defn valid-grid? [grid x y]
  (and 
    (valid-seq? (nth grid y))
    (valid-seq? (column grid x))))