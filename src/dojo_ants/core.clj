(ns dojo-ants.core)

(println "Hello World!")

(def antworld {:ourants [[7 9]] :food [[6 5][7 10][7 11][9999 9999]]})

(defn distance [a b]
  (let [[x1 y1] a [x2 y2] b]
  (+ (* (- x1 x2) (- x1 x2))
     (* (- y1 y2) (- y1 y2)))))


  
(defn nearest-food [antWorld] 
  (first (sort-by (fn [food] (distance food [7 9]) ) (antWorld :food)))
  )

(defn move-first-ant-to [world location]
  (update-in world [:ourants] (fn [x] location)))