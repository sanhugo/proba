package ru.proba.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExamSubject {
        RUSSIAN_LANGUAGE("Русский язык", ExamType.BOTH),
        MATHEMATICS_BASIC("Математика базовая", ExamType.EGE),
        MATHEMATICS_PROFILE("Математика профильная", ExamType.EGE),
        MATHEMATICS("Математика", ExamType.OGE),
        PHYSICS("Физика", ExamType.EGE),
        PHYSICS_OGE("Физика", ExamType.OGE);

        private final String displayName;
        private final ExamType examType;

        ExamSubject(String displayName, ExamType examType) {
            this.displayName = displayName;
            this.examType = examType;
        }

        @JsonProperty("name")
        public String getName() {
            return name();
        }

        @JsonProperty("displayName")
        public String getDisplayName() {
            return displayName;
        }

        @JsonProperty("examType")
        public ExamType getExamType() {
            return examType;
        }

        /**
         * Позволяет принимать JSON вида "MATHEMATICS_PROFILE" в @RequestBody.
         */
        @JsonCreator
        public static ExamSubject fromString(String value) {
            return ExamSubject.valueOf(value);
        }

}
