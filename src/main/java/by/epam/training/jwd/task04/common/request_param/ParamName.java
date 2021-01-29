package by.epam.training.jwd.task04.common.request_param;

public enum ParamName {

    LENGTH("len"),
    SYMBOL("symbol"),
    WORDS("words"),
    CHAR_ONE("char1"),
    CHAR_TWO("char2"),
    SUBSTRING("substr");

    public final String val;

    ParamName(String val){
        this.val = val;
    }
}
