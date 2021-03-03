package com.tega.userservice.valueObject;

import com.tega.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateValueObject {

    private User user;
    private Department department;
}
