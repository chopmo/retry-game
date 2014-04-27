(ns retry.controls
  (:require [retry.js-utils :as utils]
            [retry.vectors :as vec]))

(defn rotate [player keys]
  (let [modifier (cond (:a keys) -0.1 (:d keys) 0.1 true 0)]
    (assoc player :rotation (+ modifier (:rotation player)))))

(defn accelerate [player keys]
  (let [amount (if (:w keys) 0.3 0)
        direction (vec/direction (:rotation player))
        new-acceleration (vec/mul direction amount)]
    (assoc player :acceleration new-acceleration)))

(defn update-player [player keys]
  (-> player
      (rotate keys)
      (accelerate keys)))
