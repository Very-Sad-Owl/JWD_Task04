package by.epam.training.jwd.task04.client.controller.request_builder;

import by.epam.training.jwd.task04.common.bean.network.ClientRequest;

public interface RequestBuilder {

    ClientRequest requestForTask0();
    ClientRequest requestForTask1();
    ClientRequest requestForTask2();
    ClientRequest requestForTask3();
    ClientRequest requestForTask4(int len);
    ClientRequest requestForTask5();
    ClientRequest requestForTask6();
    ClientRequest requestForTask7();
    ClientRequest requestForTask8();
    ClientRequest requestForTask9(String symbol);
    ClientRequest requestForTask10(String words);
    ClientRequest requestForTask11(String ch1, String ch2);
    ClientRequest requestForTask12(int len);
    ClientRequest requestForTask13(String symbol);
    ClientRequest requestForTask14();
    ClientRequest requestForTask15();
    ClientRequest requestForTask16(int len, String substring);
}
