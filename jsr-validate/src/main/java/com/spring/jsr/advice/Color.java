package com.spring.jsr.advice;

import com.spring.jsr.domain.Colors;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author a
 * @since 17:55
 **/
@Constraint(validatedBy = ColorConstraintValidator.class)
@Documented
@Target({ElementType.METHOD, ElementType.FIELD,
        ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Color {
    // 错误提示信息
    String message() default "颜色不符合规格";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 约束的类型
    Colors[] value();
}
