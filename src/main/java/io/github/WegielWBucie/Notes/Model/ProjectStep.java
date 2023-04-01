package io.github.WegielWBucie.Notes.Model;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT_STEPS")
class ProjectStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long ID;
    protected String title;
    protected String content;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    public Long getID() {
        return ID;
    }

    void setID(final Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    void setTitle(final String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    void setContent(final String content) {
        this.content = content;
    }

    Project getProject() {
        return project;
    }

    void setProject(final Project project) {
        this.project = project;
    }
}