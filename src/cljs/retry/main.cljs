(ns retry.main
  (:require [retry.js-utils :as utils]))

(defn create-context []
  (let [canvas (.createElement js/document "canvas")
        container (.querySelector js/document "body > .container")]
    (set! (.-height canvas) 600)
    (set! (.-width canvas) 800)
    (.appendChild js/container canvas)
    (.getContext canvas "2d")))

(defn run []
  (let [context (create-context)]
    (utils/log context)))


(utils/domready run)
