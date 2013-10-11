package models;

import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.jpa.JPA;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Shmulik
 * Date: 11/10/13
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */

@Entity
@SequenceGenerator(name = "project_seq", sequenceName = "project_seq")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String description;

    public int votes;


    /**
     * Find a project by id.
     */
    public static Project findById(Long id) {
        return JPA.em().find(Project.class, id);
    }


    public static final List<Project> findAll(){

        return JPA.em().createQuery("from Project").getResultList();

    }

    /**
     * Update this computer.
     */
    public void update(Long id) {
        this.id = id;
        JPA.em().merge(this);
    }

    /**
     * Insert this new computer.
     */
    public void save() {
        JPA.em().persist(this);
    }

    /**
     * Delete this computer.
     */
    public void delete() {
        JPA.em().remove(this);
    }
}
