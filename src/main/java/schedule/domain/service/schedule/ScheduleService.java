package schedule.domain.service.schedule;

import java.util.Collection;

import schedule.domain.model.Schedule;

public interface ScheduleService {
    Collection<Schedule> findAll();

    Schedule create(Schedule schedule);

    Schedule finish(String scheduleId);

    void delete(String scheduleId);

	
}
