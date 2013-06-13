package ru.intrface.movieactors.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.annotations.UuidGenerator;

@MappedSuperclass
@UuidGenerator(name="SYS_OBJ_UUID_GEN")
public class SystemObject implements Serializable{

	private static final long serialVersionUID = 9039813743825537387L;
	@Id
	@GeneratedValue(generator="SYS_OBJ_UUID_GEN")
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
