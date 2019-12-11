package com.jun.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder=true)
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String source;

}
