package com.fpt.booking.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class BaseRepository {
    private static final Logger log = LogManager.getLogger(BaseRepository.class);

    private BaseRepository() {
    }

    public static <T> List<T> getResultListNativeQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz) {
        Query nativeQuery = em.createNativeQuery(strQuery, clazz);
        return getResultList(nativeQuery, params, clazz);
    }

    public static <T> List<T> getResultListJpaQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz)  {
        Query jpaQuery = em.createQuery(strQuery, clazz);
        return getResultList(jpaQuery, params, clazz);
    }

    private static <T> List<T> getResultList(Query query, Map<String, Object> params, Class<T> clazz) {
        params.forEach(query::setParameter);
        List<T> resultList = new ArrayList();
        Iterator var6 = query.getResultList().iterator();

        while(var6.hasNext()) {
            Object obj = var6.next();
            if (obj != null) {
                if (!clazz.isInstance(obj)) {
                    throw new IllegalArgumentException("Error") ;
                }

                resultList.add(clazz.cast(obj));
            }
        }

        return resultList;
    }

    public static <T> T getScalarResultNativeQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz) {
        Query nativeCountQuery = em.createNativeQuery(strQuery);
        return getScalarResult(nativeCountQuery, params, clazz);
    }

    public static <T> T getScalarResultJpaQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz) {
        Query jpaCountQuery = em.createQuery(strQuery);
        return getScalarResult(jpaCountQuery, params, clazz);
    }

    private static <T> T getScalarResult(Query query, Map<String, Object> params, Class<T> clazz) {
        params.forEach(query::setParameter);

        try {
            Object obj = query.getSingleResult();
            ObjectMapper mapper = new ObjectMapper();
            String debugResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            log.debug(debugResult);
            log.debug(obj.getClass());
            if (clazz.isInstance(obj)) {
                return clazz.cast(obj);
            }
        } catch (NoResultException var7) {
            log.info(var7.getMessage());
        } catch (Exception var8) {
            log.error(var8.getMessage());
            if (log.isDebugEnabled()) {
                log.debug(var8.getMessage(), var8);
            }
        }

        return null;
    }

    public static <T> Page<T> getPagedNativeQuery(EntityManager em, String strQuery, String strCountQuery, Map<String, Object> params, Pageable pageable, Class<T> clazz) {
        Query nativeQuery = em.createNativeQuery(strQuery, clazz);
        Number total = (Number)getScalarResultNativeQuery(em, strCountQuery, params, Number.class);
        return getPaged(nativeQuery, params, pageable, total, clazz);
    }

    public static <T> Page<T> getPagedJpaQuery(EntityManager em, String strQuery, String strCountQuery, Map<String, Object> params, Pageable pageable, Class<T> clazz) {
        Query jpaQuery = em.createQuery(strQuery, clazz);
        Number total = null;
        if (pageable.getPageSize() != Integer.MAX_VALUE) {
            total = (Number)getScalarResultJpaQuery(em, strCountQuery, params, Number.class);
        }

        return getPaged(jpaQuery, params, pageable, total, clazz);
    }

    private static <T> Page<T> getPaged(Query query, Map<String, Object> params, Pageable pageable, Number total, Class<T> clazz) {
        int firstResult = pageable.getPageNumber() * pageable.getPageSize();
        query.setFirstResult(firstResult);
        query.setMaxResults(pageable.getPageSize());
        params.forEach(query::setParameter);
        List<T> resultList = new ArrayList();
        Iterator var9 = query.getResultList().iterator();

        while(var9.hasNext()) {
            Object obj = var9.next();
            if (!clazz.isInstance(obj)) {
                throw new IllegalArgumentException("Error");
            }

            resultList.add(clazz.cast(obj));
        }

        return new PageImpl(resultList, pageable, total == null ? (long)resultList.size() : total.longValue());
    }

    public static <T> T getFirstResultNativeQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz) {
        List<T> list = getResultListNativeQuery(em, strQuery, params, clazz);
        return list.isEmpty() ? null : list.get(0);
    }

    public static <T> Optional<T> getFirstOptionalResultNativeQuery(EntityManager em, String strQuery, Map<String, Object> params, Class<T> clazz) {
        T t = getFirstResultNativeQuery(em, strQuery, params, clazz);
        return t == null ? Optional.empty() : Optional.of(t);
    }

    public static int countRowEffects(EntityManager em, String strQuery, Map<String, Object> params){
        if (!em.isJoinedToTransaction()) {
            em.joinTransaction();
        }

        Query nativeQuery = em.createNativeQuery(strQuery);
        params.forEach(nativeQuery::setParameter);

        try {
            return nativeQuery.executeUpdate();
        } catch (Exception var6) {
            log.error("{}\n{}\n{}\n{}", var6.getMessage(), strQuery, params, var6);
            throw new IllegalArgumentException("countRowEffects ERROR");
        }
    }


    public static List<Map<String, Object>> getResultListNativeQuery(EntityManager em, String strQuery, Map<String, Object> params) {
        Query nativeQuery = em.createNativeQuery(strQuery);
        ((NativeQuery)nativeQuery.unwrap(NativeQuery.class)).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        params.forEach(nativeQuery::setParameter);
        List<Map<String, Object>> resultList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'");
        Iterator var8 = nativeQuery.getResultList().iterator();

        while(var8.hasNext()) {
            Object obj = var8.next();
            if (obj != null) {
                if (!(obj instanceof Map)) {
                    throw new IllegalArgumentException("Error");
                }

                Map<?, ?> map = (Map)obj;
                if (!map.isEmpty()) {
                    log.info(map);
                    resultList.add((Map)map.entrySet().parallelStream().filter((e) -> {
                        return e != null && e.getKey() != null && e.getValue() != null;
                    }).collect(Collectors.toMap((e) -> {
                        return String.valueOf(e.getKey());
                    }, (e) -> {
                        if (e.getValue() instanceof Date) {
                            Date date = (Date)e.getValue();
                            return simpleDateFormat.format(date);
                        } else if (e.getValue() instanceof Timestamp) {
                            Timestamp datex = (Timestamp)e.getValue();
                            return simpleDateFormat.format(datex);
                        } else {
                            return e.getValue();
                        }
                    })));
                }
            }
        }

        return resultList;
    }
}
