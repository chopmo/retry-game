(ns retry.physics
  (:require [retry.vectors :as vec]))

(defn accelerate [obj]
  (let [new-velocity (vec/add (:velocity obj) (:acceleration obj))]
    (assoc obj :velocity new-velocity)))

(defn move [obj]
  (let [new-position (vec/add (:position obj) (:velocity obj))]
    (assoc obj :position new-position)))

(defn drag [obj]
  (let [new-velocity (vec/mul (:velocity obj) 0.98)]
    (assoc obj :velocity new-velocity)))
