package schedule.domain.repository.schedule;

import java.util.Collection;

import schedule.domain.model.Schedule;

public interface ScheduleRepository {
	Schedule findOne(String scheduleId);

    Collection<Schedule> findAll();

    void create(Schedule schedule);

    boolean update(Schedule schedule);

    void delete(Schedule schedule);

    long countByFinished(boolean finished);
}
