package ru.proba.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.proba.enums.Subject;

@Converter(autoApply = true)
public class SubjectConverter implements AttributeConverter<Subject, String> {
    @Override
    public String convertToDatabaseColumn(Subject subject) {
        return "";
    }

    @Override
    public Subject convertToEntityAttribute(String s) {
        return null;
    }
}
