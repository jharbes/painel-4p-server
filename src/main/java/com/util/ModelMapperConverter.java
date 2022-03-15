package com.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConverter {
    @Autowired
    ModelMapper modelMapper;
	public <S, T> List<T> listToListDTO(List<S> source, Class<T> targetClass) {
	    return source.stream().map(ele -> modelMapper.map(ele, targetClass)).collect(Collectors.toList());
	}
	
	public <S, T> T entityToDTO(S source, Class<T> targetClass) {
	    return modelMapper.map(source,targetClass);
	}
	
}
