package com.ngteam.toastapp.dto.mapper;

import com.ngteam.toastapp.dto.in.EventDto;
import com.ngteam.toastapp.dto.out.EventOutDto;
import com.ngteam.toastapp.model.Event;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    @Autowired
    EventTypeMapper eventTypeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CategoryMapper categoryMapper;

    public Event toEventConverter(EventDto eventDto) {
        return toEventConverter(eventDto, new Event());
    }

    public Event toEventConverter(EventDto eventDto, Event event) {
        event.setId(event.getId());
        event.setName(event.getName());
        return event;
    }

    @SneakyThrows
    public EventOutDto toEventOutDtoConvert(Event event) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = sdf.format(event.getDate());
        EventOutDto eventOutDto = EventOutDto.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .date(stringDate)
                .category(categoryMapper.toCategoryDtoConvert(event.getCategory()))
                .eventType(eventTypeMapper.toEventTypeDtoConvert(event.getEventType()))
                .user(userMapper.toUserDtoOut(event.getUser()))
                .build();
        System.out.println(event.getDate());
//        EventOutDto eventOutDto = new EventOutDto();
//        eventOutDto.setId(event.getId());
//        eventOutDto.setName(event.getName());
//        eventOutDto.setDescription(event.getDescription());
//        eventOutDto.setDate(event.getDate());
////        eventOutDto.setEventType(eventTypeMapper.toEventTypeDtoConvert(event.getEventType()));
//        eventOutDto.setCategory(categoryMapper.toCategoryDtoConvert(event.getCategory()));
//        eventOutDto.setUser(userMapper.toUserDtoOut(event.getUser()));
        return eventOutDto;
    }

/*      //autizm with flague//

    public EventTypeOutDto toEventTypeOutDtoConvert(EventType eventType, boolean flag) {
        EventTypeOutDto eventTypeOutDto = new EventTypeOutDto();
        eventTypeOutDto.setId(eventType.getId());
        eventTypeOutDto.setName(eventType.getName());
        if(flag == true) {
            eventTypeOutDto.setEvents(
                    eventType.getEvents()
                            .stream()
                            .map(event -> event.getName() + " id " + event.getId())
                            .collect(Collectors.toList())
            );
        }
        return eventTypeOutDto;
    }
*/

    public List<Event> toEventList(List<EventDto> eventDtos) {
        return eventDtos
                .stream()
                .map(this::toEventConverter)
                .collect(Collectors.toList());
    }

    public List<EventOutDto> toEventDtoList(List<Event> events) {
        System.out.println(events
                .stream()
                .map(this::toEventOutDtoConvert)
                .collect(Collectors.toList()));
        return events
                .stream()
                .map(this::toEventOutDtoConvert)
                .collect(Collectors.toList());
    }
}

