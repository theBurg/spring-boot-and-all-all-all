package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors(chain = true)
public class ContactList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "own", nullable = false)
    private Contact own;

    @ManyToOne
    @JoinColumn(name = "ref", nullable = false)
    private Contact ref;
}