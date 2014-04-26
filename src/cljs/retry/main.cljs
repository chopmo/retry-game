(ns retry.main
  (:require [retry.js-utils :as utils]
            [retry.render :as render]))

(defn timestamp-delta [old new]
  (if old (- new old) 0))

(defn tick [world context last-timestamp timestamp]
  (render/draw-player context (:player world))
  (utils/request-next-frame (partial tick world context timestamp)))

(defn build-world []
  {
   :player { :x 50 :y 200 }
   })

(defn initialize []
  (let [context (render/create-context)
        world (build-world)]
    (render/clear-context context)
    (utils/request-next-frame (partial tick world context nil))))

(utils/domready initialize)
