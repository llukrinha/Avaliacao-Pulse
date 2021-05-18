package com.AvaliacaoPulse.pulseavaliacao.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.beans.BeanUtils.copyProperties;

public class CommonUtil {

    private CommonUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <S, T> T copyValues(S source, T target, String... ignore) {
        List<String> ignoredProperties = getNullPropertyNames(source);
        ignoredProperties.addAll(Arrays.stream(ignore).collect(Collectors.toList()));
        copyProperties(source, target, ignoredProperties.toArray(new String[0]));
        return target;
    }


    private static List<String> getNullPropertyNames(Object source) {
            final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
            return Stream.of(wrappedSource.getPropertyDescriptors())
                    .map(FeatureDescriptor::getName)
                    .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                    .collect(Collectors.toList());
        }
    }