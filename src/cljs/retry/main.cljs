(ns retry.main
  (:require [retry.js-utils :as utils]
            [retry.render :as render]
            [retry.physics :as phy]))

(defn timestamp-delta [old new]
  (if old (- new old) 0))

(defn update-player [player]
  (-> player
      phy/accelerate
      phy/move))

(defn update-world [world]
  (let [new-player (update-player (:player world))]
    (assoc world :player new-player)))

(defn tick [world context last-timestamp timestamp]
  (render/draw-world context world)
  (utils/request-next-frame (partial tick
                                     (update-world world)
                                     context
                                     timestamp)))

(defn build-world []
  {
   :player {
            :position [50 200]
            :velocity [0.2 0]
            :acceleration [0 0]
            }
   })

(defn initialize []
  (let [context (render/create-context)
        world (build-world)]
    (utils/request-next-frame (partial tick
                                       world
                                       context
                                       nil))))

(utils/domready initialize)
