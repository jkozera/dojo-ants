(ns dojo-ants.core)

(println "Hello World!")

(def antworld {:ourants [[7 9]] :food [[6 5]]})

(defn nearest-food [antWorld] 
  (first (antWorld :food))
  )

(defn move-first-ant-to [world location]
  (update-in world [:ourants] (fn [x] location)))