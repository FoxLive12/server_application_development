import java.util.Arrays;
import java.util.Comparator;

public class Phone {
    private Integer id;
    private String surname;
    private String name;
    private String middle_name;
    private String address;
    private Integer credit_card_num;
    private Boolean debit; // к сожалению не понял какую имнно информацию нужно вносить в дебет и кредит
    private Boolean credit;
    private Integer time_in;
    private Integer time_out;

    public Phone(
            Integer id,
            String surname,
            String name,
            String middle_name,
            String address,
            Integer credit_card_num,
            Integer time_in,
            Integer time_out
    ) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middle_name = middle_name;
        this.address = address;
        this.credit_card_num = credit_card_num;
        this.time_in = time_in;
        this.time_out = time_out;
    }

    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        phones[0] = new Phone(
                2,
                "Malygin",
                "Dmitriy",
                "Vladimirovich",
                "Kurchatova, 20",
                123456789,
                5,
                0

        );
        phones[1] = new Phone(
                1,
                "Zotov",
                "Kirill",
                "Yevgenievich",
                "Kurchatova, 22",
                987654321,
                7,
                3
        );
        for (int i = 0; i < phones.length - 1; i++) {
            if (phones[i].time_in < 7) {
                System.out.println(
                        phones[i].id + "\n" + phones[i].surname + "\n" + phones[i].name
                );
            }
            if (phones[i].time_out != 0) {
                System.out.println(
                        phones[i].id + "\n" + phones[i].surname + "\n" + phones[i].name
                );
            }
        }

        //сортировка по id
        for (int i = 0; i < phones.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (phones[j].id > phones[j + 1].id) {
                    Phone tmp = phones[j];
                    phones[j] = phones[j+1];
                    phones[j+1] = tmp;
                }
            }
        }
        System.out.println(phones[0].name);
        System.out.println(phones[1].name);
    }
}
