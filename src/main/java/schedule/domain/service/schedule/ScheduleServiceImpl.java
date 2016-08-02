package schedule.domain.service.schedule;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import schedule.domain.model.Schedule;
import schedule.domain.repository.schedule.ScheduleRepository;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Inject
    ScheduleRepository scheduleRepository;

    public Schedule findOne(String scheduleId) {
    	Schedule schedule = scheduleRepository.findOne(scheduleId);
        if (schedule == null) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E404] The requested Schedule is not found. (id="
                            + scheduleId + ")"));
             throw new ResourceNotFoundException(messages);
        }
        return schedule;
    }

    @Override
    @Transactional(readOnly = true) 
    public Collection<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule create(Schedule schedule) {

        String scheduleId = UUID.randomUUID().toString();
        Date createdAt = new Date();

        schedule.setScheduleId(scheduleId);
        schedule.setCreatedAt(createdAt);
        schedule.setFinished(false);

        scheduleRepository.create(schedule);
        return schedule;
    }

    @Override
    public Schedule finish(String scheduleId) {
    	Schedule schedule = findOne(scheduleId);
        if (schedule.isFinished()) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E002] The requested Todo is already finished. (id="
                            + scheduleId + ")"));
            throw new BusinessException(messages);
        }
        schedule.setFinished(true);
        scheduleRepository.update(schedule);
        return schedule;
    }

    @Override
    public void delete(String scheduleId) {
    	Schedule schedule = findOne(scheduleId);
    	scheduleRepository.delete(schedule);
    }

}
