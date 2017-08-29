(set-env!
  :source-paths #{"src"}
  :resource-paths #{"src" "resources"}
  :dependencies '[[adzerk/boot-cljs "1.7.228-2" :scope "test"]
                  [adzerk/boot-reload "0.4.13" :scope "test"]
                  [pandeiro/boot-http "0.7.3" :scope "test"
                   :exclusions [org.clojure/clojure]]
                  [nightlight "1.7.2"]
                  [org.clojure/clojurescript "1.9.854"]
                  [reagent "0.7.0"]
                  [cljsjs/tonejs "0.8.0-1"]])

(require
  '[adzerk.boot-cljs :refer [cljs]]
  '[adzerk.boot-reload :refer [reload]]
  '[pandeiro.boot-http :refer [serve]]
  '[nightlight.boot :refer [nightlight sandbox]])

(deftask dev []
  (comp
    (watch)
    (reload :asset-path "nightcoders" :cljs-asset-path ".")
    (sandbox :file "java.policy")
    (cljs :source-map true :optimizations :none)
    (target)))

(deftask run []
  (comp
    (serve :dir "target/nightcoders" :port 3000)
    (dev)
    (nightlight :port 4000 :url "http://localhost:3000")))

(deftask build []
  (comp (cljs :optimizations :advanced) (target)))

