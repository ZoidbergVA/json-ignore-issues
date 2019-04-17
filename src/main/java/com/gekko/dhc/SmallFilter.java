package com.gekko.dhc;

import java.util.Arrays;

import org.springframework.core.MethodParameter;
import com.gekko.dhc.dto.UserDTO;

import com.jfilter.filter.DynamicFilterComponent;
import com.jfilter.filter.DynamicFilterEvent;
import com.jfilter.filter.FilterFields;
import com.jfilter.request.RequestSession;

@DynamicFilterComponent
public class SmallFilter implements DynamicFilterEvent {

    @Override
    public FilterFields onGetFilterFields(MethodParameter methodParameter, RequestSession request) {
        if (request.getRequest().getParameterMap().containsKey("small")) {
            return new FilterFields(UserDTO.class, Arrays.asList("id", "firstName"));
        } else
            return new FilterFields();
    }

}