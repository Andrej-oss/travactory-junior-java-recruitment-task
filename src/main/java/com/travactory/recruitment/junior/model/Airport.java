package com.travactory.recruitment.junior.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /** Unique IATA airport code */
    private String code;
    /** Representative name */
    private String name;
    /** Time offset from GMT time zone (in hours) */
    private Integer gmtTimeZoneOffset;

    public Integer getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public Integer getGmtTimeZoneOffset() {
        return this.gmtTimeZoneOffset;
    }
}
