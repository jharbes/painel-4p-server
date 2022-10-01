package com.model;

import java.util.Arrays;
import java.util.Optional;

public enum Project {
	FIXO_RJ(0),COMPARTILHADO_RJ(1),COMPARTILHADO_SP(2),COMPARTILHADO_ES(3),COMPARTILHADO_BA(4),EXCLUSIVO_RJ(5);
	
	private final int value;
	
	Project(int value){
		this.value = value;
	}
	
	 public static Optional<Project> valueOf(int value) {
	        return Arrays.stream(values())
	            .filter(project -> project.value == value)
	            .findFirst();
	    }
}
