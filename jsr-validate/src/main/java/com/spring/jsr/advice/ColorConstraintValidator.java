package com.spring.jsr.advice;


import com.spring.jsr.domain.Colors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author a
 * @since 17:57
 **/
public class ColorConstraintValidator implements ConstraintValidator<Color, String> {
    private static final Set<String> COLOR_CONSTRAINTS = new HashSet<>();

    @Override
    public void initialize(Color constraintAnnotation) {
        Colors[] value = constraintAnnotation.value();
        List<String> list = Arrays.stream(value)
                .map(Enum::name)
                .collect(Collectors.toList());
        COLOR_CONSTRAINTS.addAll(list);

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return COLOR_CONSTRAINTS.contains(value);
    }
}
