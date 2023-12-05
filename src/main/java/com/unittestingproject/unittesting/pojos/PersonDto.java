package com.unittestingproject.unittesting.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {
    private String fName;
    private String lName;
    private String email;
    private String cityName;
}
