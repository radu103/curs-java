package ro.raffa.curs.model;

import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class BaseDbObject {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    private String createdBy;
    private Instant created;
    
}
