(ns dojo-ants.core)

(println "Hello World!")

(def antworld {:ourants [[7 9]] :food [[6 5][7 11][9999 9999]]})

(defn distance [a b]
  (let [[x1 y1] a [x2 y2] b]
  (+ (* (- x1 x2) (- x1 x2))
     (* (- y1 y2) (- y1 y2)))))

(defn move-closer [source destination]
  (let [[x1 y1] source
        [x2 y2] destination
        dx (- x1 x2)
        dy (- y1 y2)]
    (if (= dx 0)
      (if (= dy 0)
        destination
        (if (> dy 0)
          [x1 (dec y1)]
          [x1 (inc y1)])

        )
      (if (> dx 0)
        [(dec x1) y1]
        [(inc x1) y1])
      )
    )
  )

(defn path [world source destination]
  (if (= source destination)
    [source]
    (let [next-step  (move-closer source destination)]
      (cons next-step (path world next-step destination))
    )
  
  )
  )
  
(defn nearest-food [antWorld] 
  (first (sort-by (fn [food] (distance food [7 9]) ) (antWorld :food)))
  )

(defn move-first-ant-to [world location]
  (update-in world [:ourants] (fn [x] location)))