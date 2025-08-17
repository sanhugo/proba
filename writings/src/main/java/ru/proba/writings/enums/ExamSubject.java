package ru.proba.writings.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * перечисление всех экзаменов
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExamSubject {
    // Обязательные
    RUSSIAN_LANGUAGE("Русский язык", ExamType.EGE),
    RUSSIAN_OGE("Русский язык",  ExamType.OGE),
    MATHEMATICS_BASIC("Математика базовая", ExamType.EGE),
    MATHEMATICS_PROFILE("Математика профильная", ExamType.EGE),
    MATHEMATICS("Математика", ExamType.OGE),

    // ЕГЭ — предметы по выбору
    PHYSICS("Физика", ExamType.EGE),
    CHEMISTRY("Химия", ExamType.EGE),
    BIOLOGY("Биология", ExamType.EGE),
    COMPUTER_SCIENCE("Информатика", ExamType.EGE),
    HISTORY("История", ExamType.EGE),
    SOCIAL_STUDIES("Обществознание", ExamType.EGE),
    GEOGRAPHY("География", ExamType.EGE),
    LITERATURE("Литература", ExamType.EGE),
    ENGLISH("Английский язык", ExamType.EGE),
    ENGLISH_SPEAKING("Английский язык (говорение)", ExamType.EGE),
    GERMAN("Немецкий язык", ExamType.EGE),
    FRENCH("Французский язык", ExamType.EGE),
    SPANISH("Испанский язык", ExamType.EGE),
    CHINESE("Китайский язык", ExamType.EGE),

    // ОГЭ — предметы по выбору
    PHYSICS_OGE("Физика", ExamType.OGE),
    CHEMISTRY_OGE("Химия", ExamType.OGE),
    BIOLOGY_OGE("Биология", ExamType.OGE),
    COMPUTER_SCIENCE_OGE("Информатика", ExamType.OGE),
    HISTORY_OGE("История", ExamType.OGE),
    SOCIAL_STUDIES_OGE("Обществознание", ExamType.OGE),
    GEOGRAPHY_OGE("География", ExamType.OGE),
    LITERATURE_OGE("Литература", ExamType.OGE),
    ENGLISH_OGE("Английский язык", ExamType.OGE),
    GERMAN_OGE("Немецкий язык", ExamType.OGE),
    FRENCH_OGE("Французский язык", ExamType.OGE),
    SPANISH_OGE("Испанский язык", ExamType.OGE),
    CHINESE_OGE("Китайский язык", ExamType.OGE);

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
