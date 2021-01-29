package by.epam.training.jwd.task04.client.controller.request_builder.impl;

import by.epam.training.jwd.task04.bean.network.ClientRequest;
import by.epam.training.jwd.task04.client.controller.request_builder.RequestBuilder;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilderImpl implements RequestBuilder {

    @Override
    public ClientRequest requestForTask0() {
        return new ClientRequest(0);
    }

    @Override
    public ClientRequest requestForTask1() {
        return new ClientRequest(1);
    }

    @Override
    public ClientRequest requestForTask2() {
        return new ClientRequest(2);
    }

    @Override
    public ClientRequest requestForTask3() {
        return new ClientRequest(3);
    }

    @Override
    public ClientRequest requestForTask4(int len) {
        Map<String, Object> params = new HashMap<>();
        params.put("len", len);
        return new ClientRequest(4, params);
    }

    @Override
    public ClientRequest requestForTask5() {
        return new ClientRequest(5);
    }

    @Override
    public ClientRequest requestForTask6() {
        return new ClientRequest(6);
    }

    @Override
    public ClientRequest requestForTask7() {
        return new ClientRequest(7);
    }

    @Override
    public ClientRequest requestForTask8() {
        return new ClientRequest(8);
    }

    @Override
    public ClientRequest requestForTask9(String symbol) {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        return new ClientRequest(9, params);
    }

    @Override
    public ClientRequest requestForTask10(String words) {
        Map<String, Object> params = new HashMap<>();
        params.put("words", words);
        return new ClientRequest(10, params);
    }

    @Override
    public ClientRequest requestForTask11(String ch1, String ch2) {
        Map<String, Object> params = new HashMap<>();
        params.put("char1", ch1);
        params.put("char2", ch2);
        return new ClientRequest(11, params);
    }

    @Override
    public ClientRequest requestForTask12(int len) {
        Map<String, Object> params = new HashMap<>();
        params.put("len", len);
        return new ClientRequest(12, params);
    }

    @Override
    public ClientRequest requestForTask13(String symbol) {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", symbol);
        return new ClientRequest(13, params);
    }

    @Override
    public ClientRequest requestForTask14() {
        return new ClientRequest(14);
    }

    @Override
    public ClientRequest requestForTask15() {
        return new ClientRequest(15);
    }

    @Override
    public ClientRequest requestForTask16(int len, String substring) {
        Map<String, Object> params = new HashMap<>();
        params.put("len", len);
        params.put("substr", substring);
        return new ClientRequest(16, params);
    }

}
