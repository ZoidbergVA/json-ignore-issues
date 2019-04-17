package com.gekko.dhc.controller;

import com.gekko.dhc.dto.UserDTO;
import com.gekko.dhc.SmallFilter;
import com.jfilter.filter.DynamicFilter;
import com.jfilter.filter.FieldFilterSetting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "", description = "")
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @FieldFilterSetting(fields = {"firstName"})
    @ApiOperation(value = "")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, ResponseEntity<UserDTO>> findOne(
            @ApiParam(required = true) @PathVariable(name = "id") Integer id) {
        Map<String, ResponseEntity<UserDTO>> response = new HashMap<>();
        response.put("message", new ResponseEntity<UserDTO>(new UserDTO(1, "First", "last", LocalDateTime.of(2012, 10, 22, 20, 10, 5)), HttpStatus.OK));
        return response;
    }

    @DynamicFilter(SmallFilter.class)
    @ApiOperation(notes = "", code = 200, value = "")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(
            @ApiParam(required = true, name = "parameters", value = "") @RequestParam(required = true) Map<String, String> parameters) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<UserDTO> userDTOList = Arrays.asList(new UserDTO(2, "First", "Last", LocalDateTime.MIN), new UserDTO(3, "First", "Last", LocalDateTime.MAX));
        map.put("users", userDTOList);
        ResponseEntity<Map<String, Object>> response = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        return response;
    }

}
