(ns retry.main
  (:require [retry.js-utils :as utils]))

(defn create-context []
  (let [canvas (.createElement js/document "canvas")
        container (.querySelector js/document "body > .container")]
    (set! (. canvas -width) 800)
    (set! (. canvas -height) 600)
    (.appendChild js/container canvas)
    (.getContext canvas "2d")))

(defn clear-context [context]
  (set! (. context -fillStyle) "#ECECEC")
  (.fillRect js/context 0 0 800 600))

(defn run []
  (let [context (create-context)]
    (clear-context context)
    (utils/log context)))

(utils/domready run)
