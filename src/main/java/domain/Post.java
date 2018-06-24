package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors(chain = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    private Contact contact;

    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;

//    public LocalDate getSendTime() {
//        return sendTime;
//    }

    public Post setSendTimeLocalDate(LocalDate sendTime) {
        Date date = Date.from(sendTime.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.sendTime = date;
        return this;
    }

}
