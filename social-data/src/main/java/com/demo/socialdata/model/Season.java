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
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "season")
public class Season {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "season_name")
    private String seasonName;

    @JsonIgnore
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<PlayerTeam> playerTeamSet;
}
