(ns euler.level1.problem011-spec
  (:require
    [speclj.core :refer :all]
    [euler.level1.problem011 :refer :all]))

; http://projecteuler.net/index.php?section=problems&id=11

(describe "Euler Problem #11"
  (def euler-grid [[8 2 22 97 38 15 0 40 0 75 4 5 7 78 52 12 50 77 91 8]
                   [49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00]
                   [81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65]
                   [52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91]
                   [22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80]
                   [24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50]
                   [32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70]
                   [67 26 20 68 02 62 12 20 95 63 94 39 63 8 40 91 66 49 94 21]
                   [24 55 58 5 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72]
                   [21 36 23 9 75 0 76 44 20 45 35 14 0 61 33 97 34 31 33 95]
                   [78 17 53 28 22 75 31 67 15 94 03 80 4 62 16 14 9 53 56 92]
                   [16 39 5 42 96 35 31 47 55 58 88 24 0 17 54 24 36 29 85 57]
                   [86 56 0 48 35 71 89 7 5 44 44 37 44 60 21 58 51 54 17 58]
                   [19 80 81 68 5 94 47 69 28 73 92 13 86 52 17 77 4 89 55 40]
                   [4 52 8 83 97 35 99 16 7 97 57 32 16 26 26 79 33 27 98 66]
                   [88 36 68 87 57 62 20 72 3 46 33 67 46 55 12 32 63 93 53 69]
                   [4 42 16 73 38 25 39 11 24 94 72 18 8 46 29 32 40 62 76 36]
                   [20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 4 36 16]
                   [20 73 35 29 78 31 90 1 74 31 49 71 48 86 81 16 23 57 05 54]
                   [1 70 54 71 83 51 54 69 16 92 33 48 61 43 52 1 89 19 67 48]])

  (def test-grid [[1 2 3 4 5]
                  [2 3 4 5 6]
                  [3 4 5 6 7]
                  [4 5 6 7 8]
                  [9 8 7 6 5]])

  (it "returns columns in grid"
      (should= [1 2 3 4 9] (find-columns test-grid 0))
      (should= [2 3 4 5 8] (find-columns test-grid 1))
      (should= [3 4 5 6 7] (find-columns test-grid 2))
      (should= [4 5 6 7 6] (find-columns test-grid 3))
      (should= [5 6 7 8 5] (find-columns test-grid 4)))

  (it "returns diagonals in grid"
      (should= [[1 3 5 7 5] [9 5 5 5 5] [2 4 6 8] [8 6 6 6]
                [4 4 4 4] [6 6 4 2] [5 5 5 5 9] [5 7 5 3 1]] (find-diagonals test-grid)))

  (it "returns max product of 4 elements for each row"
      (should= 120 (multiply (nth test-grid 0)))
      (should= 360 (multiply (nth test-grid 1)))
      (should= 840 (multiply (nth test-grid 2)))
      (should= 1680 (multiply (nth test-grid 3)))
      (should= 3024 (multiply (nth test-grid 4))))

  (it "returns max product of 4 elements for each column"
      (should= 216 (multiply (find-columns test-grid 0)))
      (should= 480 (multiply (find-columns test-grid 1)))
      (should= 840 (multiply (find-columns test-grid 2)))
      (should= 1260 (multiply (find-columns test-grid 3)))
      (should= 1680 (multiply (find-columns test-grid 4))))

  (it "returns max product of 4 elements for each diagonals"
       (should= [525 1125 384 1728 256 288 1125 525] (for [diagonal (find-diagonals test-grid)] (multiply diagonal))))

  (it "Solves #11"
      (should= 3024 (euler-11 test-grid))
      (should= 70600674 (euler-11 euler-grid)))
)


(run-specs)
