package by.epam.training.jwd.task04.client.view;

import by.epam.training.jwd.task04.bean.impl.composite.Text;

public interface View {
    void showResponse(Text response);
    void showTaskOptions();
    int readIntParam();
    String readStringParam();
    void showParamsInputRequest(String requiredParams);
}
