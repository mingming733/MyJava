/**
 * Created by mming on 9/26/17.
 */
public enum PaymentCardTypeEnum {

    CREDIT(1, "Credit"),
    DEBIT(2, "Debit"),
    PREPAID(3, "Prepaid");

    private Integer id;

    private String name;

    PaymentCardTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
