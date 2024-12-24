package org.featherlessbipeds.watchdog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "alert")
public class Alert
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "alert_danger_level", columnDefinition = "VARCHAR(20)", nullable = false)
    private DangerLevel dangerLevel;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "alert_date", nullable = false)
    private Date date;
    @Lob
    @Column(name = "alert_description",columnDefinition = "MEDIUMBLOB" ,nullable = false)
    private byte[] description;
    @ManyToOne
    @JoinColumn(name = "entrance_id")
    private Entrance entrance;
}
