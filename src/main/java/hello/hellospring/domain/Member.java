package hello.hellospring.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 채번 (시퀀스)
    private Long id;
    private String name;
}
