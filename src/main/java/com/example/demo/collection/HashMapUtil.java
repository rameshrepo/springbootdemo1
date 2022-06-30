package com.example.demo.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapUtil {

    /**
     * All default methods of Map Interface that use the Java v8+ Functional Interfaces.
     * computeIfAbsent - default V computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)
     * computeIfPresent - default V computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
     * compute - default V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)
     * merge - default V merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)
     * forEach - default void forEach(BiConsumer<? super K,? super V> action)
     * getOrDefault - default V getOrDefault(Object key, V defaultValue)
     *
     * References:
     * https://helloacm.com/the-difference-between-java-maps-compute-computeifabsent-and-computeifpresent/
     */

    /**
     * Will put the value (and return it) in the map only if the current key is not existent in the map.
     * If it is already existent in the map, the function will do nothing and simply return the original value.
     *     default V computeIfAbsent(K key,
     *             Function<? super K, ? extends V> mappingFunction) {
     *         Objects.requireNonNull(mappingFunction);
     *         V v;
     *         if ((v = get(key)) == null) {
     *             V newValue;
     *             if ((newValue = mappingFunction.apply(key)) != null) {
     *                 put(key, newValue);
     *                 return newValue;
     *             }
     *         }
     *         return v;
     *     }
     */
    public void computeIfAbsent() {
        Map<String, String> data = new HashMap<>();
        data.put( "One", "One");
        System.out.println(data.computeIfAbsent("One", (k) -> "One Value")); // Print "One"
        System.out.println(data.computeIfAbsent("Two", (k) -> "Two Value")); // Print "Two Value"
        System.out.println(data.get("One")); // Print "One"
        System.out.println(data.get("Two")); // Print "Two Value"
    }

    /**
     * Will update the key-value pair only if the key is existent in the Map.
     *     default V computeIfPresent(K key,
     *             BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
     *         Objects.requireNonNull(remappingFunction);
     *         V oldValue;
     *         if ((oldValue = get(key)) != null) {
     *             V newValue = remappingFunction.apply(key, oldValue);
     *             if (newValue != null) {
     *                 put(key, newValue);
     *                 return newValue;
     *             } else {
     *                 remove(key);
     *                 return null;
     *             }
     *         } else {
     *             return null;
     *         }
     *     }
     */
    public void computeIfPresent() {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 10);
        System.out.println(data.computeIfPresent(1, (key, val) -> val + 1)); // Print 11
        System.out.println(data.computeIfPresent(2, (key, val) -> val + 1)); // null
        System.out.println(data.computeIfPresent(1, (key, val) -> null)); // removes key 1
    }

    /**
     * The compute() is a bit similar to computeIfPresent() except that..
     * when the key isn’t existent in the map, calling the compute() will raise an exception if you reference the val parameter
     *     default V compute(K key,
     *             BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
     *         Objects.requireNonNull(remappingFunction);
     *         V oldValue = get(key);
     *
     *         V newValue = remappingFunction.apply(key, oldValue);
     *         if (newValue == null) {
     *             // delete mapping
     *             if (oldValue != null || containsKey(key)) {
     *                 // something to remove
     *                 remove(key);
     *                 return null;
     *             } else {
     *                 // nothing to do. Leave things as they were.
     *                 return null;
     *             }
     *         } else {
     *             // add or replace old mapping
     *             put(key, newValue);
     *             return newValue;
     *         }
     *     }
     */
    public void compute() {
        Map<Integer, Integer> data = new HashMap<>();
        data.put(1, 10);
        System.out.println(data.compute(1, (key, val) -> val + 1)); // print 11, MAP = (1: 11)
        System.out.println(data.compute(2, (key, val) -> val + 1)); // Exception in thread “main” java.lang.NullPointerException.
        System.out.println(data.compute(1, (key, val) -> null)); // remove key 1
    }

    /**
     * If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.
     * Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.
     *
     *  V oldValue = map.get(key);
     *  V newValue = (oldValue == null) ? value :
     *               remappingFunction.apply(oldValue, value);
     *  if (newValue == null)
     *      map.remove(key);
     *  else
     *      map.put(key, newValue);
     *
     */
    public void merge() {
        Map<String, Integer> count = new HashMap<>(Map.of("a", 1, "b", 1));
        System.out.println(count.merge("c", 1, (oldVal, newVal) -> oldVal + newVal)); // 1
        System.out.println(count); //{a=1, b=1, c=1}
        System.out.println(count.merge("c", 1, Integer::sum)); //2
        System.out.println(count); //{a=1, b=1, c=2}
    }

    
    public static void main(String[] args) {
        HashMapUtil hashMapUtil = new HashMapUtil();
        hashMapUtil.computeIfAbsent();
    }
}
