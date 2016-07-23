
(ns respo-border.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span style]]
            [respo-border.comp.borders-demo :refer [comp-borders-demo]]
            [respo-border.comp.spaces-demo :refer [comp-spaces-demo]]))

(defn render [store]
  (fn [state mutate!]
    (div
      {}
      (style
        {:attrs
         {:innerHTML
          "body * {box-shadow: 0 0 1px hsla(0,0%,0%,0.07)}"}})
      (comp-borders-demo)
      (comp-spaces-demo))))

(def comp-container (create-comp :container render))
