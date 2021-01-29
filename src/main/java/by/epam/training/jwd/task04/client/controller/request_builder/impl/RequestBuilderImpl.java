package by.epam.training.jwd.task04.client.controller.request_builder.impl;

import by.epam.training.jwd.task04.bean.params_config.ParamName;
import by.epam.training.jwd.task04.bean.network.ClientRequest;
import by.epam.training.jwd.task04.client.controller.request_builder.RequestBuilder;

import static by.epam.training.jwd.task04.bean.params_config.ParamName.*;
import static by.epam.training.jwd.task04.bean.params_config.TaskNum.*;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilderImpl implements RequestBuilder {

    @Override
    public ClientRequest requestForTask0() {
        return new ClientRequest(GET_TEXT);
    }

    @Override
    public ClientRequest requestForTask1() {
        return new ClientRequest(TASK_1);
    }

    @Override
    public ClientRequest requestForTask2() {
        return new ClientRequest(TASK_2);
    }

    @Override
    public ClientRequest requestForTask3() {
        return new ClientRequest(TASK_3);
    }

    @Override
    public ClientRequest requestForTask4(int len) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(LENGTH, len);
        return new ClientRequest(TASK_4, params);
    }

    @Override
    public ClientRequest requestForTask5() {
        return new ClientRequest(TASK_5);
    }

    @Override
    public ClientRequest requestForTask6() {
        return new ClientRequest(TASK_6);
    }

    @Override
    public ClientRequest requestForTask7() {
        return new ClientRequest(TASK_7);
    }

    @Override
    public ClientRequest requestForTask8() {
        return new ClientRequest(TASK_8);
    }

    @Override
    public ClientRequest requestForTask9(String symbol) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(SYMBOL, symbol);
        return new ClientRequest(TASK_9, params);
    }

    @Override
    public ClientRequest requestForTask10(String words) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(WORDS, words);
        return new ClientRequest(TASK_10, params);
    }

    @Override
    public ClientRequest requestForTask11(String ch1, String ch2) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(CHAR_ONE, ch1);
        params.put(CHAR_TWO, ch2);
        return new ClientRequest(TASK_11, params);
    }

    @Override
    public ClientRequest requestForTask12(int len) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(LENGTH, len);
        return new ClientRequest(TASK_12, params);
    }

    @Override
    public ClientRequest requestForTask13(String symbol) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(SYMBOL, symbol);
        return new ClientRequest(TASK_13, params);
    }

    @Override
    public ClientRequest requestForTask14() {
        return new ClientRequest(TASK_14);
    }

    @Override
    public ClientRequest requestForTask15() {
        return new ClientRequest(TASK_15);
    }

    @Override
    public ClientRequest requestForTask16(int len, String substring) {
        Map<ParamName, Object> params = new HashMap<>();
        params.put(LENGTH, len);
        params.put(SUBSTRING, substring);
        return new ClientRequest(TASK_16, params);
    }

}
