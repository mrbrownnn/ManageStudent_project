package com.fpt.booking.common;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CommonMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CommonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T,S> S convertToEntity(T data, Class<S> type) {
        return modelMapper.map(data,type);
    }

    public <T, S> S convertToResponse(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }

    public <T, S> List<S> convertToResponseList(List<T> lists, Class<S> type) {
        if (Objects.isNull(lists) || lists.isEmpty()) {
            return Collections.emptyList();
        }
        return lists.stream()
                .map(list -> convertToResponse(list, type))
                .collect(Collectors.toList());
    }

    public <T, S> Page<S> convertToResponsePage(Page<T> page, Class<S> type, Pageable pageable) {
        return new PageImpl<>(convertToResponseList(page.getContent(), type), pageable, page.getTotalElements());
    }

    public <T, S> S convertToEntityStrict(T data, Class<S> type) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(data, type);
    }

    public <T, S> List<S> convertToEntityList(List<T> lists, Class<S> type) {
        return lists.stream()
                .map(list -> convertToResponse(list, type))
                .collect(Collectors.toList());
    }
}