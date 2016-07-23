
Respo border
----

> virtual DOM transformation to insert borders(or spaces)

Demo http://repo.tiye.me/respo-mvc/respo-border/

### Usage

[![Clojars Project](https://img.shields.io/clojars/v/respo/border.svg)](https://clojars.org/respo/border)

```clojure
[respo/border "0.1.0"]
```

There are two functions:

* `respo-border.transform.border/interpose-borders`
* `respo-border.transform.space/interpose-spaces`

Use them like this:

```clojure
(ns respo-border.comp.borders-demo
  (:require [respo.alias :refer [create-comp div]]
            [respo.component.text :refer [comp-text]]
            [respo-border.transform.border :refer [interpose-borders]]
            [respo-border.style.layout :as layout]))

(def additional-border-style {:height "1px"})

(def horizontal-style {:width "1px"})

(defn render []
  (fn [state mutate!]
    (div
      {}
      (interpose-borders
        (div
          {:style (merge layout/area layout/column)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        additional-border-style)
      (interpose-borders
        (div
          {:style (merge layout/area layout/row)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        horizontal-style))))

(def comp-borders-demo (create-comp :borders-demo render))
```

### Develop

https://github.com/mvc-works/boot-workflow

### License

MIT
