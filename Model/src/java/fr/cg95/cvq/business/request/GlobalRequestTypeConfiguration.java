package fr.cg95.cvq.business.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="global_request_type_configuration")
public class GlobalRequestTypeConfiguration {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(name="draft_live_duration",nullable=false)
    private int draftLiveDuration = 20;

    @Column(name="draft_notification_before_delete",nullable=false)
    private int draftNotificationBeforeDelete = 7;

    /**
     * Whether an email alert is sent to notify of requests whose instruction is late,
     * defaults to false.
     */
    @Column(name="instruction_alerts_enabled",nullable=false)
    private boolean instructionAlertsEnabled = false;

    /**
     * Whether, if instruction alerts are enabled, the email sent displays a detailed resume of
     * requests to instruct, defaults to false.
     */
    @Column(name="instruction_alerts_detailed",nullable=false)
    private boolean instructionAlertsDetailed = false;

    @Column(name="instruction_alert_delay",nullable=false)
    private int instructionAlertDelay = 3;

    @Column(name="instruction_max_delay",nullable=false)
    private int instructionMaxDelay = 10;

    /**
     * The max lifetime of a request modification lock before it can be discarded (in minutes)
     */
    @Column(name="request_lock_max_delay",nullable=false)
    private int requestLockMaxDelay = 30;

    /**
     * Whether an email alert is sent to notify of newly created requests, defaults to false.
     */
    @Column(name="requests_creation_notification_enabled",nullable=false)
    private boolean requestsCreationNotificationEnabled = false;

    @Column(name="archives_password")
    private String archivesPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDraftLiveDuration() {
        return draftLiveDuration;
    }

    public void setDraftLiveDuration(int draftLiveDuration) {
        this.draftLiveDuration = draftLiveDuration;
    }

    public int getDraftNotificationBeforeDelete() {
        return draftNotificationBeforeDelete;
    }

    public void setDraftNotificationBeforeDelete(int draftNotificationBeforeDelete) {
        this.draftNotificationBeforeDelete = draftNotificationBeforeDelete;
    }

    public boolean isRequestsCreationNotificationEnabled() {
        return requestsCreationNotificationEnabled;
    }

    public void setRequestsCreationNotificationEnabled(boolean requestsCreationNotificationEnabled) {
        this.requestsCreationNotificationEnabled = requestsCreationNotificationEnabled;
    }

    public boolean isInstructionAlertsEnabled() {
        return instructionAlertsEnabled;
    }

    public void setInstructionAlertsEnabled(boolean instructionAlertsEnabled) {
        this.instructionAlertsEnabled = instructionAlertsEnabled;
    }

    public boolean isInstructionAlertsDetailed() {
        return instructionAlertsDetailed;
    }

    public void setInstructionAlertsDetailed(boolean instructionAlertsDetailed) {
        this.instructionAlertsDetailed = instructionAlertsDetailed;
    }

    public int getInstructionMaxDelay() {
        return instructionMaxDelay;
    }

    public void setInstructionMaxDelay(int instructionMaxDelay) {
        this.instructionMaxDelay = instructionMaxDelay;
    }

    public int getInstructionAlertDelay() {
        return instructionAlertDelay;
    }

    public void setInstructionAlertDelay(int instructionAlertDelay) {
        this.instructionAlertDelay = instructionAlertDelay;
    }

    public int getRequestLockMaxDelay() {
        return requestLockMaxDelay;
    }

    public void setRequestLockMaxDelay(int requestLockMaxDelay) {
        this.requestLockMaxDelay = requestLockMaxDelay;
    }

    public String getArchivesPassword() {
        return archivesPassword;
    }

    public void setArchivesPassword(String archivesPassword) {
        this.archivesPassword = archivesPassword;
    }
}
