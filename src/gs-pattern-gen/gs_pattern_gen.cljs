(ns nightcoders.gs-pattern-gen
  (:require [reagent.core :as r]
            [tonejs]))


;;define chords
;;using :C0 for rests 
(def b-maj [:B3 :C#4 :D#4 :F#4])
(def g-maj [:G4 :A4 :B4 :D4])
(def eb-maj [:Eb4 :F4 :G4 :Bb3])
(def bb-maj [:Bb3 :C4 :D4 :F4])
(def ab-maj [:Ab4 :Bb4 :C4 :Eb4])
(def fis-maj [:F#4 :G#4 :A#4 :C#4])
(def e-maj [:E4 :F#4 :G#4 :B3])
(def d-maj [:D4 :E4 :F#4 :A4])
(def c-maj [:C4 :D4 :E4 :G4])

(def d-dom [:D4 :E4 :F#4 :A4 :C4 :C0])
(def bb-dom [:Bb3 :C4 :D4 :F4 :Ab4 :C0])
(def fis-dom [:F#4 :G#4 :A#3 :C#4 :E4 :C0])
(def f-dom [:F4 :G4 :A4 :C4 :Eb4 :C0])
(def eb-dom [:Eb4 :F4 :G4 :Bb4 :Db4 :C0])
(def db-dom [:Db4 :Eb4 :F4 :Ab4 :B3 :C0])
(def b-dom [:B3 :C#4 :D#4 :F#4 :A4 :C0])
(def a-dom [:A4 :B3 :C#4 :E4 :G4 :C0])
(def g-dom [:G4 :A4 :B3 :D4 :F4 :C0])

(def a-min7 [:A3 :C4 :E4 :G4])
(def f-min7 [:F4 :Ab4 :C4 :Eb4])
(def cis-min7 [:C#4 :E4 :G#4 :B3])

(def eb-maj7 [:Eb4 :F4 :G4 :Bb3 :C4 :D4 :C0])
(def b-maj7 [:B3 :C#4 :D#4 :F#4 :G#4 :A#4 :C0])
(def g-maj7 [:G4 :A4 :B4 :D4 :E4 :F#4 :C0])
(def d-maj7 [:D4 :E4 :F#4 :A4 :B4 :C#4 :C0])
(def c-maj7 [:C4 :D4 :E4 :G4 :A4 :B4 :C0])
(def bb-maj7 [:Bb3 :C4 :D4 :F4 :G4 :A4 :C0])

(def e-min [:E4 :F#4 :G4 :A4])
(def d-min [:D4 :E4 :F4 :G4])
(def c-min [:C4 :D4 :Eb4 :F4])

(def e-dyad [:A4 :C5 :C0])
(def f-dom7 [:F4 :A4 :C4 :Eb4])
(def eb-wt [:Eb4 :F4 :G4 :A4 :Db4 :C0])


;;create individual chord patterns
(defn create-from-tetrad [tetrad]
  (shuffle tetrad))

(defn create-from-pentad [pentad]
  (vec (take 4 (shuffle pentad))))

(defn create-from-hexad [hexad]
  (vec (take 4 (shuffle hexad))))

(defn create-from-dyad [dyad]
  (flatten (concat (repeatedly 4 #(take 2 (shuffle dyad))))))


;;create giant steps pattern
(defn make-gs-group []
  (let [gs-group
        (clj->js (flatten (repeatedly 9 #(vec (concat
                                                (create-from-tetrad b-maj)
                                                (create-from-pentad d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-pentad bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-hexad eb-maj7)
                                                (create-from-tetrad a-min7)
                                                (create-from-pentad d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-pentad bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-pentad fis-dom)
                                                (create-from-tetrad b-maj)
                                                (create-from-hexad b-maj7)
                                                (create-from-tetrad f-min7)
                                                (create-from-pentad bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-pentad eb-maj7)
                                                (create-from-tetrad a-min7)
                                                (create-from-pentad d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-pentad g-maj7)
                                                (create-from-tetrad cis-min7)
                                                (create-from-pentad fis-dom)
                                                (create-from-tetrad b-maj)
                                                (create-from-pentad b-maj7)
                                                (create-from-tetrad f-min7)
                                                (create-from-pentad bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-pentad eb-maj7)
                                                (create-from-tetrad cis-min7)
                                                (create-from-pentad fis-dom))))))]
    gs-group))


;;create countdown pattern 
(defn make-c-group []
  (let [c-group
        (clj->js (flatten (repeatedly 9 #(vec (concat
                                                (create-from-tetrad e-min)
                                                (create-from-pentad f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-pentad db-dom)
                                                (create-from-tetrad fis-maj)
                                                (create-from-pentad a-dom)
                                                (create-from-tetrad d-maj)
                                                (create-from-hexad d-maj7)
                                                (create-from-tetrad d-min)
                                                (create-from-pentad eb-dom)
                                                (create-from-tetrad ab-maj)
                                                (create-from-pentad b-dom)
                                                (create-from-tetrad e-maj)
                                                (create-from-pentad g-dom)
                                                (create-from-tetrad c-maj)
                                                (create-from-hexad c-maj7)
                                                (create-from-tetrad c-min)
                                                (create-from-pentad db-dom)
                                                (create-from-tetrad fis-maj)
                                                (create-from-pentad a-dom)
                                                (create-from-tetrad d-maj)
                                                (create-from-pentad f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-hexad bb-maj7)
                                                (create-from-dyad e-dyad)
                                                (create-from-tetrad f-dom7)
                                                (create-from-pentad f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-hexad bb-maj7)
                                                (create-from-pentad eb-wt)
                                                (create-from-pentad eb-wt))))))]
    c-group))


;;create bass progressions
(def gs-bass-group (array 
                     "B1" "D2" "G2" "Bb2" "Eb2" "Eb3" "A2" "D2"
                     "G2" "Bb2" "Eb2" "F#2" "B1" "B2" "F2" "Bb2"
                     "Eb2" "Eb3" "A2" "D2" "G2" "G3" "C#2" "F#2"
                     "B1" "B2" "F2" "Bb2" "Eb2" "Eb3" "C#3" "F#2"))
                     

(def c-bass-group (array 
                    "E2" "F2" "Bb1" "Db2" "F#2" "A2" "D2" "D3"
                    "D2" "Eb2" "Ab2" "B2" "E2" "G2" "C2" "C3"
                    "C2" "Db2" "F#2" "A2" "D2" "F2" "Bb1" "Bb2"
                    "E2" "E2" "F2" "F3" "Bb2" "Bb2" "Eb2" "Eb2"))


;;make the synths
(def treble-synth (-> (new js/Tone.Synth
                        {:oscillator {:type "sine"}})
                      (.toMaster)))

(def bass-synth (-> (new js/Tone.Synth
                      {:oscillator {:type "square"}}) 
                    (.toMaster)))


;;create the lead sequences
(defn gs-create-sequence [gs-group]
  (let [gs-sequence (-> (new js/Tone.Sequence
                          (fn [time note]
                            (.triggerAttackRelease treble-synth note "4n" time))
                          gs-group "8n")
                        (.start 0))]
    gs-sequence))

(defn c-create-sequence [c-group]
  (let [c-sequence (-> (new js/Tone.Sequence
                         (fn [time note]
                           (.triggerAttackRelease treble-synth note "4n" time))
                         c-group "8n")
                       (.start 0))]
    c-sequence))


;;generate the complete synth patterns
(defn gs-generate-pattern []
  (let [gs-group (make-gs-group)
        gs-sequence (gs-create-sequence gs-group)]
    gs-sequence
    (set! (.-loop gs-sequence) 1)))

(defn c-generate-pattern []
  (let [c-group (make-c-group)
        c-sequence (c-create-sequence c-group)]
    c-sequence
    (set! (.-loop c-sequence) 1)))


;;start and stop the audio transport
(defn gs-play []
  (let [gs-bass-seq (-> (new js/Tone.Sequence
                          (fn [time note]
                            (.triggerAttackRelease bass-synth note "4n" time))
                          gs-bass-group "2n")
                        (.start 0))] 
    gs-bass-seq
    (set! (.-loop gs-bass-seq) 9))
  (set! (.-value js/Tone.Transport.bpm) 200)
  (.start js/Tone.Transport "+0.2"))

(defn c-play []
  (let [c-bass-seq (-> (new js/Tone.Sequence
                         (fn [time note]
                           (.triggerAttackRelease bass-synth note "4n" time))
                         c-bass-group "2n")
                       (.start 0))] 
    c-bass-seq
    (set! (.-loop c-bass-seq) 9))
  (set! (.-value js/Tone.Transport.bpm) 240)
  (.start js/Tone.Transport "+0.2"))


(defn stop-func []
  (.stop js/Tone.Transport))


(defn gs-toggle [a t1 t2]
  (if (= @a t1)
    (do 
      (reset! a t2)
      (gs-play))
    (do 
      (reset! a t1)
      (stop-func))))

(defn c-toggle [a t1 t2]
  (if (= @a t1)
    (do 
      (reset! a t2)
      (c-play))
    (do 
      (reset! a t1)
      (stop-func))))


(defn gs-button []
  (let [button-text (r/atom "Play")]
    (fn []
      [:div
       [:button 
        {:class "btn btn-default"
         :on-click #(gs-toggle button-text "Play" "Stop")}
        (deref button-text)]])))

(defn c-button []
  (let [button-text (r/atom "Play")]
    (fn []
      [:div
       [:button 
        {:class "btn btn-default"
         :on-click #(c-toggle button-text "Play" "Stop")}
        (deref button-text)]])))


(defn content []
  [:div {:style {:text-align "center"}}
   [:h3 "Chromatic mediant pattern generator"]
   [:br]
   [:p "Giant Steps (J. Coltrane)"]
   [:b {:class "btn btn-default"
        :on-click gs-generate-pattern}
    "Generate"]
   [gs-button]
   [:br]
   [:br]
   [:p "Countdown (J. Coltrane)"]
   [:b {:class "btn btn-default"
        :on-click c-generate-pattern}
    "Generate"]
   [c-button]
   [:br]
   [:br]
   [:p "(Use headphones and Chrome/Firefox for desktop or Safari/Chrome on mobile.)"]
   [:br]
   [:p "Made with ClojureScript, Tone.js, and Nightcoders.net"]
   [:a {:href "https://github.com/vossd/gs-pattern-gen"} "code"]])


(r/render-component [content] (.querySelector js/document "#content"))

