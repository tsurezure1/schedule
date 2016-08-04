package schedule.app.schedule;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ScheduleForm implements Serializable {
	
    public static interface ScheduleCreate {
    };

    public static interface ScheduleFinish {
    };
    
    public static interface ScheduleDelete {
    }

	private static final long serialVersionUID = 1L;
	
    @NotNull(groups = { ScheduleFinish.class, ScheduleDelete.class })
    private String scheduleId;
	
    @NotNull(groups = { ScheduleCreate.class })
    @Size(min = 1, max = 30, groups = { ScheduleCreate.class })
	private String scheduleTitle;
    
    @Size(max = 256, groups = { ScheduleCreate.class })
    private String scheduleInfo;
    
    @NotNull(groups = { ScheduleCreate.class })
    @Size(min = 12, max = 12, groups = { ScheduleCreate.class })
	private String scheduleDateFrom;
    
    @NotNull(groups = { ScheduleCreate.class })
    @Size(min = 12, max = 12, groups = { ScheduleCreate.class })
	private String scheduleDateTo;
    
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

	public String getScheduleDateFrom() {
		return scheduleDateFrom;
	}

	public void setScheduleDateFrom(String scheduleDateFrom) {
		this.scheduleDateFrom = scheduleDateFrom;
	}

	public String getScheduleDateTo() {
		return scheduleDateTo;
	}

	public void setScheduleDateTo(String scheduleDateTo) {
		this.scheduleDateTo = scheduleDateTo;
	}

	public String getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(String scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}
    
    
    
}
