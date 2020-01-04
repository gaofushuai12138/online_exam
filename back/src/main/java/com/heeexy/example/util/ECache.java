package com.heeexy.example.util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ECache {

    /**
     * key-value data set
     */
    private final static Map<String, Entity> DATA_BASE = new HashMap<>();
    /**
     * use scheduled executor to clean expired data
     */
    private final static ScheduledExecutorService CLEANER = Executors.newSingleThreadScheduledExecutor();

    /**
     * put data to cache
     *
     * @param key   unique identification for data
     * @param value your data
     */
    public synchronized static void put(String key, Object value) {
        ECache.put(key, value, 0L);
    }

    /**
     * put data to cache
     *
     * @param key    unique identification for data
     * @param value  your data
     * @param expire data survival time in milliseconds
     */
    public synchronized static void put(final String key, final Object value, final long expire) {
        //clean old data
        ECache.remove(key);
        //set schedule task
        if (expire > 0L) {
            Future future = CLEANER.schedule(new Runnable() {
                @Override
                public void run() {
                    //remove data
                    synchronized (ECache.class) {
                        DATA_BASE.remove(key);
                    }
                }
            }, expire, TimeUnit.MILLISECONDS);
            DATA_BASE.put(key, new Entity(value, expire, future));
        } else {
            DATA_BASE.put(key, new Entity(value, null, null));
        }
    }

    /**
     * read data from cache
     *
     * @param key unique identification for data
     * @return data bound to the key
     */
    public synchronized static <T> T get(String key) {
        Entity entity = DATA_BASE.get(key);
        if (entity != null && entity.isAlive()) {
            return (T) entity.value;
        }
        return null;
    }

    /**
     * remove cached data
     *
     * @param key unique identification for data
     * @return data bound to the key
     */
    public synchronized static <T> T remove(String key) {
        //remove data from data set
        Entity entity = DATA_BASE.remove(key);
        if (entity == null) {
            return null;
        }
        //cancel the schedule task
        if (entity.future != null) {
            entity.future.cancel(true);
        }

        return entity.isAlive() ? (T) entity.value : null;
    }

    /**
     * cached data entity
     */
    private static class Entity {
        Object value;
        Long expirationTime;
        Future future;

        Entity(Object value, Long expire, Future future) {
            this.value = value;
            this.expirationTime = (expire == null ? null : System.currentTimeMillis() + expire);
            this.future = future;
        }

        /**
         * Judging whether the entity is still alive
         *
         * @return boolean
         */
        boolean isAlive() {
            return this.expirationTime == null || this.expirationTime >= System.currentTimeMillis();
        }
    }
}
