(ns retry.main
  (:require [retry.js-utils :as utils]
            [retry.render :as render]
            [retry.physics :as phy]
            [retry.keyboard :as key]
            [retry.controls :as controls]))

(defn update-player [player]
  (-> player
      (controls/update-player key/pressed-keys)
      phy/update-object))

(defn advance-world [world]
  (let [new-player (update-player (:player world))]
    (assoc world :player new-player)))

(defn add-world [worlds next-world]
  (conj worlds next-world))

(defn rewind-worlds [worlds]
  (if (> (count worlds) 2)
    (apply vector (drop-last 2 worlds))
    worlds))

(defn update-worlds [worlds]
  (if (:space key/pressed-keys)
    (rewind-worlds worlds)
    (add-world worlds (advance-world (last worlds)))))

(defn tick [worlds context _timestamp]
  (let [current-world (last worlds)
        next-worlds (update-worlds worlds)]
    (render/draw-world context current-world)
    (utils/request-next-frame (partial tick
                                       next-worlds
                                       context))))

(defn build-world []
  {
   :player {
            :position [50 200]
            :velocity [0 0]
            :acceleration [0 0]
            :rotation 0
            }
   })

(defn ^:export initialize []
  (let [context (render/create-context)
        initial-world (build-world)]
    (key/init)
    (utils/request-next-frame (partial tick
                                       [initial-world]
                                       context
                                       nil))))
