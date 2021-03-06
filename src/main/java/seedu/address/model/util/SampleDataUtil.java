package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.EventBook;
import seedu.address.model.ExpenseBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyEventBook;
import seedu.address.model.ReadOnlyExpenseBook;
import seedu.address.model.ReadOnlyTaskBook;
import seedu.address.model.TaskBook;
import seedu.address.model.event.Date;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventName;
import seedu.address.model.event.Time;
import seedu.address.model.eventContacts.EventContacts;
import seedu.address.model.expense.Expense;
import seedu.address.model.expense.ExpenseCategory;
import seedu.address.model.expense.ExpenseDate;
import seedu.address.model.expense.ExpenseValue;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Body;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskName;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    //@@author ChenSongJian
    public static Expense[] getSampleExpenses() {
        return new Expense[] {
            new Expense(new ExpenseCategory("shopping"), new ExpenseDate("11/11/2018"), new ExpenseValue("99.80"),
                    getTagSet("taobao")),
            new Expense(new ExpenseCategory("Food"), new ExpenseDate("11/11/2018"), new ExpenseValue("11.11"),
                    getTagSet("lunch", "doubleSamurai")),
            new Expense(new ExpenseCategory("Food"), new ExpenseDate("11/11/2018"), new ExpenseValue("11.11"),
                    getTagSet("dinner", "grass")),
            new Expense(new ExpenseCategory("transport"), new ExpenseDate("01/11/2018"), new ExpenseValue("45.00"),
                    getTagSet("concession")),
            new Expense(new ExpenseCategory("bill"), new ExpenseDate("01/11/2018"), new ExpenseValue("30.00"),
                    getTagSet("phone")),
            new Expense(new ExpenseCategory("transport"), new ExpenseDate("11/11/2018"), new ExpenseValue("11.11"),
                    getTagSet("Grab", "training")),
            new Expense(new ExpenseCategory("transport"), new ExpenseDate("01/10/2018"), new ExpenseValue("45.00"),
                    getTagSet("concession")),
            new Expense(new ExpenseCategory("Movie"), new ExpenseDate("11/10/2018"), new ExpenseValue("14.00"),
                    getTagSet("Avengers")),
            new Expense(new ExpenseCategory("bill"), new ExpenseDate("01/10/2018"), new ExpenseValue("55.55"),
                    getTagSet("phone", "exceed2GB")),
            new Expense(new ExpenseCategory("transport"), new ExpenseDate("01/09/2018"), new ExpenseValue("45.00"),
                    getTagSet("concession")),
            new Expense(new ExpenseCategory("bill"), new ExpenseDate("01/08/2018"), new ExpenseValue("30.00"),
                    getTagSet("phone")),
            new Expense(new ExpenseCategory("transport"), new ExpenseDate("01/07/2018"), new ExpenseValue("45.00"),
                    getTagSet("concession")),
            new Expense(new ExpenseCategory("bill"), new ExpenseDate("01/06/2018"), new ExpenseValue("30.00"),
                    getTagSet("phone"))
        };
    }

    public static ReadOnlyExpenseBook getSampleExpenseBook() {
        ExpenseBook sampleEb = new ExpenseBook();
        for (Expense sampleExpense : getSampleExpenses()) {
            sampleEb.addExpense(sampleExpense);
        }

        return sampleEb;
    }

    //@@author ian-tjahjono
    //================Events===============================
    public static Event[] getSampleEvent() {
        return new Event[] {
            new Event(new EventName("Watch Movie"), new Date("10/02/2018"), new Time("1500"),
                    getEventContactSet("John ")),
            new Event(new EventName("Dinner with class"), new Date("22/05/2018"), new Time("1900"),
                    getEventContactSet("S421 ")),
            new Event(new EventName("Carnival"), new Date("24/06/2018"), new Time("1830"),
                    getEventContactSet("Mike ")),
            new Event(new EventName("Concert"), new Date("10/08/2018"), new Time("1430"),
                    getEventContactSet("John "))
        };
    }

    public static ReadOnlyEventBook getSampleEventBook() {
        EventBook sampleEventBook = new EventBook();
        for (Event sampleEvent : getSampleEvent()) {
            sampleEventBook.addEvent(sampleEvent);
        }
        return sampleEventBook;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<EventContacts> getEventContactSet(String... strings) {
        return Arrays.stream(strings)
                .map(EventContacts::new)
                .collect(Collectors.toSet());
    }
    //@@author
    //@@author luhan02
    public static Task[] getSampleTasks() {
        return new Task[] {
            new Task(new TaskName("Submission"), new Body("CG2027 Assign2"),
                    new DateTime("12/10_17:00"), new DateTime("19/10_14:00"),
                    new Priority("HIGH"), getTagSet("IVLE")),
            new Task(new TaskName("Quiz Submission"), new Body("MA1508E Quiz9"),
                    new DateTime("15/10"), new DateTime("21/10_22:00"),
                    new Priority("MED"), getTagSet("IVLE")),
            new Task(new TaskName("Presentation"), new Body("GER1000 project presentation"),
                    new DateTime("16/11"), new DateTime("16/11_13:55"),
                    new Priority("MED"), getTagSet("IVLE")),
            new Task(new TaskName("PracticalExam"), new Body("CS2113 Product release"),
                    new DateTime("2/11_16:00"), new DateTime("2/11_16:00"),
                    new Priority("HIGH"), getTagSet("LT15")),
            new Task(new TaskName("Shopping"), new Body("Buy stationary at Clementi int"),
                    new DateTime("30/10_14:00"), new DateTime("30/10_14:00"),
                    new Priority("LOW"), getTagSet("MOM"))
        };
    }

    public static ReadOnlyTaskBook getSampleTaskBook() {
        TaskBook sampleAb = new TaskBook();
        for (Task sampleTask : getSampleTasks()) {
            sampleAb.addTask(sampleTask);
        }
        return sampleAb;
    }
    //@@author

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
