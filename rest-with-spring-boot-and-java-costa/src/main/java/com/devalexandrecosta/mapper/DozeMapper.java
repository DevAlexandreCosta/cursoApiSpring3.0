package com.devalexandrecosta.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozeMapper {

//	 inicializando o mapper 
	 private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
//	  criando o metodo para fazer a conversão das entidades 
	 
	 public static <O , D> D parseObject(O origin ,Class<D> destination) {
		return mapper.map( origin, destination);
		 
	 }
	 
//	  criando o metodo para fazer a conversão das listas 
	 
	 public static <O , D> List<D> parseListObject(List<O> origin ,Class<D> destination) {
		 List<D> destinationObjects = new ArrayList<D>(); 
		 for(O o :origin) {
			 destinationObjects.add(mapper.map(o, destination));
		 }
		return destinationObjects;
		
		 
	 }
}
