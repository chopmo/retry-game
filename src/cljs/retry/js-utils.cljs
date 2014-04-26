(ns retry.js-utils)

(defn log [args]
  (.log js/console args))

(defn domready [handler]
  (.addEventListener js/window "DOMContentLoaded" handler))
