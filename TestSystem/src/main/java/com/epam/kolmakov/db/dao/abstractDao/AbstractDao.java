package com.epam.kolmakov.db.dao.abstractDao;

import com.epam.kolmakov.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractDao<T> {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Optional<T> findById(String sql, Map<String, Long> params, RowMapper<T> rowMapper) {
        List<T> objects = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        if (objects.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(objects.get(0));
    }

    protected boolean save(String sql, Map<String, Object> params) {
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return true;
        } catch (Exception ex) {
            WebConfig.LOGGER.warn(ex.getStackTrace());
            return false;
        }
    }

    protected boolean update(String sql, Map<String, Object> params) {
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return true;
        } catch (Exception ex) {
            WebConfig.LOGGER.warn(ex.getStackTrace());
        }
        return false;
    }


    protected boolean delete(String sql, Map<String, Long> params) {
        try {
            namedParameterJdbcTemplate.update(sql, params);
            return true;
        } catch (Exception ex) {
            WebConfig.LOGGER.warn(ex.getStackTrace());
            return false;
        }
    }

    protected List<T> findAll(String sql, RowMapper<T> rowMapper) {
        return namedParameterJdbcTemplate.query(sql, rowMapper);
    }

    /**
     * Return index of last created object
     * @param sql - query to insert object to database
     * @param params - params for query
     * @return last index or -1 if no index found
     */
    protected Long saveAndGetId(String sql, MapSqlParameterSource params){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,params,keyHolder);
        long result = -1L;
        try {
            result = keyHolder.getKey().longValue();
        }catch (NullPointerException ex){
            WebConfig.LOGGER.warn(ex.getStackTrace());
        }
        return result;
    }
}
