(ns clj-sudoku2.validate)
(require '[clj-sudoku2.util :as util])

(defn valid-seq? [row]
  (not (util/doublicates? (filter #(not= % 0) row))))

; calculate the start coordinate for the box a given x or y coordinate points to
(defn box-start [n] 
  (* (quot n 3) 3))

(defn box-seq [grid x y]
  (let [box-x (box-start x)
        box-y (box-start y)]
    (apply concat (map 
                    #(subvec % box-x (+ box-x 3)) 
                    (subvec grid box-y (+ box-y 3))))))

(defn column [grid x]
  (map #(nth % x) grid))

(defn valid-grid? [grid x y]
  (and 
    (valid-seq? (nth grid y))
    (valid-seq? (column grid x))
    (valid-seq? (box-seq grid x y))))
