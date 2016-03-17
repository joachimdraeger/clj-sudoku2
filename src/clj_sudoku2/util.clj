(ns clj-sudoku2.util)


; Create a new grid with the cell in x/y replaced with value
(defn replace-cell [grid x y value]
  (assoc grid y (assoc (nth grid y) x value)))

(defn cell [grid x y]
  (nth (nth grid y) x))

(defn doublicates-in-sorted? [l] 
  (if (empty? l)
    false
    (if (= (first l) (first (next l)))
      true
      (doublicates-in-sorted? (next l))))) 

(defn doublicates? [l]
  (doublicates-in-sorted? (sort l)))


; Tries function f with each value from values while f returns nil
(defn try-values [f values] 
  (if (empty? values) 
    nil 
    (let [result (f (first values))]
      (if (not= result nil) result (try-values f (next values))))))


