package schedule.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;

    private String scheduleId;

    private String scheduleTitle;
    
    private String scheduleDateTo;

	private String scheduleDateFrom;

    private boolean finished;

    private Date createdAt;

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleTitle() {
        return scheduleTitle;
    }

    public void setScheduleTitle(String scheduleTitle) {
        this.scheduleTitle = scheduleTitle;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getScheduleDateTo() {
		return scheduleDateTo;
	}

	public void setScheduleDateTo(String scheduleDateTo) {
		this.scheduleDateTo = scheduleDateTo;
	}

	public String getScheduleDateFrom() {
		return scheduleDateFrom;
	}

	public void setScheduleDateFrom(String scheduleDateFrom) {
		this.scheduleDateFrom = scheduleDateFrom;
	}
}