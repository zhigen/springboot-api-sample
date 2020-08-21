package com.zglu.api.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 校验模式配置
 *
 * @author zglu
 */
@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
