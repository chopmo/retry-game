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
  (let [x (:x player)
        y (:y player)]
    (set! (. context -fillStyle) "#FFF")
    (. context beginPath)
    (. context moveTo (- x 10) (- y 10))
    (. context lineTo (+ x 30) y)
    (. context lineTo (- x 10) (+ y 10))
    (. context lineTo (- x 5) y)
    (. context closePath)
    (. context fill)))
