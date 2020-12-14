package ai.elimu.model.contributor;

import ai.elimu.model.BaseEntity;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * An event where a {@link Contributor} peer-reviews a {@link Audio} which 
 * was added/edited by another {@link Contributor}.
 */
@Entity
public class AudioPeerReviewEvent extends BaseEntity {

    @NotNull
    @ManyToOne
    private Contributor contributor;
    
    /**
     * The contribution event which is being peer-reviewed.
     */
    @NotNull
    @ManyToOne
    private AudioContributionEvent audioContributionEvent;
    
    /**
     * Whether or not the {@link #audioContributionEvent} was approved.
     */
    @NotNull
    private Boolean approved;
    
    /**
     * Any additional explanations. This field is mandatory only if the 
     * {@link #audioContributionEvent} was <i>not</i> approved.
     */
    private String comment;
    
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar time;

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public AudioContributionEvent getAudioContributionEvent() {
        return audioContributionEvent;
    }

    public void setAudioContributionEvent(AudioContributionEvent audioContributionEvent) {
        this.audioContributionEvent = audioContributionEvent;
    }

    public Boolean isApproved() {
        return approved;
    }

    public void setApproved(Boolean isApproved) {
        this.approved = isApproved;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
}