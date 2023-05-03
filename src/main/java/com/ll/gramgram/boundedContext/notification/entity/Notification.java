package com.ll.gramgram.boundedContext.notification.entity;

import com.ll.gramgram.base.baseEntity.BaseEntity;
import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Notification extends BaseEntity {
    @Setter
    private LocalDateTime readDate;
    @ManyToOne
    @ToString.Exclude
    private InstaMember toInstaMember; // 메세지 받는 사람(호감 받는 사람)
    @ManyToOne
    @ToString.Exclude
    private InstaMember fromInstaMember; // 메세지를 발생시킨 행위를 한 사람(호감표시한 사람)
    private String typeCode; // 호감표시=Like, 호감사유변경=ModifyAttractiveType
    private String oldGender; // 해당사항 없으면 null
    private int oldAttractiveTypeCode; // 해당사항 없으면 0
    private String newGender; // 해당사항 없으면 null
    private int newAttractiveTypeCode; // 해당사항 없으면 0

    public String getTimeAgo() {
        Instant now = Instant.now();
        Duration duration;
        if (this.typeCode.equals("Like")) {
            duration = Duration.between(getCreateDate().atZone(ZoneId.systemDefault()).toInstant(), now);
        } else if (this.typeCode.equals("ModifyAttractiveType")) {
            duration = Duration.between(getModifyDate().atZone(ZoneId.systemDefault()).toInstant(), now);
        } else {
            duration = Duration.ZERO;
        }
        long seconds = duration.getSeconds();

        if (seconds < 60) {
            return seconds + "초 전";
        } else if (seconds < 60 * 60) {
            long minutes = seconds / 60;
            return minutes + "분 전";
        } else if (seconds < 60 * 60 * 24) {
            long hours = seconds / (60 * 60);
            return hours + "시간 전";
        } else {
            long days = seconds / (60 * 60 * 24);
            return days + "일 전";
        }
    }

}