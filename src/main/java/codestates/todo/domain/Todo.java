package codestates.todo.domain;

import lombok.*;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, name = "`order`")
    private Long todoOrder;

    @Column(nullable = false)
    private Boolean completed;
}
