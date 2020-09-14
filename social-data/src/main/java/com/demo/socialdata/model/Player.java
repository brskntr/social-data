package com.demo.socialdata.model;
/**
 * @author bariskantar
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "license_start_date")
    private Date licenseStartDate;

    @JsonIgnore
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<PlayerTeam> playerTeamSet;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Attribute> attributes;

}
