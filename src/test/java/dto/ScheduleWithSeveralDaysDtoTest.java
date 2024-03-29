package dto;

import com.peoplespheres.dto.ScheduleWithSeveralDaysDTO;
import com.peoplespheres.enums.FlowScheduleFrequencyEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles(value = "databaseOnly")
@AutoConfigureTestDatabase
@DisplayName("Unit tests about the ScheduleWithSeveralDaysDto bean")
 class ScheduleWithSeveralDaysDtoTest {

    @Autowired
    private AdapterHelper helperClass;

    private ScheduleWithSeveralDaysDTO scheduleWithSeveralDaysDTO;

    @BeforeEach
    private void setUp() {
        scheduleWithSeveralDaysDTO = helperClass.getEntity_Helper("Entities/scheduleWithSeveralDays.json", ScheduleWithSeveralDaysDTO.class);
    }

    @Test
    @DisplayName("Test the getter and setter methods of scheduleWithSeveralDays DTO ")
    void getterAndSetterTest() {
        assertThat(scheduleWithSeveralDaysDTO.getStartDate()).isEqualTo("2022-01-01T00:00:00Z");
        assertThat(scheduleWithSeveralDaysDTO.getEndDate()).isEqualTo("2022-12-31T23:59:59Z");
        assertThat(scheduleWithSeveralDaysDTO.getIsMaintenance()).isFalse();
        assertThat(scheduleWithSeveralDaysDTO.getFrequency()).isEqualTo(FlowScheduleFrequencyEnum.WEEKLY);
        assertThat(scheduleWithSeveralDaysDTO.getExecutionTime()).isEqualTo("08:00:00");
        assertThat(scheduleWithSeveralDaysDTO.getFlowId()).isEqualTo(1);
        assertThat(scheduleWithSeveralDaysDTO.getClientId()).isEqualTo("33333330-3336-3331-2d33-3633312d3336");
        assertThat(scheduleWithSeveralDaysDTO.getSchedulesIds()).isEqualTo(Set.of(1L, 2L, 3L, 4L));
        assertThat(scheduleWithSeveralDaysDTO.getSelectDays()).isEqualTo(Set.of("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"));

    }
}
