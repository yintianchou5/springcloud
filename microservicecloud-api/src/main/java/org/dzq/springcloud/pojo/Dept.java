package org.dzq.springcloud.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@Accessors(chain=true)
@NoArgsConstructor
public class Dept implements Serializable{
	private Long deptno;
	private String dname;
	private String db_source;
}
