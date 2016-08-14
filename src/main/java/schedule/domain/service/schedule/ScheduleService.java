package schedule.domain.service.schedule;

import java.util.Collection;

import schedule.domain.model.Schedule;

public interface ScheduleService {
    Collection<Schedule> findAll();

    Schedule findOne(String scheduleId);
    
    Schedule create(Schedule schedule);

    Schedule finish(String scheduleId);

    void delete(String scheduleId);

	
}
