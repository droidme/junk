/*
 * JUNK
 *
 * 2017 (c) droidme.io
 */
package io.droidme.fly.developer.entity;

import static io.droidme.fly.developer.entity.Developer.FIND_ALL;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droidme
 */
@XmlRootElement
@XmlAccessorType(FIELD)
@Entity
@Table(name="DEVELOPER", schema = "sample")
@NamedQuery(name = FIND_ALL, query = "select d from Developer d")
public class Developer implements Serializable {
    
    public static final String FIND_ALL = "io.droidme.fly.developer.entity.Developer#FIND_ALL";
    
    @Id
    @Column(name = "ID", nullable = false)
    int id;
    
    @Column(name = "NAME", length = 100, nullable = false)
    String name;
    
}
