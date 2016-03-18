(ns clj-sudoku2.validate-test
  (:require [clojure.test :refer :all]
            [clj-sudoku2.validate :refer :all]))

(def invalid-grid [
                   [0 9 7  0 4 0  6 0 8],
                   [0 0 0  7 0 0  0 1 0],
                   [6 0 0  5 0 0  0 0 0],
        
                   [7 3 0  0 1 2  5 0 0],
                   [1 0 8  6 8 4  3 0 7], ; invalid row/column: 8
                   [0 0 6  3 7 0  0 8 1],
        
                   [0 0 0  0 0 5  0 0 2],
                   [0 6 0  5 0 7  0 0 0], ; invalid box with two 5 
                   [3 0 5  0 8 0  9 7 0]])

(deftest valid-seq?-test
  (testing "valid-seq?"
           (testing "empty sequence is valid"
                    (is (valid-seq? [])))
           (testing "sequence without doubles is valid"
                    (is (valid-seq? [3 0 1 0 0 5 6])))
           (testing "sequence with doubles is not valid"
                    (is (not (valid-seq? [3 1 3 4]))))))

(deftest column-test
  (testing "column returns column"
           (is (= [0 7 5 0 6 3 0 5 0] (column invalid-grid 3)))))

(deftest box-start-test
  (testing "box-start should calculate upper/left box coordinate"
           (is (= 0 (box-start 0)))
           (is (= 0 (box-start 2)))
           (is (= 6 (box-start 6)))))

(deftest box-seq-test
  (testing "box-seq should return box for x y as sequence"
           (is (= [0 1 2 6 8 4 3 7 0] (box-seq invalid-grid 3 3)))
           (is (= [0 1 2 6 8 4 3 7 0] (box-seq invalid-grid 4 3)))
           (is (= [0 0 2 0 0 0 9 7 0] (box-seq invalid-grid 6 7)))))


(deftest valid-grid?-test
  (testing "valid-grid"  
           (testing "returns false for invalid row"
                    (is (not (valid-grid? invalid-grid 3 4))))
           (testing "returns false for invalid column"
                    (is (not (valid-grid? invalid-grid 4 2))))
           (testing "returns false for invalid box"
                    (is (not (valid-grid? invalid-grid 5 7))))           
           (testing "returns true for valid column/row"
                    (is (valid-grid? invalid-grid 1 2)))))
