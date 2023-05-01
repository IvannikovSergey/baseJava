import com.basejava.webapp.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

public class ResumeTestData {
    private static final String UUID_1 = String.valueOf(UUID.randomUUID());
    private static final Resume resume1 = new Resume(UUID_1, "Resume_Name1");
    private static final String UUID_2 = String.valueOf(UUID.randomUUID());
    private static final Resume resume2 = new Resume(UUID_2, "name2");
    private static final String UUID_3 = String.valueOf(UUID.randomUUID());
    private static final Resume resume3 = new Resume(UUID_3, "name3");
    private static final String UUID_4 = String.valueOf(UUID.randomUUID());
    private static final Resume resume4 = new Resume(UUID_4, "name4");

    public static void main(String[] args) {
        resume1.setContact(ContactType.HOME_PHONE, "+7(921) 855-0482");
        resume1.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume1.setContact(ContactType.MAIL, "gkislin@yandex.ru");

        resume1.setSection(SectionType.OBJECTIVE, new TextSection("Java developer"));
        resume1.setSection(SectionType.ACHIEVEMENT, new ListSection(
                "Организация команды и успешная реализация Java проектов",
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM."));
        resume1.setSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy"));
        resume1.setSection(SectionType.EXPIERIENCE, new CompanySection(
                new Company("http:\\abc.ru",
                        "Java online Project", new Company.Period(LocalDate.of(2020,Month.APRIL, 10),LocalDate.now(),"\n" +
                                "Автор проекта.",
                                "Создание, организация и проведение Java онлайн проектов и стажировок."))));

        System.out.println(resume1.getContact(ContactType.HOME_PHONE));
        System.out.println(resume1.getContact(ContactType.SKYPE));
        System.out.println(resume1.getContact(ContactType.MAIL));

        System.out.println(resume1.getSection(SectionType.OBJECTIVE));
        System.out.println(resume1.getSection(SectionType.ACHIEVEMENT));
        System.out.println(resume1.getSection(SectionType.QUALIFICATIONS));
        System.out.println(resume1.getSection(SectionType.EXPIERIENCE));
    }
}
