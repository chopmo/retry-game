(ns retry.controls
  (:require [retry.js-utils :as utils]))

(defn update-rotation [player keys]
  (let [modifier (cond (:a keys) -0.1 (:d keys) 0.1 true 0)]
    (assoc player :rotation (+ modifier (:rotation player)))))

(defn update-acceleration [player keys]
  (let [new-acceleration (if (:w keys) [0.3 0] [0 0])]
    (assoc player :acceleration new-acceleration)))

(defn update-player [player keys]
  (-> player
      (update-rotation keys)
      (update-acceleration keys)))
