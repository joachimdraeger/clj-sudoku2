(ns clj-sudoku2.format)

(defn format-row [row] 
  (apply str 
    (interpose "  " 
      (map 
        #(apply str (interpose " " %)) 
        (partition 3 row)
      )
    )
  )
)

(defn format-grid [grid]
  (if (= grid nil)
    "nil"
    (apply str 
      (apply concat 
        (interpose "\n" 
          (partition 3 
            (map #(str (format-row %) "\n") grid)))))))

(defn print-grid [grid]
  (println (format-grid grid) "-----------------"))
