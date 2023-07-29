package workshop;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

class DeliveryMapperTest {

    private DeliveryMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = Mappers.getMapper(DeliveryMapper.class);
    }

    @Test
    public void testEntityToDto() {

        Delivery entity = new Delivery(UUID.randomUUID(), LocalDate.now(), "Chennai", "IN");

        DeliveryDTO dto = mapper.toDTO(entity);
        System.out.println("DTO: " + dto);
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(dto).isNotNull();
            soft.assertThat(dto.id()).isEqualTo(entity.getTrackId().toString());
            soft.assertThat(dto.when()).isEqualTo(entity.getWhen().toString());
            soft.assertThat(dto.city()).isEqualTo(entity.getCity());
            soft.assertThat(dto.country()).isEqualTo(entity.getCountry());
        });
    }

    @Test
    public void testDtoToEntity() {

        DeliveryDTO dto = new DeliveryDTO(UUID.randomUUID().toString(), LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE), "Chennai", "IN");

        Delivery entity = mapper.toEntity(dto);
        System.out.println("Entity: " + entity.toString());
        SoftAssertions.assertSoftly(soft -> {
            soft.assertThat(entity).isNotNull();
            soft.assertThat(entity.getTrackId().toString()).isEqualTo(dto.id());
            soft.assertThat(entity.getWhen().toString()).isEqualTo(dto.when());
            soft.assertThat(entity.getCity()).isEqualTo(dto.city());
            soft.assertThat(entity.getCountry()).isEqualTo(dto.country());
        });
    }
}