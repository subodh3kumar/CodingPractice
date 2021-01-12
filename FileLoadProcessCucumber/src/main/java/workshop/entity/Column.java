package workshop.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;

@Slf4j
@Entity
public class Column {

    @Id
    private Long id;

}
