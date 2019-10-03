/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funda.backend.converters;

import com.funda.backend.services.EntityService;
import com.funda.backend.vo.Entity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author phanic
 */
@Component
public class IdToEntityConverterFactory implements
        ConverterFactory<String, Entity> {

    @Override
    public <T extends Entity> Converter<String, T> getConverter(Class<T> type) {
        return new IdToEntityConverter(type);
    }

    private class IdToEntityConverter<T extends Entity> implements Converter<String, T> {

        private Class<T> targetType;

        public IdToEntityConverter(Class<T> target) {
            this.targetType = target;
        }

        @Override
        public T convert(String id) {
            System.out.println("the id and targer are "+id+" , "+targetType);
            return (T) new EntityService().getEntity(id, targetType);
        }

    }

}
