(ns retry.main
  (:require [retry.js-utils :as utils]
            [retry.render :as render]
            [retry.vectors :as vec]))

(defn timestamp-delta [old new]
  (if old (- new old) 0))

(defn update-player [player]
  (let [new-velocity (vec/add (:velocity player) (:acceleration player))
        new-position (vec/add (:position player) new-velocity)]
    ;; (utils/log (str player))
    
    (assoc player :velocity new-velocity
                  :position new-position)))

(defn update-world [world]
  (let [new-player (update-player (:player world))]
    (assoc world :player new-player)))

(defn tick [world context last-timestamp timestamp]
  (let [new-world (update-world world)]
    (render/clear-context context)
    (render/draw-player context (:player world))
    (utils/request-next-frame (partial tick new-world context timestamp))))

(defn build-world []
  {
   :player {
            :position [50 200]
            :velocity [0 0]
            :acceleration [0 0]
            }
   })

(defn initialize []
  (let [context (render/create-context)
        world (build-world)]
    (render/clear-context context)
    (utils/request-next-frame (partial tick world context nil))))

(utils/domready initialize)
