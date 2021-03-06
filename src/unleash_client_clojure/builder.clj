(ns unleash-client-clojure.builder
  (:import [no.finn.unleash CustomHttpHeadersProvider UnleashContextProvider]
           [no.finn.unleash.util UnleashConfig UnleashConfig$Builder UnleashScheduledExecutor]
           [no.finn.unleash.event UnleashSubscriber]))

(defn build ^UnleashConfig [& fs]
  (let [bldr (UnleashConfig$Builder.)]
    (.build ^UnleashConfig$Builder
            (reduce
              (fn
                ([] bldr)
                ([bldr f]
                 (f bldr)))
              bldr
              fs))))

(defn app-name [^String name]
  (fn [^UnleashConfig$Builder bldr]
    (.appName bldr name)))

(defn instance-id [^String id]
  (fn [^UnleashConfig$Builder bldr]
    (.instanceId bldr id)))

(defn unleash-api [^String api]
  (fn [^UnleashConfig$Builder bldr]
    (.unleashAPI bldr api)))

(defn custom-http-header [header-name header-value]
  (fn [^UnleashConfig$Builder bldr]
    (.customHttpHeader bldr header-name header-value)))

(defn send-metrics-interval [^Long interval-seconds]
  (fn [^UnleashConfig$Builder bldr]
    (.sendMetricsInterval bldr interval-seconds)))

(defn fetch-toggles-interval [^Long interval-seconds]
  (fn [^UnleashConfig$Builder bldr]
    (.fetchTogglesInterval bldr interval-seconds)))

(defn synchronous-fetch-on-initialisation [enable?]
  (fn [^UnleashConfig$Builder bldr]
    (.synchronousFetchOnInitialisation bldr enable?)))

(defn enable-proxy-authentication-by-jvm-properties []
  (fn [^UnleashConfig$Builder bldr]
    (.enableProxyAuthenticationByJvmProperties bldr)))

(defn backup-file [^String backup-file]
  (fn [^UnleashConfig$Builder bldr]
    (.backupFile bldr backup-file)))

(defn environment [^String environment]
  (fn [^UnleashConfig$Builder bldr]
    (.environment bldr environment)))

(defn custom-http-header-provider [^CustomHttpHeadersProvider provider]
  (fn [^UnleashConfig$Builder bldr]
    (.customHttpHeadersProvider bldr provider)))

(defn unleash-context-provider [^UnleashContextProvider provider]
  (fn [^UnleashConfig$Builder bldr]
    (.unleashContextProvider bldr provider)))

(defn scheduled-executor [^UnleashScheduledExecutor executor]
  (fn [^UnleashConfig$Builder bldr]
    (.scheduledExecutor bldr executor)))

(defn subscriber [^UnleashSubscriber subscriber]
  (fn [^UnleashConfig$Builder bldr]
    (.subscriber bldr subscriber)))
