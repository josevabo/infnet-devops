package com.josevabo.infnetdevops.medico.resource;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractResource{

    ModelMapper mapper;

    public AbstractResource(){
        mapper = new ModelMapper();
        mapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }



    <T> T map(Object obj, Class<T> returnType) {
        return mapper.map(obj, returnType);
    }

    public <T,R> List<R> mapList(List<T> list, Class<R> returnType){
        return list.stream().map(item -> map(item, returnType)).collect(Collectors.toList());
    }

}

