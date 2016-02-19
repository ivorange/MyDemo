// weather.aidl
package com.weather.demo;

// Declare any non-default types here with import statements

interface weather {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    String displayWeather();
            void setWeather(String weather);
}
