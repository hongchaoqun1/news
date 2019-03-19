package models.DO;/**
 * Create by hongcq on 2019/3/19
 */

import java.sql.Date;

/**
 *@Description TODO
 *@author cp
 *@date 2019/3/19 12:12
 *@ClassName JobDO
 */
public class JobDO {
    private Integer id;

    private String name;

    private Date releaseDate;

    private Long term;

    private String requirements;

    private String descriptions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
