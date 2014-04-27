(ns retry.render
  (:require [retry.js-utils :as utils]))

(def width 600)
(def height 400)

(defn create-context []
  (let [canvas (.createElement js/document "canvas")
        container (.querySelector js/document "body > .container")]
    (set! (. canvas -width) width)
    (set! (. canvas -height) height)
    (.appendChild js/container canvas)
    (.getContext canvas "2d")))

(defn clear-context [context]
  (set! (. context -fillStyle) "#000000")
  (.fillRect js/context 0 0 width height))

(defn draw-player [context player]
  (let [x (first (:position player))
        y (last (:position player))
        rotation (:rotation player)]
    (set! (. context -fillStyle) "#FFF")
    (. context save)
    (. context translate x y)
    (. context rotate rotation)
    (. context beginPath)
    (. context moveTo -15 -10)
    (. context lineTo 15 0)
    (. context lineTo -15 10)
    (. context lineTo -5 0)
    (. context closePath)
    (. context fill)
    (. context restore)))

(defn draw-world [context world]
  (clear-context context)
  (draw-player context (:player world)))
